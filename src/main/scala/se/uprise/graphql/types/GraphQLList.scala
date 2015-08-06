package se.uprise.graphql.types

class GraphQLList[T <: GraphQLType](val items: List[T]) extends GraphQLOutputType with GraphQLInputType