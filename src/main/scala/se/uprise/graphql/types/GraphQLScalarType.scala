package se.uprise.graphql.types

trait GraphQLScalarType extends GraphQLOutputType with GraphQLInputType {
  val name: String = ""
  val description: String = ""
}

case class GraphQLString(value: String) extends GraphQLScalarType {
  override val name: String = "String"
}