package se.uprise.graphql.types

trait GraphQLMetadata {
  def name: String
  def description: String = null
  def deprecationReason: String = null
}
