package se.uprise.graphql.types

class GraphQLSchema(val query: GraphQLObjectType, val mutation: Option[GraphQLObjectType] = None)