package se.uprise.graphql.error

case class GraphQLErrorLocation(line: Int, number: Int)

case class GraphQLFormattedError(message: String, locations: List[GraphQLErrorLocation])
