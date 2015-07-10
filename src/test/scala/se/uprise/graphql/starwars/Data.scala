package se.uprise.graphql.starwars

/**
 * This defines a basic set of data for our Star Wars Schema.
 *
 * This data is hard coded for the sake of the demo, but you could imagine
 * fetching this data from a backend service rather than from hardcoded
 * JSON objects in a more complex demo.
 */
object Data {
  private type CharacterData = Map[String, Any]

  val luke: CharacterData = Map(
    "id" -> "1000",
    "name" -> "Luke Skywalker",
    "friends" -> List("1002", "1003", "2000", "2001"),
    "appearsIn" -> List(4, 5, 6),
    "homePlanet" -> "Tatooine"
  )

  val vader: CharacterData = Map(
    "id" -> "1001",
    "name" -> "Darth Vader",
    "friends" -> List("1004"),
    "appearsIn" -> List(4, 5, 6),
    "homePlanet" -> "Tatooine"
  )

  val han: CharacterData = Map(
    "id" -> "1002",
    "name" -> "Han Solo",
    "friends" -> List("1000", "1003", "2001"),
    "appearsIn" -> List(4, 5, 6)
  )

  val leia: CharacterData = Map(
    "id" -> "1003",
    "name" -> "Leia Organa",
    "friends" -> List("1000", "1002", "2000", "2001"),
    "appearsIn" -> List(4, 5, 6),
    "homePlanet" -> "Alderaan"
  )

  val tarkin: CharacterData = Map(
    "id" -> "1004",
    "name" -> "Wilhuff Tarkin",
    "friends" -> List("1001"),
    "appearsIn" -> List(4)
  )

  val humanData = Map(
    1000 -> luke,
    1001 -> vader,
    1002 -> han,
    1003 -> leia,
    1004 -> tarkin
  )

  val threepio: CharacterData = Map(
    "id" -> "2000",
    "name" -> "C-3PO",
    "friends" -> List("1000", "1002", "1003", "2001"),
    "appearsIn" -> List(4, 5, 6),
    "primaryFunction" -> "Protocol"
  )

  val artoo: CharacterData = Map(
    "id" -> "2001",
    "name" -> "R2-D2",
    "friends" -> List("1000", "1002", "1003"),
    "appearsIn" -> List(4, 5, 6),
    "primaryFunction" -> "Astromech"
  )

  val droidData = Map(
    2000 -> threepio,
    2001 -> artoo
  )

  /**
   * Helper function to get a character by ID.
   */
  def getCharacter(id: Int): Option[CharacterData] = {
    // FIXME: Demonstrate use of Future?
    Option(humanData.getOrElse(id, droidData.getOrElse(id, null)))
  }

  /**
   * Allows us to query for a character's friends.
   */
  def getFriends(character: CharacterData): List[CharacterData] = {
    character("friends").asInstanceOf[List[Int]].map(getCharacter(_)).flatten
  }
}