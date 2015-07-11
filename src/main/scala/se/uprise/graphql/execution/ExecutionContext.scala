package se.uprise.graphql.execution

import se.uprise.graphql.types.GraphQLSchema
import se.uprise.parser.GraphQlParser.{OperationDefinitionContext, FragmentDefinitionContext}


/**
 * Data that must be available at all points during query execution.
 *
 * Namely, schema of the type system that is currently executing,
 * and the fragments defined in the query document
 */
// FIXME: root should not have type Any
// FIXME: Variables should not be map of Any (?)
case class ExecutionContext(
                             schema: GraphQLSchema,
                             fragments: Map[String, FragmentDefinitionContext],
                             root: Any,
                             operation: OperationDefinitionContext,
                             variables: Map[String, Any],
                             errors: List[Exception]) {

}
