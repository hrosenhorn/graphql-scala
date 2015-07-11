package se.uprise.graphql.execution

import se.uprise.graphql.error.{GraphQLError, GraphQLFormattedError}
import se.uprise.graphql.types.GraphQLSchema
import se.uprise.parser.GraphQlParser
import se.uprise.parser.GraphQlParser._
import scala.collection.JavaConversions._

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
  def apply(schema: GraphQLSchema,
            root: Any,
            ast: DocumentContext,
            operationName: String,
            variableValues: Map[String, String] = Map.empty): ExecutionResult = {

    // FIXME: We cannot pass a immutable List of errors in the execution context
    val exeContext = buildExecutionContext(schema, root, ast, operationName, variableValues, List.empty)

    // FIXME: Result is currently Any
    val result = executeOperation(exeContext, root, exeContext.operation)

    new ExecutionResult("FIXME", List.empty)
  }

  /**
   * Implements the "Evaluating operations" section of the spec.
   */
  def executeOperation(exeContext: ExecutionContext,
                        root: Any,
                        operation: OperationDefinitionContext): Any = {

  }


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
      entry.getRuleIndex match {
        case GraphQlParser.RULE_fragmentDefinition =>
          val fragment = entry.asInstanceOf[FragmentDefinitionContext]
          Some(fragment.fragmentName().NAME().getText -> fragment)
        case _ => None
      }
    } toMap

    // FIXME: Might be improved...
    val operations: Map[String, OperationDefinitionContext] = definitionSet flatMap { entry =>
      entry.getRuleIndex match {
        case GraphQlParser.RULE_operationDefinition =>
          val operation = entry.asInstanceOf[OperationDefinitionContext]
          Some(operation.NAME().getText -> operation)
        case _ => None
      }
    } toMap

    if (operationName.length > 0 && operations.size != 1) {
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

    val variables = getVariableValues(schema,
      operation.variableDefinitions().variableDefinition().toList,
      variableValues
    )

    ExecutionContext(schema, fragments, root, operation, variables, errors)
  }


  /**
   * Prepares an object map of variables of the correct type based on the provided
   * variable definitions and arbitrary input. If the input cannot be coerced
   * to match the variable definitions, a GraphQLError will be thrown.
   */
  /*
   FIXME: Replace Any types with proper Types resolved from the variableValues
   Ex: query Example($size: Int) {
   variableValues = { size: 100 }
    */

  def getVariableValues(schema: GraphQLSchema,
                        definitionASTs: List[VariableDefinitionContext] = List.empty,
                        variableValues: Map[String, String] = Map.empty): Map[String, Any] = {


    // FIXME: Implement
//    definitionASTs map { definition =>
//      val varName = definition.variable().NAME().getText
//    }

    Map.empty
  }

  def getVariableValue(schema: GraphQLSchema,
                       definitionAST: VariableDefinitionContext,
                        input: String) = {

  }
}
