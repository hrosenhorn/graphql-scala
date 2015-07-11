package se.uprise.graphql.error

import org.antlr.v4.runtime.RuleContext

// FIXME: Extend with proper values from js ref
// FIXME: Fix stack support
case class GraphQLError(message: String, nodes: List[RuleContext] = List.empty) extends Exception(message)
