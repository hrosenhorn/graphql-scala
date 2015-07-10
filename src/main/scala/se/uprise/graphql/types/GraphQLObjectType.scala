package se.uprise.graphql.types

trait GraphQLObjectType extends GraphQLOutputType with GraphQLMetadata with GraphQLFields {
  def interfaces: List[Class[_ <: GraphQLInterfaceType]] = List()
}
