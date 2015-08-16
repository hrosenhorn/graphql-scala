package se.uprise.graphql

import java.io.ByteArrayInputStream

import org.antlr.v4.runtime.{CommonTokenStream, ANTLRInputStream}
import se.uprise.graphql.error.GraphQLFormattedError
import se.uprise.graphql.execution.Executor
import se.uprise.parser.GraphQlParser.{DocumentContext, FieldContext}
import se.uprise.parser.{GraphQlBaseVisitor, GraphQlParser, GraphQlLexer}


import se.uprise.graphql.types.{GraphQLOutputObjectType, GraphQLSchema}


/**
 * The result of a GraphQL parse, validation and execution.
 *
 * `data` is the result of a successful execution of the query.
 * `errors` is included when any errors occurred as a non-empty array.
 */
case class GraphQLResult(data: GraphQLOutputObjectType, errors: List[GraphQLFormattedError])


/**
 * This is the primary entry point function for fulfilling GraphQL operations
 * by parsing, validating, and executing a GraphQL document along side a
 * GraphQL schema.
 *
 * More sophisticated GraphQL servers, such as those which persist queries,
 * may wish to separate the validation and execution phases to a static time
 * tooling step, and a server runtime step.
 */


// The rootObject seems to be some object/context you can pass along that will be available in all your resolve methods
object GraphQL {
  def apply(schema: GraphQLSchema,
            requestString: String,
            rootObject: Any,
            variableValues: Map[String, String],
            operationName: String
             ): GraphQLResult = {

    val input = new ANTLRInputStream(new ByteArrayInputStream(requestString.getBytes("UTF-8")))
    val lexer = new GraphQlLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new GraphQlParser(tokens)

    val document: DocumentContext = parser.document()

    val result = Executor(schema,
      rootObject,
      document,
      operationName,
      variableValues)

    // FIXME: Can we merge GraphQLResult and ExecutionResult?
    new GraphQLResult(result.data, result.errors)
  }
}
