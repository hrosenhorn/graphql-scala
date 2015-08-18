package se.uprise.graphql

import se.uprise.graphql.types._

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

object JsonMapper {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)

  def apply(value: GraphQLOutputObjectType): String = {
    mapper.writeValueAsString(toPrimitive(value))
  }

  def apply(value: Map[String, Any]): String = {
    mapper.writeValueAsString(value)
  }

  def toPrimitive(value: GraphQLOutputObjectType): Map[String, Any] = {
    //mapper.writeValueAsString(value.elements map { case (k,v) => k -> toJson(v) } )
    value.elements map { case (k,v) => k -> toPrimitive(v) }
  }

  def toPrimitive(value: GraphQLType): Any = {
    value match {
      case x: GraphQLString => x.value
      case x: GraphQLOutputObjectType => toPrimitive(x)
      case x: GraphQLList[_] => x.items map { entry => toPrimitive(entry)}
    }
  }



//  def toJson(value: GraphQLString): String = {
//    mapper.writeValueAsString(value.value)
//  }
//
//  def toJson(value: Any): String = {
//    mapper.writeValueAsString(value)
//  }
}
