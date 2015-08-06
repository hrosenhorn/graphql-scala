package se.uprise.graphql.types

import se.uprise.parser.GraphQlParser.StringValueContext


trait GraphQLScalarType extends GraphQLOutputType with GraphQLInputType {
  val name: String = ""
  val description: String = ""

}

case class GraphQLString(value: String) extends GraphQLScalarType {
  override val name: String = "String"

  def coerce(value: String): String = value
  def coerceLiteral(ast: StringValueContext): String = {
    ast.STRING().getText
  }

}