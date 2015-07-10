package se.uprise.graphql.types

trait GraphQLInterfaceType extends GraphQLObjectType with GraphQLMetadata with GraphQLFields {
  def resolveType(value: Any): Class[_ <: GraphQLObjectType] = {
    // FIXME: Try default resolve with getTypeOf
    null
  }
}