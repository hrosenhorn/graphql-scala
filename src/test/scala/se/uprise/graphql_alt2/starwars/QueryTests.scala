package se.uprise.graphql_alt2.starwars

import org.scalatest._

object Placeholder {
  def graphql(schema: Any, query: String): Map[String, Any] = {
    Map()
  }
}

class StarWarsQueryTest extends FunSpec with Matchers {
  describe("Basic Queries") {
    it("Correctly identifies R2-D2 as the hero of the Star Wars Saga") {
      val query = """
          | query HeroNameQuery {
          |  hero {
          |    name
          |  }
          |}""".stripMargin

      val expected = Map(
        "hero" -> Map(
          "name" -> "R2-D2"
        )
      )

      Placeholder.graphql(null, query) shouldEqual expected
    }

    it("Allows us to query for the ID and friends of R2-D2") {
      val query = """
        query HeroNameAndFriendsQuery {
          hero {
            id
            name
            friends {
              name
            }
          }
        }"""

      val expected = Map(
        "hero" -> Map(
          "id" -> "2001",
          "name" -> "R2-D2",
          "friends" -> List(
            Map("name" -> "Luke Skywalker"),
            Map("name" -> "Han Solo"),
            Map("name" -> "Leia Organa")
          )
        )
      )

      Placeholder.graphql(null, query) shouldEqual expected
    }
  }
}