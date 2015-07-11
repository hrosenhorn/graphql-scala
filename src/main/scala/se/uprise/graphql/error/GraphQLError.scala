package se.uprise.graphql.error

// FIXME: Extend with proper values from js ref
case class GraphQLError(message: String) extends Exception(message)
