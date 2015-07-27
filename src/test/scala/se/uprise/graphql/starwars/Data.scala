package se.uprise.graphql.starwars

//import se.uprise.graphql.starwars.Human

/**
 * This defines a basic set of data for our Star Wars Schema.
 *
 * This data is hard coded for the sake of the demo, but you could imagine
 * fetching this data from a backend service rather than from hardcoded
 * JSON objects in a more complex demo.
 */

object Data {

  val luke = new Human("1000", "Luke Skywalker", List(1002, 1003, 2000, 2001), List(4, 5, 6), "Tatooine")
  val vader = new Human("1001", "Darth Vader", List(1004), List(4, 5, 6), "Tatooine")
  val han = new Human("1002", "Han Solo", List(1000, 1003, 2001), List(4, 5, 6), "")
  val leia = new Human("1003", "Leia Organa", List(1000, 1002, 2000, 2001), List(4, 5, 6), "Alderaan")
  val tarkin = new Human("1004", "Wilhuff Tarkin", List(1001), List(4), "")

  val humanData = Map(
    "1000" -> luke,
    "1001" -> vader,
    "1002" -> han,
    "1003" -> leia,
    "1004" -> tarkin
  )

  val threepio = new Droid("2000", "C-3PO", List(1000, 1002, 1003, 2001), List(4, 5, 6), "Protocol")
  val artoo = new Droid("2001", "R2-D2", List(1000, 1002, 1003), List(4, 5, 6), "Astromech")

  val droidData = Map(
    "2000" -> threepio,
    "2001" -> artoo
  )

  /**
   * Helper function to get a character by ID.
   */
  def getCharacter(id: String): Character = {
    // FIXME: Demonstrate use of Future?
    humanData.getOrElse(id, droidData(id))
  }

  /**
   * Allows us to query for a character's friends.
   */
  def getFriends(friendIds: Seq[Int]): List[Character] = {
    friendIds.map({ friendId => getCharacter(friendId.toString) }).toList
  }
}