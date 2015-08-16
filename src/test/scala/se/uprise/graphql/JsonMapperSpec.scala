package se.uprise.graphql

import org.scalatest.{FunSpec, Matchers}
import se.uprise.graphql.GraphQL
import se.uprise.graphql.types.{GraphQLOutputObjectType, GraphQLOutputType, GraphQLString}

class JsonMapperSpec extends FunSpec with Matchers {
  describe("Json QL Mapper test") {
    describe("Simple types") {
      it("Should be able to map basic type") {

        val entry: GraphQLOutputObjectType = new GraphQLOutputObjectType(
          Map[String, GraphQLOutputType]("name" -> new GraphQLString("slask"))
        )

        val expected = """{"name":"slask"}"""
        val result = JsonMapper(entry)
        result should be (expected)
      }
    }

    describe("Advanced types") {
      it("Should be able to map more advanced types") {

        val entry: GraphQLOutputObjectType = new GraphQLOutputObjectType(
          Map[String, GraphQLOutputType]("hero" -> new GraphQLOutputObjectType(Map("name" -> new GraphQLString("R2-D2")))
          )
        )

        val expected = """{"hero":{"name":"R2-D2"}}"""

        val result = JsonMapper(entry)
        result should be (expected)
      }
    }
  }
}
