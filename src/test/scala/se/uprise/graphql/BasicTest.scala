package se.uprise.graphql

import org.scalatest.FunSuite
import se.uprise.graphql.starwars.StarWars

class BasicTest extends FunSuite {
  test("SchemaTest") {
    // FIXME: Implement a basic test
    val foo = """query HeroNameQuery { hero }"""
    val slask: GraphQLResult = GraphQL(StarWars.schema, foo, None, Map.empty, "")
    slask

  }
}
