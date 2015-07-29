package se.uprise.graphql.annotation

import scala.annotation.StaticAnnotation

case class QLInterface(desc: String = "") extends StaticAnnotation
case class QLObject(desc: String = "") extends StaticAnnotation

/* Responsibilities
 1) Check that return type is of GraphQLTypeOutputType
 2) Check that arguments is of GraphQLTypeInputType
 3) Name might not start with __
*/
case class QLField(desc: String = "") extends StaticAnnotation