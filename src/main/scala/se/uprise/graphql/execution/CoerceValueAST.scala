package se.uprise.graphql.execution

import se.uprise.graphql.error.GraphQLError
import se.uprise.graphql.types.{GraphQLScalarType, GraphQLNonNull}
import se.uprise.parser.GraphQlParser.{VariableContext, ValueContext, ValueOrVariableContext}

object CoerceValueAST {

//  def apply(valueAST: ValueOrVariableContext, variables: Map[String, Any]) = {
//    valueAST.value() match {
//      case entry: ValueContext => this(entry, variables)
//      case _ =>
//        valueAST.variable() match {
//          case entry: VariableContext => this(entry, variables)
//          case _ => throw new GraphQLError("Tried to CoerceValueAST on unknown value", List(valueAST))
//        }
//    }
//  }

//  def apply(valueAST: ValueContext, variables: Map[String, Any]) = {
//
//  }
//
//  def apply(valueAST: VariableContext, variables: Map[String, Any]) = {
//
//  }

  // FIXME: Better type on variables
  def apply(valueAST: GraphQLScalarType, variables: Map[String, Any]) = {

  }
  //def apply(valueAST: GraphQLNonNull)
}
