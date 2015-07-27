package se.uprise.graphql.starwars

import se.uprise.graphql.types._

import scala.annotation.StaticAnnotation

case class Interface(desc: String = "") extends StaticAnnotation

case class Object(desc: String = "") extends StaticAnnotation


/* Responsibilities
 1) Check that return type is of GraphQLTypeOutputType
 2) Check that arguments is of GraphQLTypeInputType
 3) Name might not start with __
*/
case class Field(desc: String = "") extends StaticAnnotation

@Interface(desc = "A character in the Star Wars Trilogy")
trait Character extends GraphQLInterfaceType {
  @Field()
  def id: GraphQLString

  @Field()
  def name: GraphQLString

  def friends: GraphQLList[Character]

  //def appearsIn
}

@Object(desc = "A humanoid creature in the Star Wars universe.")
class Human(_id: String, _name: String, _friends: Seq[Int], _appearsIn: Seq[Int], _homePlanet: String) extends GraphQLObjectType with Character {
  @Field()
  override def id: GraphQLString = new GraphQLString(_id)

  @Field()
  override def name: GraphQLString = new GraphQLString(_name)

  @Field()
  override def friends: GraphQLList[Character] = new GraphQLList[Character](Data.getFriends(_friends))

  @Field()
  def homePlanet = new GraphQLString(_homePlanet)
}

@Object(desc = "A mechanical creature in the Star Wars universe.")
class Droid(_id: String, _name: String, _friends: Seq[Int], _appearsIn: Seq[Int], _primaryFunction: String) extends GraphQLObjectType with Character {

  @Field()
  override def id: GraphQLString = new GraphQLString(_id)

  @Field()
  override def name: GraphQLString = new GraphQLString(_name)

  @Field()
  override def friends: GraphQLList[Character] = new GraphQLList[Character](Data.getFriends(_friends))

  @Field()
  def primaryFunction = new GraphQLString(_primaryFunction)
}

@Object()
class Query extends GraphQLObjectType {

  @Field()
  def hero: Character = {
    Data.artoo
  }

  @Field()
  def human(id: GraphQLString): Human = {
    Data.getCharacter(id.value).asInstanceOf[Human]
  }

  @Field()
  def droid(id: GraphQLString): Droid = {
    Data.getCharacter(id.value).asInstanceOf[Droid]
  }
}

class StarWarsSchema extends GraphQLSchema(classOf[Query], None) {

}

object StarWars {
  val schema = new StarWarsSchema
}