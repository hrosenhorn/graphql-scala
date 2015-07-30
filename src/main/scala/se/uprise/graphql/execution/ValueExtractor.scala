package se.uprise.graphql.execution

import se.uprise.graphql.types.{GraphQLFieldArgument, GraphQLInputType, GraphQLSchema}
import se.uprise.parser.GraphQlParser.{ValueOrVariableContext, VariableDefinitionContext, ArgumentsContext}

import scala.reflect.runtime._
import scala.collection.JavaConversions._

object ValueExtractor {

  /**
   * Prepares an object map of argument values given a list of argument
   * definitions and list of argument AST nodes.
   */
  // FIXME: Better Type for variables (guessing some decendant of InputType)
  def getArgumentValues(argDefs: List[GraphQLFieldArgument[_ <: GraphQLInputType]] = List.empty,
                        argASTs: ArgumentsContext,
                        variables: Map[String, Any]): Map[String, GraphQLInputType] = {

    // Avoid null pointer
    val argASTMap = Option(argASTs) match {
      case Some(value) => value.argument().toList.map({ entry =>
        val valueOrVariable = entry.valueOrVariable()
        entry.NAME().getText -> valueOrVariable
      }).toMap
      case None => Map[String, ValueOrVariableContext]()
    }

    argDefs.foldLeft(Map[String, GraphQLInputType]())((results: Map[String, GraphQLInputType], argDef: GraphQLFieldArgument[_ <: GraphQLInputType]) => {
      val name = argDef.name
      val valueAST = argASTMap(name)

      throw new Exception("FIXME: Implement")
      //results ++ Map(name -> CoerceValueAST(valueAST, variables))
      results// ++ Map(name -> null)
    })


  }

  /**
   * Given a type and a value AST node known to match this type, build a
   * runtime value.
   */
  //def coerceValueAST(typ: Class[GraphQLType], )


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
