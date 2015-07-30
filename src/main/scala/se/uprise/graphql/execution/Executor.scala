package se.uprise.graphql.execution

import org.antlr.v4.runtime.ParserRuleContext
import se.uprise.graphql.annotation.QLField
import se.uprise.graphql.error.{GraphQLError, GraphQLFormattedError}
import se.uprise.graphql.types._
import se.uprise.parser.GraphQlParser
import se.uprise.parser.GraphQlParser._
import scala.annotation.StaticAnnotation
import scala.collection.JavaConversions._
import scala.reflect.api.JavaUniverse
import scala.reflect.runtime._
import scala.reflect.runtime.universe


/**
 * Terminology
 *
 * "Definitions" are the generic name for top-level statements in the document.
 * Examples of this include:
 * 1) Operations (such as a query)
 * 2) Fragments
 *
 * "Operations" are a generic name for requests in the document.
 * Examples of this include:
 * 1) query,
 * 2) mutation
 *
 * "Selections" are the statements that can appear legally and at
 * single level of the query. These include:
 * 1) field references e.g "a"
 * 2) fragment "spreads" e.g. "...c"
 * 3) inline fragment "spreads" e.g. "...on Type { a }"
 */


/**
 * The result of execution. `data` is the result of executing the
 * query, `errors` is null if no errors occurred, and is a
 * non-empty array if an error occurred.
 */
// FIXME: root should not be type Any
case class ExecutionResult(data: Any, errors: List[GraphQLFormattedError])


object Executor {
  private val extractor = ValueExtractor

  def apply(schema: GraphQLSchema,
            root: Any,
            ast: DocumentContext,
            operationName: String,
            variableValues: Map[String, String] = Map.empty): ExecutionResult = {

    // FIXME: We cannot pass a immutable List of errors in the execution context
    val exeContext = buildExecutionContext(schema, root, ast, operationName, variableValues, List.empty)

    // FIXME: Result is currently Any
    val result = executeOperation(exeContext, root, exeContext.operation)

    ExecutionResult(result, List.empty)
  }

  /**
   * Implements the "Evaluating operations" section of the spec.
   */
  def executeOperation(exeContext: ExecutionContext,
                       root: Any,
                       operation: OperationDefinitionContext): Any = {

    val rootType = getOperationRootType(exeContext.schema, operation)

    val fields = collectFields(exeContext, rootType, operation.selectionSet())
    operation.operationType().getText match {
      case "mutation" => // executeFieldsSerially(exeContext, type, root, fields);
      case _ => executeFields(exeContext, rootType, root, fields)
    }
  }

  /**
   * Implements the "Evaluating selection sets" section of the spec
   * for "read" mode.
   */
  // FIXME: Better type than Any
  // FIXME: Support for futures
  def executeFields(exeContext: ExecutionContext,
                    parentType: GraphQLObjectType,
                    source: Any,
                    fields: Map[String, List[FieldContext]]): Any = {

    val finalResults = fields.keys.foldLeft(Map[String, Any]())((results: Map[String, Any], responseName) => {
      val fieldASTs = fields(responseName)
      val result = resolveField(exeContext, parentType, source, fieldASTs)
      // fields ++ Map(name -> merged)
      results ++ Map(responseName -> result)
    })

    finalResults
    //selectionSet.selection().foldLeft(fields)((result, selection) =>
    true
  }



  /**
   * Resolves the field on the given source object. In particular, this
   * figures out the value that the field returns by calling its resolve function,
   * then calls completeValue to complete promises, coerce scalars, or execute
   * the sub-selection-set for objects.
   */
  // FIXME: Better return type
  def resolveField(exeContext: ExecutionContext,
                   parentType: GraphQLObjectType,
                   source: Any,
                   fieldASTs: List[FieldContext]): Any = {
    val fieldAST = fieldASTs.head

    val fieldDef = getFieldDef(exeContext.schema, parentType, fieldAST)
    //val args: List[universe.Type] = resolveFn.typeSignature.typeArgs

    val parentTypeMirror = universe.runtimeMirror(getClass.getClassLoader).reflect(parentType)

    val args = extractor.getArgumentValues(
      fieldDef.args,
      fieldAST.arguments(),
      exeContext.variables)

    //val resolveFn = fieldDef.resolve
    val result = parentTypeMirror.reflectMethod(fieldDef.resolve)()
    result
  }

  /**
   * This method looks up the field on the given type defintion.
   * It has special casing for the two introspection fields, __schema
   * and __typename. __typename is special because it can always be
   * queried as a field, even in situations where no other fields
   * are allowed, like on a Union. __schema could get automatically
   * added to the query type, but that would require mutating type
   * definitions, which would cause issues.
   */

  //  def isAnnotatedWith(candidate: Class[_ <: GraphQLObjectType], annotation: Class[_ <: StaticAnnotation]) = {
  //    val typ: universe.ClassSymbol = universe.runtimeMirror(candidate.getClassLoader).classSymbol(candidate)
  //    val annotations: List[reflect.runtime.universe.Annotation] = typ.annotations
  //    val qlFieldAnnotationType = universe.typeOf[QLField]
  //    val annotation: Option[reflect.runtime.universe.Annotation] = annotations.find(a => a.tpe == qlFieldAnnotationType)
  //    annotation match {
  //      case Some(value) => true
  //      case _ => false
  //    }
  //  }



  def getFieldDef(schema: GraphQLSchema,
                  parentType: GraphQLObjectType,
                  fieldAST: FieldContext): GraphQLFieldDefinition = {
    val name = fieldAST.fieldName().NAME().getText

    //FIXME: Implement support for the introspection

    //parentType.get
    
    parentType.getFields(parentType)(name)
    //getFields(parentType)(name)
  }


