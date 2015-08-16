package se.uprise.graphql

import org.scalatest.FunSuite
import se.uprise.graphql.starwars.StarWars
import se.uprise.graphql.types.{GraphQLOutputObjectType, GraphQLOutputType}

class BasicTest extends FunSuite {
  test("SchemaTest") {
    // FIXME: Implement a basic test
    val foo = """query HeroNameQuery { hero { name } }"""
    val slask: GraphQLResult = GraphQL(StarWars.schema, foo, None, Map.empty, "")
    slask

    var hemsida: String = JsonMapper(slask.data)
    hemsida





  }
}
