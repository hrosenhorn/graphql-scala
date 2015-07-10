package se.uprise.graphql.types

trait GraphQLEnumType extends GraphQLOutputType with GraphQLMetadata {
  protected def enum(name: String, value: Any, description: String = null, deprecationReason: String = null) = {}
}