package se.uprise

import se.uprise.types.{GraphQLString, GraphQLFieldDefinition, GraphQLObjectType, GraphQLSchema}

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
