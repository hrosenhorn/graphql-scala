package se.uprise.graphql.types

class GraphQLSchema(val query: Class[_ <: GraphQLObjectType], val mutation: Option[Class[GraphQLObjectType]] = None)