package se.uprise.graphql.types

/**
 * Created by Håkan Rosenhorn on 2015-07-09.
 */

class GraphQLFieldArgument(name: String,
                            typ: GraphQLInputType,
                            defaultValue: Any,
                            description: String)

class GraphQLFieldDefinition(
                              name: String,
                              description: String,
                              typ: GraphQLOutputType,
                              args: List[GraphQLFieldArgument],
                              resolve: () => Any,
                              deprecationReason: String)

