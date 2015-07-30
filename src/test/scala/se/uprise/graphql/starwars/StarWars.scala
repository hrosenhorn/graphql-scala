package se.uprise.graphql.starwars

import se.uprise.graphql.annotation.{QLField, QLInterface, QLObject}
import se.uprise.graphql.types._

import scala.annotation.StaticAnnotation
import scala.reflect.runtime._


@QLInterface(desc = "A character in the Star Wars Trilogy")
trait Character extends GraphQLInterfaceType {
  @QLField()
  def id: GraphQLString

  @QLField()
  def name: GraphQLString

  @QLField()
  def friends: GraphQLList[Character]

  //def appearsIn
}

@QLObject(desc = "A humanoid creature in the Star Wars universe.")
class Human(_id: String, _name: String, _friends: Seq[Int], _appearsIn: Seq[Int], _homePlanet: String) extends GraphQLObjectType with Character {
  @QLField()
  override def id: GraphQLString = new GraphQLString(_id)

  @QLField()
  override def name: GraphQLString = new GraphQLString(_name)

  @QLField()
  override def friends: GraphQLList[Character] = new GraphQLList[Character](Data.getFriends(_friends))

  @QLField()
  def homePlanet = new GraphQLString(_homePlanet)

  // This is the part we wish to auto generate
  override def getFields(entry: GraphQLObjectType): Map[String, GraphQLFieldDefinition] = {
    val fields = this.getClassFields(this)

    Map(
      "id" -> new GraphQLFieldDefinition("id", "desc", List.empty, fields("id"), ""),
      "name" -> new GraphQLFieldDefinition("name", "desc", List.empty, fields("name"), ""),
      "friends" -> new GraphQLFieldDefinition("friends", "desc", List.empty, fields("friends"), ""),
      "homePlanet" -> new GraphQLFieldDefinition("homePlanet", "desc", List.empty, fields("homePlanet"), "")
    )
  }
}

@QLObject(desc = "A mechanical creature in the Star Wars universe.")
class Droid(_id: String, _name: String, _friends: Seq[Int], _appearsIn: Seq[Int], _primaryFunction: String) extends GraphQLObjectType with Character {

  @QLField()
  override def id: GraphQLString = new GraphQLString(_id)

  @QLField()
  override def name: GraphQLString = new GraphQLString(_name)

  @QLField()
  override def friends: GraphQLList[Character] = new GraphQLList[Character](Data.getFriends(_friends))

  @QLField()
  def primaryFunction = new GraphQLString(_primaryFunction)

  // This is the part we wish to auto generate
  override def getFields(entry: GraphQLObjectType): Map[String, GraphQLFieldDefinition] = {
    val fields = this.getClassFields(this)

    Map(
      "id" -> new GraphQLFieldDefinition("id", "desc", List.empty, fields("id"), ""),
      "name" -> new GraphQLFieldDefinition("name", "desc", List.empty, fields("name"), ""),
      "friends" -> new GraphQLFieldDefinition("friends", "desc", List.empty, fields("friends"), ""),
      "primaryFunction" -> new GraphQLFieldDefinition("primaryFunction", "desc", List.empty, fields("primaryFunction"), "")
    )
  }
}

@QLObject()
class Query extends GraphQLObjectType {

  @QLField()
  def hero: Character = {
    Data.artoo
  }

  @QLField()
  def human(id: GraphQLString): Human = {
    Data.getCharacter(id.value).asInstanceOf[Human]
  }

  @QLField()
  def droid(id: GraphQLString): Droid = {
    Data.getCharacter(id.value).asInstanceOf[Droid]
  }

  // This is the part we wish to auto generate
  override def getFields(entry: GraphQLObjectType): Map[String, GraphQLFieldDefinition] = {
    val fields = this.getClassFields(this)


    Map(
      "hero" -> new GraphQLFieldDefinition("hero", "desc", List.empty, fields("hero"), ""),
      "human" -> new GraphQLFieldDefinition(
        "human",
        "desc",
        List(new GraphQLFieldArgument[GraphQLString]("id", "desc", "BLANK")),
        fields("human"),
        ""),
      "droid" -> new GraphQLFieldDefinition(
        "droid",
        "desc",
        List(new GraphQLFieldArgument[GraphQLString]("id", "desc", "BLANK")),
        fields("droid"),
        "")
    )
  }
}

class StarWarsSchema extends GraphQLSchema(new Query, None) {

}

object StarWars {
  val schema = new StarWarsSchema
}