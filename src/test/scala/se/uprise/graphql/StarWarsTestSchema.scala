package se.uprise.graphql

import se.uprise.graphql.types.{GraphQLFieldDefinition, GraphQLObjectType, GraphQLSchema, GraphQLString}

object StarWarsTestSchema {
  val MyHeroName = "CharlieBoi"

  val hemsida = new GraphQLString()

  val queryType = new GraphQLObjectType(
    "Query", "",

    Map("hero" -> new GraphQLFieldDefinition(
      "Hero",
      "Whi is my hero?",
      new GraphQLString(),
      List.empty,
      () => MyHeroName,
      ""
    ))
  )

  def apply(): GraphQLSchema = {
    new GraphQLSchema(
      query = Some(queryType),
      None
    )
  }
}
