package se.uprise

import org.scalatest.FunSuite

class BasicTest extends FunSuite {
  test("SchemaTest") {

    val foo = """
query HeroNameQuery {
  hero2
}"""


    val slask: GraphQLResult = GraphQL(StarWarsTestSchema(), foo, None, Map(), "")


  }
}
