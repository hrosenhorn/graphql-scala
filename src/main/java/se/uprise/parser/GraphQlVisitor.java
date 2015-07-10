// Generated from C:/Devel/graphql/tarkql/src/main/resources\GraphQl.g4 by ANTLR 4.5
package se.uprise.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GraphQlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GraphQlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(@NotNull GraphQlParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(@NotNull GraphQlParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#operationDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationDefinition(@NotNull GraphQlParser.OperationDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#selectionSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionSet(@NotNull GraphQlParser.SelectionSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#operationType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperationType(@NotNull GraphQlParser.OperationTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(@NotNull GraphQlParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(@NotNull GraphQlParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(@NotNull GraphQlParser.FieldNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#alias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlias(@NotNull GraphQlParser.AliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull GraphQlParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(@NotNull GraphQlParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#fragmentSpread}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentSpread(@NotNull GraphQlParser.FragmentSpreadContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#inlineFragment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInlineFragment(@NotNull GraphQlParser.InlineFragmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#fragmentDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentDefinition(@NotNull GraphQlParser.FragmentDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#fragmentName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFragmentName(@NotNull GraphQlParser.FragmentNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#directives}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectives(@NotNull GraphQlParser.DirectivesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirective(@NotNull GraphQlParser.DirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#typeCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCondition(@NotNull GraphQlParser.TypeConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#variableDefinitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinitions(@NotNull GraphQlParser.VariableDefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(@NotNull GraphQlParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull GraphQlParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(@NotNull GraphQlParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#valueOrVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueOrVariable(@NotNull GraphQlParser.ValueOrVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(@NotNull GraphQlParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberValue(@NotNull GraphQlParser.NumberValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(@NotNull GraphQlParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValue(@NotNull GraphQlParser.ArrayValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull GraphQlParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(@NotNull GraphQlParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#listType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(@NotNull GraphQlParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#nonNullType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonNullType(@NotNull GraphQlParser.NonNullTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GraphQlParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(@NotNull GraphQlParser.ArrayContext ctx);
}