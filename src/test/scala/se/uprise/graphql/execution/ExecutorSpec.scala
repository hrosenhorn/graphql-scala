package se.uprise.graphql.execution

import java.io.ByteArrayInputStream

import org.antlr.v4.runtime.{CommonTokenStream, ANTLRInputStream}
import org.scalatest.FunSpec
import se.uprise.graphql.types.{GraphQLSchema, GraphQLString, GraphQLNonNull, GraphQLObjectType}
import se.uprise.parser.GraphQlParser.DocumentContext
import se.uprise.parser.{GraphQlParser, GraphQlLexer}

class ExecutorSpec extends FunSpec {
  describe("Execute: Handles basic execution tasks") {
    it("executes arbitrary code") {
      val doc =
        """query Example($size: Int) {
          |        a,
          |        b,
          |        x: c
          |        ...c
          |        f
          |        ...on DataType {
          |          pic(size: $size)
          |          promise {
          |            a
          |          }
          |        }
          |        deep {
          |          a
          |          b
          |          c
          |          deeper {
          |            a
          |            b
          |          }
          |        }
          |      }
          |
          |      fragment c on DataType {
          |        d
          |        e
          |      }
          |
          |      query Example2($size: Int) {
          |       a
          |      }
          |
          |      """.stripMargin


      val input = new ANTLRInputStream(new ByteArrayInputStream(doc.getBytes("UTF-8")))
      val lexer = new GraphQlLexer(input)
      val tokens = new CommonTokenStream(lexer)
      val parser = new GraphQlParser(tokens)

      val ast: DocumentContext = parser.document()

      class DataType extends GraphQLObjectType {
        override def name: String = "DataType"
        field("a", ftype = classOf[GraphQLString])_
      }

      val schema = new GraphQLSchema(new DataType())

      Executor(schema, "", ast, "Example", Map.empty)

    }
  }
}
