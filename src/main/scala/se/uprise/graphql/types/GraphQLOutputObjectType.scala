package se.uprise.graphql.types

// FIXME: Not sure if this is optimal
/**
 * The idea is to have a "dymanic" object to store all collected fields during execution
 * @param input
 */
class GraphQLOutputObjectType(val elements: Map[String, GraphQLOutputType]) extends GraphQLOutputType{

}
