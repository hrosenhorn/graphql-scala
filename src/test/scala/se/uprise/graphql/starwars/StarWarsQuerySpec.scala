package se.uprise.graphql.starwars

import org.scalatest.{FunSpec, Matchers}
import se.uprise.graphql.{JsonMapper, GraphQL}

object StarWarsQueryHelper {
  def testQuery(query: String, expected: String) = {
    val result = GraphQL(StarWars.schema, query, None, Map.empty, "")
    JsonMapper(result.data)
  }
}

class StarWarsQuerySpec extends FunSpec with Matchers {
  describe("Star Wars Query Tests") {
    describe("Basic Queries") {
      it("Correctly identifies R2-D2 as the hero of the Star Wars Saga") {
        val query =
          """
            | query HeroNameQuery {
            |  hero {
            |    name
            |  }
            |}""".stripMargin

        val expected = Map(
          "hero" -> Map(
            "name" ->
              "R2-D2"
          )
        )

        val result = StarWarsQueryHelper.testQuery(query, "")
        result should be (JsonMapper(expected))
      }

      it("Allows us to query for the ID and friends of R2-D2") {
        val query =
          """
            | query HeroNameAndFriendsQuery {
            |  hero {
            |    id
            |    name
            |    friends {
            |      name
            |    }
            |  }
            |}""".stripMargin

        val expected = Map(
          "hero" -> Map(
            "id" -> "2001",
            "name" -> "R2-D2",
            "friends" -> Map(
              "name" -> "Luke Skywalker",
              "name" -> "Han Solo",
              "name" -> "Leia Organa"
            )
          )
        )

        val result = StarWarsQueryHelper.testQuery(query, "")
        result should be (JsonMapper(expected))

      }
    }
    describe("Nested Queries") {
      it("Allows us to query for the friends of friends of R2-D2") {
        val query =
          """
            | query NestedQuery {
            |  hero {
            |    name
            |    friends {
            |      name
            |      appearsIn
            |      friends {
            |        name
            |    }
            |  }
            |}""".stripMargin
      }
    }

    describe("Using IDs and query parameters to refetch objects") {
      it("Allows us to query for Luke Skywalker directly, using his ID") {
        val query =
          """
            | query FetchLukeQuery {
            |  human(id: "1000") {
            |    name
            |  }
            |}""".stripMargin
        StarWarsQueryHelper.testQuery(query, "")
      }
    }
  }
}
