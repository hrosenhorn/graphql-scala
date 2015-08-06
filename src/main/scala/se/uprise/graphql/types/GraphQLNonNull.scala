package se.uprise.graphql.types

class GraphQLNonNull[T <: GraphQLType](val item: T) extends GraphQLOutputType with GraphQLInputType