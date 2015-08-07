package se.uprise.graphql.execution

import org.antlr.v4.runtime.ParserRuleContext
import se.uprise.graphql.error.{GraphQLError, GraphQLFormattedError}
import se.uprise.graphql.types._
import se.uprise.parser.GraphQlParser._
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
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

    val exeContext = buildExecutionContext(schema, root, ast, operationName, variableValues, new ListBuffer[Exception]())

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
                    fields: Map[String, List[FieldContext]]): GraphQLOutputObjectType = {

    val finalResults = fields.keys.foldLeft(Map[String, GraphQLOutputType]())((results: Map[String, GraphQLOutputType], responseName) => {
      val fieldASTs = fields(responseName)
      val result = resolveField(exeContext, parentType, source, fieldASTs)
      // fields ++ Map(name -> merged)
      results ++ Map(responseName -> result)
    })

    new GraphQLOutputObjectType(finalResults)
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
                   fieldASTs: List[FieldContext]): GraphQLOutputType = {
    val fieldAST = fieldASTs.head

    val fieldDef = getFieldDef(exeContext.schema, parentType, fieldAST)
    //val args: List[universe.Type] = resolveFn.typeSignature.typeArgs

    val parentTypeMirror = universe.runtimeMirror(getClass.getClassLoader).reflect(parentType)

    val args = extractor.getArgumentValues(
      fieldDef.args,
      fieldAST.arguments(),
      exeContext.variables)

    //val resolveFn = fieldDef.resolve
    try {
      // FIXME: Add arguments to resolve method (x.toSeq:_*)
      val result = parentTypeMirror.reflectMethod(fieldDef.resolve)().asInstanceOf[GraphQLOutputType]
      completeValueCatchingError(exeContext, fieldASTs, result)
    } catch {
      case e: Exception =>
        // FIXME: Add support for NonNull fields and throw error if found

        // FIXME: Support for stack trace
        val reportedError = new GraphQLError(e.getMessage, fieldASTs)
        //fieldAST
        exeContext.errors += reportedError
        null // FIXME: Use Option for this?
    }
  }

  // FIXME: Better return type
  // FIXME: Better type for result

  import scala.reflect.runtime.universe._

  def completeValueCatchingError(exeContext: ExecutionContext,
                                 fieldASTs: List[FieldContext],
                                 result: GraphQLType): GraphQLOutputType = {

    // This is only for clarification when porting from JS
    val fieldType = result

    // If the field type is non-nullable, then it is resolved without any
    // protection from errors.


    fieldType match {

      case nonNull: GraphQLNonNull[_] => completeValue(exeContext, fieldASTs, result)

      case _ =>
        try {
          val completed = completeValue(exeContext, fieldASTs, result)
          // FIXME: Support for Thenable/Futures
          completed
        } catch {
          case e: Exception => exeContext.errors += e
            null // FIXME: Use Option for this?
        }
    }

  }


  /**
   * Implements the instructions for completeValue as defined in the
   * "Field entries" section of the spec.
   *
   * If the field type is Non-Null, then this recursively completes the value
   * for the inner type. It throws a field error if that completion returns null,
   * as per the "Nullability" section of the spec.
   *
   * If the field type is a List, then this recursively completes the value
   * for the inner type on each item in the list.
   *
   * If the field type is a Scalar or Enum, ensures the completed value is a legal
   * value of the type by calling the `coerce` method of GraphQL type definition.
   *
   * Otherwise, the field type expects a sub-selection set, and will complete the
   * value by evaluating all sub-selections.
   */
  def completeValue(exeContext: ExecutionContext,
                    fieldASTs: List[FieldContext],
                    result: GraphQLType): GraphQLOutputType = {
    // This is only for clarification when porting from JS
    val fieldType = result

    // FIXME: Support for Thenable/Futures
    fieldType match {
      case entry: GraphQLNonNull[_] =>
        val completed = completeValue(exeContext, fieldASTs, entry.item)
        if (completed == null) {
          throw new GraphQLError("Cannot return null for non-nullable type.", fieldASTs)
        }

        completed

      case entry: GraphQLList[_] =>
        val completedResults = entry.items map { item =>
          val completedValue = completeValueCatchingError(exeContext, fieldASTs, item)
          // FIXME: Check for Futures/isThenable
          completedValue
        }

        // FIXME: Not sure about this one
        new GraphQLList[GraphQLType](completedResults)

      case entry: GraphQLScalarType => entry

      case entry: GraphQLEnumType => entry.coerce

      // FIXME: We are skipping the resolveType piece here from the JS impl
      // FIXME: Do we need to do anything special for GraphQLInterfaceType or GraphQLUnionType
      case entry: GraphQLObjectType =>
        // Field type must be Object, Interface or Union and expect sub-selections.

        var subFieldASTs: Map[String, List[FieldContext]] = Map.empty
        val visitedFragmentNames: Map[String, Boolean] = Map.empty

        fieldASTs foreach { fieldAst =>
          val selectionSet = fieldAst.selectionSet()
          selectionSet match {
            case entry: SelectionSetContext =>
              subFieldASTs = collectFields(exeContext,
                null, // FIXME: Can we get rid of this one?
                selectionSet,
                subFieldASTs,
                visitedFragmentNames
              )
            case _ =>
          }

        }

        // TODO: Something if off in here when completing the object type

        // FIXME: Should we really pass "entry" as second argument?
        executeFields(exeContext, entry, result, subFieldASTs);

      case _ => throw new GraphQLError("Unknown field type when trying to complete value", fieldASTs)
    }
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
  def getFieldDef(schema: GraphQLSchema,
                  parentType: GraphQLObjectType,
                  fieldAST: FieldContext): GraphQLFieldDefinition = {
    val name = fieldAST.fieldName().NAME().getText

    //FIXME: Implement support for the introspection

    parentType.getFields(parentType)(name)
  }


  /**
   * Given a selectionSet, adds all of the fields in that selection to
   * the passed in map of fields, and returns it at the end.
   */
  def collectFields(exeContext: ExecutionContext,
                    typ: GraphQLObjectType, // FIXME: Can we get rid of this one?
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
  // FIXME: Can we get rid of the "typ" argument?
  def doesFragmentConditionMatch(exeContext: ExecutionContext,
                                 fragment: ParserRuleContext,
                                 typ: GraphQLObjectType): Boolean = {
    true // Placeholder value
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
                            errors: ListBuffer[Exception]): ExecutionContext = {

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
