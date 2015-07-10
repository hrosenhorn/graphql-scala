package se.uprise

import java.io.ByteArrayInputStream

import org.antlr.v4.runtime.{CommonTokenStream, ANTLRInputStream}
import se.uprise.error.GraphQLFormattedError
import se.uprise.parser.GraphQlParser.FieldContext
import se.uprise.parser.{GraphQlBaseVisitor, GraphQlParser, GraphQlLexer}


import se.uprise.types.GraphQLSchema


case class GraphQLResult(data: String, errors: List[GraphQLFormattedError])


class GraphQlVisitor extends GraphQlBaseVisitor[Unit] {
  override def visitField(ctx: FieldContext): Unit = {
    println("HEJ HEJ", ctx.fieldName().NAME())
  }
}

object GraphQL {
  def apply(schema: GraphQLSchema,
           requestString: String,
           rootObject: Option[String],
            variableValues: Map[String, String],
            operationName: String
             ): GraphQLResult = {

    val input = new ANTLRInputStream(new ByteArrayInputStream(requestString.getBytes("UTF-8")))
    val lexer = new GraphQlLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new GraphQlParser(tokens)
    
    val visitor = new GraphQlVisitor()
    visitor.visit(parser.document())
    

    new GraphQLResult("svejs", List.empty)
  }
}
