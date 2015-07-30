package se.uprise.graphql.execution

import se.uprise.graphql.types.{GraphQLFieldArgument, GraphQLInputType, GraphQLSchema}
import se.uprise.parser.GraphQlParser.{VariableDefinitionContext, ArgumentsContext}

import scala.reflect.runtime._
import scala.collection.JavaConversions._

object ValueExtractor {

  /**
   * Prepares an object map of argument values given a list of argument
   * definitions and list of argument AST nodes.
   */
  // FIXME: Better Type for variables (guessing some decendant of InputType)
  def getArgumentValues(argDefs: List[GraphQLFieldArgument[_ <: GraphQLInputType]],
                        arguments: ArgumentsContext,
                        variables: Map[String, Any]) = {


    //val finalResults = fields.keys.foldLeft(Map[String, Any]())((results: Map[String, Any], responseName) => {

    // FIXME: Can we get null here?
//    arguments.argument().toList.map({ entry =>
//      val valueOrVariable = entry.valueOrVariable()
//      val valueOrVariable = entry.valueOrVariable()
//      entry.NAME().getText -> valueOrVariable
//    }).toMap


  }



  /**
   * Prepares an object map of variables of the correct type based on the provided
   * variable definitions and arbitrary input. If the input cannot be coerced
   * to match the variable definitions, a GraphQLError will be thrown.
   */
  /*
   FIXME: Replace Any types with proper Types resolved from the variableValues
   Ex: query Example($size: Int) {
   variableValues = { size: 100 }
    */

  def getVariableValues(schema: GraphQLSchema,
                        definitionASTs: List[VariableDefinitionContext] = List.empty,
                        variableValues: Map[String, String] = Map.empty): Map[String, Any] = {


    // FIXME: Implement
    //    definitionASTs map { definition =>
    //      val varName = definition.variable().NAME().getText
    //    }

    Map.empty
  }


  /**
   * Given a variable definition, and any value of input, return a value which
   * adheres to the variable definition, or throw an error.
   */
  def getVariableValue(schema: GraphQLSchema,
                       definitionAST: VariableDefinitionContext,
                       input: String) = {

  }
}
