package se.uprise.graphql.types

class GraphQLList[T <: GraphQLType](input: List[T]) extends GraphQLOutputType with GraphQLInputType {

}