  /**
   * Given a selectionSet, adds all of the fields in that selection to
   * the passed in map of fields, and returns it at the end.
   */
  def collectFields(exeContext: ExecutionContext,
                    typ: GraphQLObjectType,
                    selectionSet: SelectionSetContext,
                    fields: Map[String, List[FieldContext]] = Map.empty,
                    visitedFragmentNames: Map[String, Boolean] = Map.empty): Map[String, List[FieldContext]] = {

    selectionSet.selection().foldLeft(fields)((result, selection) =>

      // Check for field
      selection.field() match {
        case value: FieldContext =>
          shouldIncludeNode(exeContext, value.directives()) match {
            case false => fields
            case _ =>
              val name = getFieldEntryKey(value)
              val merged = List(value) ++ fields.getOrElse(name, List.empty)

              // The second key in the map will override the first one when merging
              fields ++ Map(name -> merged)
          }

        case _ =>

          // Check for inline fragment
          selection.inlineFragment() match {
            case value: InlineFragmentContext =>
              // FIXME: Possible logic bug, investigate
              (!shouldIncludeNode(exeContext, value.directives())
                || !doesFragmentConditionMatch(exeContext, selection, typ)) match {
                case false => fields
                case _ =>
                  collectFields(exeContext, typ, value.selectionSet(), fields, visitedFragmentNames)
              }
            case _ =>

              // Check for fragment spread
              selection.fragmentSpread() match {
                case value: FragmentSpreadContext =>
                  val fragName: String = value.fragmentName().NAME().getText

                  // FIXME: Possible logic bug, investigate
                  visitedFragmentNames.getOrElse(fragName, false) || !shouldIncludeNode(exeContext, value.directives()) match {
                    case false => fields
                    case _ =>
                      val fragment = exeContext.fragments(fragName)
                      fields

                    // FIXME: Implement
                  }
                case _ => throw new GraphQLError("Tried to run collectFields on unknown selection", List(selection))
              }
          }
      }
    )
  }

  /**
   * Determines if a fragment is applicable to the given type.
   */
  // FIXME: Implement properly
  def doesFragmentConditionMatch(exeContext: ExecutionContext,
                                 fragment: ParserRuleContext,
                                 typ: GraphQLObjectType): Boolean = {
    return true
  }

  /**
   * Implements the logic to compute the key of a given field’s entry
   */
  // FIXME: Not sure we cover aliases here, double check with breakpoint and test
  def getFieldEntryKey(node: FieldContext): String = {
    node.fieldName().getText
  }

  /**
   * Determines if a field should be included based on @if and @unless directives.
   */
  // FIXME: Implement properly
  def shouldIncludeNode(exeContext: ExecutionContext,
                        directives: DirectivesContext): Boolean = {

    // directives can produce null pointer
    directives match {
      case entry: DirectivesContext => true //entry.directive() map
      case _ => true
    }
  }

  /**
   * Extracts the root type of the operation from the schema.
   */
  def getOperationRootType(schema: GraphQLSchema,
                           operation: OperationDefinitionContext): GraphQLObjectType = {
    operation.operationType().getText match {
      case "query" => schema.query
      case "mutation" => schema.mutation match {
        case Some(mutation) => mutation
        case None => throw new GraphQLError("Schema is not configured for mutations", List(operation))
      }
      case _ => throw new GraphQLError("Can only execute queries and mutations", List(operation))
    }
  }

  /**
   * Constructs a ExecutionContext object from the arguments passed to
   * execute, which we will pass throughout the other execution methods.
   */
  // FIXME: root should perhaps not be type Any
  def buildExecutionContext(schema: GraphQLSchema,
                            root: Any,
                            ast: DocumentContext,
                            operationName: String,
                            variableValues: Map[String, String] = Map.empty,
                            errors: List[Exception]): ExecutionContext = {

    // Convert from Java to Scala
    val definitionSet: List[DefinitionContext] = ast.definition().toList

    // FIXME: Might be improved...
    val fragments: Map[String, FragmentDefinitionContext] = definitionSet flatMap { entry =>
      entry.fragmentDefinition() match {
        case value: FragmentDefinitionContext => Some(value.getText -> value)
        case _ => None
      }
    } toMap

    // FIXME: Might be improved...
    val operations: Map[String, OperationDefinitionContext] = definitionSet flatMap { entry =>
      entry.operationDefinition() match {
        case value: OperationDefinitionContext => Some(value.NAME().getText -> value)
        case _ => None
      }
    } toMap

    if (operationName.length == 0 && operations.size != 1) {
      throw new GraphQLError("Must provide operation name if query contains multiple operations")
    }

    val opName = operationName match {
      case name if name.length > 0 => name
      case _ => operations.head._1
    }

    val operation = operations.get(opName) match {
      case Some(entry) => entry
      case None => throw new GraphQLError("Unknown operation name: " + opName)
    }


    //    // directives can produce null pointer
    //    directives match {
    //      case entry: DirectivesContext => true //entry.directive() map
    //      case _ => true
    //    }

    // Might produce Null pointer if not handled
    val definitions = operation.variableDefinitions() match {
      case entry: VariableDefinitionsContext => entry.variableDefinition().toList
      case _ => List.empty
    }

    val variables = extractor.getVariableValues(schema,
      definitions,
      variableValues
    )

    ExecutionContext(schema, fragments, root, operation, variables, errors)
  }

}
