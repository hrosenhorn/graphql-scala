package se.uprise.graphql.types

import se.uprise.graphql.annotation.QLField
import se.uprise.parser.GraphQlParser.SelectionContext

import scala.reflect.runtime._

// FIXME: Better type for default value
case class GraphQLFieldArgument[T <: GraphQLInputType](name: String,
                                                  description: String,
                                                  defaultValue: Any)

// FIXME: Better type for default value
// FIXME: Proper types for resolve method
case class GraphQLFieldDefinition(name: String,
                             description: String,
                             args: List[GraphQLFieldArgument[_ <: GraphQLInputType]] = List.empty,
                             resolve: universe.MethodSymbol,
                             deprecationReason: String = "")

trait GraphQLFields {
  def getFields(entry: GraphQLObjectType): Map[String, GraphQLFieldDefinition]

  // FIXME: We don't want to mess around with the reflection stuff. Look into macros and definition generation
  def isAnnotatedWithField(candidate: reflect.runtime.universe.Symbol) = {
    val qlFieldAnnotationType = universe.typeOf[QLField]
    val annotation: Option[reflect.runtime.universe.Annotation] = candidate.annotations.find(a => a.tpe == qlFieldAnnotationType)
    annotation match {
      case Some(value) => true
      case _ => false
    }
  }

  def getClassFields(candidate: GraphQLObjectType) = {
    val typ = universe.runtimeMirror(candidate.getClass.getClassLoader).classSymbol(candidate.getClass)

    //val typ: universe.ClassSymbol = universe.runtimeMirror(clazzType.getClassLoader).classSymbol(clazzType)

    val members: universe.MemberScope = typ.typeSignature.members
    val fields = members.flatMap({ entry =>
      isAnnotatedWithField(entry) match {
        case true => Some(entry.name.toString -> entry.asMethod)
        case _ => None
      }
    }).toMap
    fields
  }
}
