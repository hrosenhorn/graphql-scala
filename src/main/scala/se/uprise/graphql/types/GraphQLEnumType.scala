package se.uprise.graphql.types

trait GraphQLEnumType extends GraphQLOutputType {
  def coerce: GraphQLString = {
    new GraphQLString("FIXME")
  }

}
