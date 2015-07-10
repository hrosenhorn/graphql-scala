// Generated from C:/Devel/graphql/tarkql/src/main/resources\GraphQl.g4 by ANTLR 4.5
package se.uprise.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GraphQlParser}.
 */
public interface GraphQlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(@NotNull GraphQlParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(@NotNull GraphQlParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(@NotNull GraphQlParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(@NotNull GraphQlParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#operationDefinition}.
	 * @param ctx the parse tree
	 */
	void enterOperationDefinition(@NotNull GraphQlParser.OperationDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#operationDefinition}.
	 * @param ctx the parse tree
	 */
	void exitOperationDefinition(@NotNull GraphQlParser.OperationDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#selectionSet}.
	 * @param ctx the parse tree
	 */
	void enterSelectionSet(@NotNull GraphQlParser.SelectionSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#selectionSet}.
	 * @param ctx the parse tree
	 */
	void exitSelectionSet(@NotNull GraphQlParser.SelectionSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#operationType}.
	 * @param ctx the parse tree
	 */
	void enterOperationType(@NotNull GraphQlParser.OperationTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#operationType}.
	 * @param ctx the parse tree
	 */
	void exitOperationType(@NotNull GraphQlParser.OperationTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(@NotNull GraphQlParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(@NotNull GraphQlParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull GraphQlParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull GraphQlParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(@NotNull GraphQlParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(@NotNull GraphQlParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(@NotNull GraphQlParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(@NotNull GraphQlParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull GraphQlParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull GraphQlParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(@NotNull GraphQlParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(@NotNull GraphQlParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#fragmentSpread}.
	 * @param ctx the parse tree
	 */
	void enterFragmentSpread(@NotNull GraphQlParser.FragmentSpreadContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#fragmentSpread}.
	 * @param ctx the parse tree
	 */
	void exitFragmentSpread(@NotNull GraphQlParser.FragmentSpreadContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#inlineFragment}.
	 * @param ctx the parse tree
	 */
	void enterInlineFragment(@NotNull GraphQlParser.InlineFragmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#inlineFragment}.
	 * @param ctx the parse tree
	 */
	void exitInlineFragment(@NotNull GraphQlParser.InlineFragmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#fragmentDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFragmentDefinition(@NotNull GraphQlParser.FragmentDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#fragmentDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFragmentDefinition(@NotNull GraphQlParser.FragmentDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#fragmentName}.
	 * @param ctx the parse tree
	 */
	void enterFragmentName(@NotNull GraphQlParser.FragmentNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#fragmentName}.
	 * @param ctx the parse tree
	 */
	void exitFragmentName(@NotNull GraphQlParser.FragmentNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#directives}.
	 * @param ctx the parse tree
	 */
	void enterDirectives(@NotNull GraphQlParser.DirectivesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#directives}.
	 * @param ctx the parse tree
	 */
	void exitDirectives(@NotNull GraphQlParser.DirectivesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(@NotNull GraphQlParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(@NotNull GraphQlParser.DirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#typeCondition}.
	 * @param ctx the parse tree
	 */
	void enterTypeCondition(@NotNull GraphQlParser.TypeConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#typeCondition}.
	 * @param ctx the parse tree
	 */
	void exitTypeCondition(@NotNull GraphQlParser.TypeConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#variableDefinitions}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinitions(@NotNull GraphQlParser.VariableDefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#variableDefinitions}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinitions(@NotNull GraphQlParser.VariableDefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(@NotNull GraphQlParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(@NotNull GraphQlParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(@NotNull GraphQlParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(@NotNull GraphQlParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(@NotNull GraphQlParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(@NotNull GraphQlParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#valueOrVariable}.
	 * @param ctx the parse tree
	 */
	void enterValueOrVariable(@NotNull GraphQlParser.ValueOrVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#valueOrVariable}.
	 * @param ctx the parse tree
	 */
	void exitValueOrVariable(@NotNull GraphQlParser.ValueOrVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(@NotNull GraphQlParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(@NotNull GraphQlParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterNumberValue(@NotNull GraphQlParser.NumberValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitNumberValue(@NotNull GraphQlParser.NumberValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(@NotNull GraphQlParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(@NotNull GraphQlParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterArrayValue(@NotNull GraphQlParser.ArrayValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayValue}
	 * labeled alternative in {@link GraphQlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitArrayValue(@NotNull GraphQlParser.ArrayValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull GraphQlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull GraphQlParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(@NotNull GraphQlParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(@NotNull GraphQlParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#listType}.
	 * @param ctx the parse tree
	 */
	void enterListType(@NotNull GraphQlParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#listType}.
	 * @param ctx the parse tree
	 */
	void exitListType(@NotNull GraphQlParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#nonNullType}.
	 * @param ctx the parse tree
	 */
	void enterNonNullType(@NotNull GraphQlParser.NonNullTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#nonNullType}.
	 * @param ctx the parse tree
	 */
	void exitNonNullType(@NotNull GraphQlParser.NonNullTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GraphQlParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull GraphQlParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link GraphQlParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull GraphQlParser.ArrayContext ctx);
}