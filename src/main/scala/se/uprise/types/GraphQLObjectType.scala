package se.uprise.types

/**
 * Created by Håkan Rosenhorn on 2015-07-09.
 */
class GraphQLObjectType(
                         name: String,
                         description: String,
                         fields: Map[String, GraphQLFieldDefinition]) extends GraphQLOutputType {

}
