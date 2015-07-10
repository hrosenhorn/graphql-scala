package se.uprise.graphql.starwars

import se.uprise.graphql.types._

// Comments are from Facebook's graphql-js lib

/**
 * This is designed to be an end-to-end test, demonstrating
 * the full GraphQL stack.
 *
 * We will create a GraphQL schema that describes the major
 * characters in the original Star Wars trilogy.
 *
 * NOTE: This may contain spoilers for the original Star
 * Wars trilogy.
 */

/**
 * Using our shorthand to describe type systems, the type system for our
 * Star Wars example is:
 *
 * enum Episode { NEWHOPE, EMPIRE, JEDI }
 *
 * interface Character {
 *   id: String!
 *   name: String
 *   friends: [Character]
 *   appearsIn: [Episode]
 * }
 *
 * type Human : Character {
 *   id: String!
 *   name: String
 *   friends: [Character]
 *   appearsIn: [Episode]
 *   homePlanet: String
 * }
 *
 * type Droid : Character {
 *   id: String!
 *   name: String
 *   friends: [Character]
 *   appearsIn: [Episode]
 *   primaryFunction: String
 * }
 *
 * type Query {
 *   hero: Character
 *   human(id: String!): Human
 *   droid(id: String!): Droid
 * }
 *
 * We begin by setting up our schema.
 */

/**
 * The original trilogy consists of three movies.
 *
 * This implements the following type system shorthand:
 *   enum Episode { NEWHOPE, EMPIRE, JEDI }
 */
class Episode extends GraphQLEnumType {
  override def name = "Episode"
  override def description = "One of the films in the Star Wars Trilogy"

  enum("NEWHOPE", 4, "Released in 1977")
  enum("EMPIRE", 5, "Released in 1980")
  enum("JEDI", 6, "Released in 1983")
}

/**
 * Characters in the Star Wars trilogy are either humans or droids.
 *
 * This implements the following type system shorthand:
 *   interface Character {
 *     id: String!
 *     name: String
 *     friends: [Character]
 *     appearsIn: [Episode]
 *   }
 */
class Character extends GraphQLInterfaceType {
  override def name = "Character"
  override def description = "A character in the Star Wars Trilogy"

  field("id", "The id of the character.", classOf[GraphQLString])_
  field("name", "The name of the character.", classOf[GraphQLString])_
  field("friends", "The friends of the character, or an empty list if they have none.", classOf[GraphQLList[Character]])_
  field("appearsIn", "Which movies they appear in.", classOf[GraphQLList[GraphQLString]])_

  override def resolveType(value: Any): Class[_ <: GraphQLObjectType] = {
    // FIXME: Proper resolving of type
    classOf[Human]
  }
}

/**
 * We define our human type, which implements the character interface.
 *
 * This implements the following type system shorthand:
 *   type Human : Character {
 *     id: String!
 *     name: String
 *     friends: [Character]
 *     appearsIn: [Episode]
 *   }
 */
class Human extends GraphQLObjectType {
  override def name = "Human"
  override def description = "A humanoid creature in the Star Wars universe."

  field("id", "The id of the human.", classOf[GraphQLNonNull[GraphQLString]])_
  field("name", "The name of the human.", classOf[GraphQLString])_
  field("friends", "The friends of the human, or an empty list if they have none.", classOf[GraphQLList[Character]]) {
    // FIXME: Resolve friends
    null
  }
  field("appearsIn", "Which movies they appear in.", classOf[GraphQLList[GraphQLString]])_
  field("homePlanet", "The home planet of the human, or null if unknown.", classOf[GraphQLString])_

  override def interfaces = List(classOf[Character])
}

/**
 * The other type of character in Star Wars is a droid.
 *
 * This implements the following type system shorthand:
 *   type Droid : Character {
 *     id: String!
 *     name: String
 *     friends: [Character]
 *     appearsIn: [Episode]
 *     primaryFunction: String
 *   }
 */
class Droid extends GraphQLObjectType {
  override def name = "Droid"
  override def description = "A mechanical creature in the Star Wars universe."

  field("id", "The id of the droid.", classOf[GraphQLNonNull[GraphQLString]])_
  field("name", "The name of the droid.", classOf[GraphQLString])_
  field("friends", "The friends of the droid, or an empty list if they have none.", classOf[GraphQLList[Character]]) {
    // FIXME: Resolve friends
    null
  }
  field("appearsIn", "Which movies they appear in.", classOf[GraphQLList[GraphQLString]])_
  field("primaryFunction", "The primary function of the droid.", classOf[GraphQLString])_

  override def interfaces = List(classOf[Character])
}

/**
 * This is the type that will be the root of our query, and the
 * entry point into our schema. It gives us the ability to fetch
 * objects by their IDs, as well as to fetch the undisputed hero
 * of the Star Wars trilogy, R2-D2, directly.
 *
 * This implements the following type system shorthand:
 *   type Query {
 *     hero: Character
 *     human(id: String!): Human
 *     droid(id: String!): Droid
 *   }
 *
 */
class Query extends GraphQLObjectType {
  override def name = "Query"

  field("hero", ftype = classOf[Character]) {
    // FIXME: Return artoo
    null
  }

  val humanArgs = List(new GraphQLFieldArgument("id", classOf[GraphQLNonNull[GraphQLString]]))
  field("human", ftype = classOf[Character], args = humanArgs) {
    // FIXME: Resolve human
    null
  }

  val droidArgs = List(new GraphQLFieldArgument("id", classOf[GraphQLNonNull[GraphQLString]]))
  field("droid", ftype = classOf[Character], args = droidArgs) {
    // FIXME: Resolve droid
    null
  }
}

object StarWars {
  val schema = new GraphQLSchema(new Query())
}
