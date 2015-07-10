package se.uprise.graphql.types

trait GraphQLScalarType extends GraphQLOutputType {
  val name: String = ""
  val description: String = ""
  def coerce(value: String): Boolean = true
  def coerceLiteral(value: String): String = "Todo"
}

class GraphQLString extends GraphQLScalarType {
  override val name: String = "String"
}

class GraphQLBoolean extends GraphQLScalarType {
  override val name: String = "Boolean"
}

class GraphQLID extends GraphQLScalarType {
  override val name: String = "ID"
}

class GraphQLFloat extends GraphQLScalarType {
  override val name: String = "Float"
}

// Integers are only safe when between -(2^53 - 1) and 2^53 - 1 due to being
// encoded in JavaScript and represented in JSON as double-precision floating
// point numbers, as specified by IEEE 754.

class GraphQLInt extends GraphQLScalarType {
  override val name: String = "Int"

  val MAX_INT = 9007199254740991L
  val MIN_INT = -9007199254740991L
}
