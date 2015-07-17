package se.uprise.graphql_alt2.starwars

// An example for how to map a GraphQL schema on to Scala's type system.
// Work in progress and still lots of unknowns but the great benefit we are after is true type safety at compile time.
// Tries to mimic the original Star Wars schema found in graphql-js reference impl.
// The schema below does not deal with Futures at all but it something we definitively need to support.

import se.uprise.graphql_alt2.GraphQLInterface

import scala.annotation.StaticAnnotation

// Test fixture data
object Data {
  val luke = new Human(
    id = "1000",
    name = "Luke Skywalker",
    friendIds = List("1002", "1003", "2000", "2001"),
    appearsInIds = List(4, 5, 6),
    _homePlanet = Some("Tatooine")
  )

  val vader = new Human(
    id = "1001",
    name = "Darth Vader",
    friendIds = List("1004"),
    appearsInIds = List(4, 5, 6),
    _homePlanet = Some("Tatooine")
  )

  val han = new Human(
    id = "1002",
    name = "Han Solo",
    friendIds = List("1000", "1003", "2001"),
    appearsInIds = List(4, 5, 6)
  )

  val leia = new Human(
    id = "1002",
    name = "Leia Organa",
    friendIds = List("1000", "1002", "2000", "2001"),
    appearsInIds = List(4, 5, 6),
    _homePlanet = Some("Alderaan")
  )

  val tarkin = new Human(
    id = "1004",
    name = "Wilhuff Tarkin",
    friendIds = List("1001"),
    appearsInIds = List(4)
  )

  val humanData = Map(
    "1000" -> luke,
    "1001" -> vader,
    "1002" -> han,
    "1003" -> leia,
    "1004" -> tarkin
  )

  val threepio = new Droid(
    id = "2000",
    name = "C-3PO",
    friendIds = List("1000", "1002", "1003", "2001"),
    appearsInIds = List(4, 5, 6),
    _primaryFunction = Some("Protocol")
  )

  val artoo = new Droid(
    id = "2001",
    name = "R2-D2",
    friendIds = List("1000", "1002", "1003"),
    appearsInIds = List(4, 5, 6),
    _primaryFunction = Some("Astromech")
  )

  val droidData = Map(
    "2000" -> threepio,
    "2001" -> artoo
  )

  /** Helper function to get a character by ID. */
  def getCharacter(id: String) = Option(humanData.getOrElse(id, droidData.getOrElse(id, null)))

  /** Helper function to get a character by ID. */
  def getEpisode(id: Int) = Option(Episode.lookup(id))

  /** Allows us to query for a character's friends. */
  def getFriends(friendsIds: List[String]): List[Character] = friendsIds.flatMap(getCharacter)

  /** Allows us to query for a character's friends. */
  def getEpisodes(episodeIds: List[Int]) = episodeIds.flatMap(getEpisode)
}

// Placeholders for now. For Scala to retain annotations at runtime, they need to be declared in Java.
// Annotations can be used to express metadata needed by the GraphQL introspection.
case class Interface(desc: String = "__notset") extends StaticAnnotation
case class Field(desc: String = "__notset") extends StaticAnnotation
case class Object(desc: String = "__notset") extends StaticAnnotation

// A NonNull annotation might be useful over Scala's Option since GraphQL can guarantee
// that input are for example, non-null. Hence no need for handling it in end-user code at all.
case class NonNull() extends StaticAnnotation

// Ghetto implementation of a GraphQL Enum. Consider it a placeholder.
// TBD: Use Scala Enumeration or a GraphQLEnum?
case class Episode(value: Any, description: String)
object Episode {
  val NEWHOPE = Episode(4, "Released in 1977.")
  val EMPIRE = Episode(5, "Released in 1980.")
  val JEDI = Episode(6, "Released in 1983.")
  val lookup = Map(NEWHOPE.value -> NEWHOPE, EMPIRE.value -> EMPIRE, JEDI.value -> JEDI)
}

// Example below uses Scala native data types instead of GraphQLString, GraphQLList etc.
// Still something we need to figure out.

@Interface(desc="A character in the Star Wars Trilogy")
trait Character extends GraphQLInterface {
  @Field(desc="The id of the character.")
  def id: String

  @Field(desc="The name of the character.")
  def name: String

  @Field(desc="The friends of the character, or an empty list if they have none.")
  def friends: List[Character]

  @Field(desc="Which movies they appear in.")
  def appearsIn: List[Episode]

  // TBD: How do handle resolveType?
  // In graphql-js, Character is aware of its implementors (why?).
}

// Human and Droid are actual classes and instances unlike graphql-js. The reason for this is to enforce type safety.
// Rather than relying on the untyped "source" parameter JS object/Scala Map,
// the data required for Human/Droid to do it's job is passed to the constructor.

// It is of course a fine balance how much data you should require in the constructor.
// Preferably as little a possible to avoid overfetching from underlying data sources (other services or a database).
// Additional nesting of fields/objects will likely help address this problem.

@Object(desc="A humanoid creature in the Star Wars universe.")
case class Human(id: String, name: String, friendIds: List[String], appearsInIds: List[Int], _homePlanet: Option[String] = None) extends Character {
  // Note how friends and episodes will only be resolved when asked for (by calling the function, aka the resolver)
  // Right now, these are fast in-memory lookups but they can be something slow, say a database query.
  override def friends = Data.getFriends(friendIds)
  override def appearsIn = Data.getEpisodes(appearsInIds)

  @Field(desc="The home planet of the human, or null if unknown.")
  def homePlanet: String = _homePlanet.orNull
}

@Object(desc="A mechanical creature in the Star Wars universe.")
case class Droid(id: String, name: String, friendIds: List[String], appearsInIds: List[Int], _primaryFunction: Option[String] = None) extends Character {
  // Same as in Human. The reason for these being duplicated in each GraphQL object class (Human and Droid)
  // is that a GraphQLInterface cannot have resolve functions.
  override def friends = Data.getFriends(friendIds)
  override def appearsIn = Data.getEpisodes(appearsInIds)

  @Field(desc="The primary function of the droid.")
  def primaryFunction: String = _primaryFunction.orNull
}

@Object
class Query {
  def hero: Character = Data.artoo

  def human(@NonNull @Field("ID of the human") id: String): Human = {
    // Not ideal null checking, but got type erasure if matching on Option[Character].
    val c = Data.getCharacter(id).orNull
    c match {
      case h: Human => h
      case _ => throw new IllegalArgumentException("Invalid human ID given")
    }
  }

  def droid(@NonNull id: String): Droid = {
    val c = Data.getCharacter(id).orNull
    c match {
      case d: Droid => d
      case _ => throw new IllegalArgumentException("Invalid droid ID given")
    }
  }
}

object Test {
  def main(args: Array[String]) {
    val q = new Query()
    println(s"The true hero in Star Wars is ${q.hero.name}")
    println(s"A friend of the hero is ${q.hero.friends(0).name}")
    println(s"Darth Vader appears in ${q.human("1001").appearsIn}")
    println(s"C3-PO's primary function is ${q.droid("2000").primaryFunction}")
  }
}