package se.uprise.graphql.types

trait GraphQLFields {
  private var _fields: Map[String, GraphQLFieldDefinition] = Map()
  protected def fields = _fields
  protected def field(name: String, description: String = null, ftype: Class[_ <: GraphQLOutputType], args: List[GraphQLFieldArgument] = null,
                      deprecationReason: String = null)(resolve: () => Any = null) = {}
}

class GraphQLFieldArgument(name: String,
                            typ: Class[_ <: GraphQLOutputType],
                            defaultValue: Any = null,
                            description: String = null)

class GraphQLFieldDefinition(
                              name: String,
                              description: String,
                              typ: GraphQLOutputType,
                              args: List[GraphQLFieldArgument],
                              resolve: () => Any,
                              deprecationReason: String)

