// Generated from C:/Devel/graphql/tarkql/src/main/resources\GraphQl.g4 by ANTLR 4.5
package se.uprise.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GraphQlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		NAME=18, STRING=19, BOOLEAN=20, NUMBER=21, WS=22;
	public static final int
		RULE_document = 0, RULE_definition = 1, RULE_operationDefinition = 2, 
		RULE_selectionSet = 3, RULE_operationType = 4, RULE_selection = 5, RULE_field = 6, 
		RULE_fieldName = 7, RULE_alias = 8, RULE_arguments = 9, RULE_argument = 10, 
		RULE_fragmentSpread = 11, RULE_inlineFragment = 12, RULE_fragmentDefinition = 13, 
		RULE_fragmentName = 14, RULE_directives = 15, RULE_directive = 16, RULE_typeCondition = 17, 
		RULE_variableDefinitions = 18, RULE_variableDefinition = 19, RULE_variable = 20, 
		RULE_defaultValue = 21, RULE_valueOrVariable = 22, RULE_value = 23, RULE_type = 24, 
		RULE_typeName = 25, RULE_listType = 26, RULE_nonNullType = 27, RULE_array = 28;
	public static final String[] ruleNames = {
		"document", "definition", "operationDefinition", "selectionSet", "operationType", 
		"selection", "field", "fieldName", "alias", "arguments", "argument", "fragmentSpread", 
		"inlineFragment", "fragmentDefinition", "fragmentName", "directives", 
		"directive", "typeCondition", "variableDefinitions", "variableDefinition", 
		"variable", "defaultValue", "valueOrVariable", "value", "type", "typeName", 
		"listType", "nonNullType", "array"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "','", "'}'", "'query'", "'mutation'", "':'", "'('", "')'", 
		"'...'", "'on'", "'fragment'", "'@'", "'$'", "'='", "'['", "']'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "NAME", "STRING", "BOOLEAN", "NUMBER", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GraphQl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GraphQlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DocumentContext extends ParserRuleContext {
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58); 
				definition();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__4) | (1L << T__10))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public OperationDefinitionContext operationDefinition() {
			return getRuleContext(OperationDefinitionContext.class,0);
		}
		public FragmentDefinitionContext fragmentDefinition() {
			return getRuleContext(FragmentDefinitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			setState(65);
			switch (_input.LA(1)) {
			case T__0:
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(63); 
				operationDefinition();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(64); 
				fragmentDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationDefinitionContext extends ParserRuleContext {
		public SelectionSetContext selectionSet() {
			return getRuleContext(SelectionSetContext.class,0);
		}
		public OperationTypeContext operationType() {
			return getRuleContext(OperationTypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(GraphQlParser.NAME, 0); }
		public VariableDefinitionsContext variableDefinitions() {
			return getRuleContext(VariableDefinitionsContext.class,0);
		}
		public DirectivesContext directives() {
			return getRuleContext(DirectivesContext.class,0);
		}
		public OperationDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operationDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitOperationDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationDefinitionContext operationDefinition() throws RecognitionException {
		OperationDefinitionContext _localctx = new OperationDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_operationDefinition);
		int _la;
		try {
			setState(78);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(67); 
				selectionSet();
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); 
				operationType();
				setState(69); 
				match(NAME);
				setState(71);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(70); 
					variableDefinitions();
					}
				}

				setState(74);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(73); 
					directives();
					}
				}

				setState(76); 
				selectionSet();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionSetContext extends ParserRuleContext {
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public SelectionSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionSet; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitSelectionSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionSetContext selectionSet() throws RecognitionException {
		SelectionSetContext _localctx = new SelectionSetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_selectionSet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); 
			match(T__0);
			setState(81); 
			selection();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__8) | (1L << NAME))) != 0)) {
				{
				{
				setState(83);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(82); 
					match(T__1);
					}
				}

				setState(85); 
				selection();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91); 
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationTypeContext extends ParserRuleContext {
		public OperationTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operationType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitOperationType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationTypeContext operationType() throws RecognitionException {
		OperationTypeContext _localctx = new OperationTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_operationType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionContext extends ParserRuleContext {
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public FragmentSpreadContext fragmentSpread() {
			return getRuleContext(FragmentSpreadContext.class,0);
		}
		public InlineFragmentContext inlineFragment() {
			return getRuleContext(InlineFragmentContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selection);
		try {
			setState(98);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(95); 
				field();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96); 
				fragmentSpread();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97); 
				inlineFragment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public DirectivesContext directives() {
			return getRuleContext(DirectivesContext.class,0);
		}
		public SelectionSetContext selectionSet() {
			return getRuleContext(SelectionSetContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); 
			fieldName();
			setState(102);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(101); 
				arguments();
				}
			}

			setState(105);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(104); 
				directives();
				}
			}

			setState(108);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(107); 
				selectionSet();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public TerminalNode NAME() { return getToken(GraphQlParser.NAME, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldName);
		try {
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110); 
				alias();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111); 
				match(NAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AliasContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(GraphQlParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(GraphQlParser.NAME, i);
		}
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); 
			match(NAME);
			setState(115); 
			match(T__5);
			setState(116); 
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); 
			match(T__6);
			setState(119); 
			argument();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(120); 
				match(T__1);
				setState(121); 
				argument();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127); 
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GraphQlParser.NAME, 0); }
		public ValueOrVariableContext valueOrVariable() {
			return getRuleContext(ValueOrVariableContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); 
			match(NAME);
			setState(130); 
			match(T__5);
			setState(131); 
			valueOrVariable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FragmentSpreadContext extends ParserRuleContext {
		public FragmentNameContext fragmentName() {
			return getRuleContext(FragmentNameContext.class,0);
		}
		public DirectivesContext directives() {
			return getRuleContext(DirectivesContext.class,0);
		}
		public FragmentSpreadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentSpread; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitFragmentSpread(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FragmentSpreadContext fragmentSpread() throws RecognitionException {
		FragmentSpreadContext _localctx = new FragmentSpreadContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fragmentSpread);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); 
			match(T__8);
			setState(134); 
			fragmentName();
			setState(136);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(135); 
				directives();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineFragmentContext extends ParserRuleContext {
		public TypeConditionContext typeCondition() {
			return getRuleContext(TypeConditionContext.class,0);
		}
		public SelectionSetContext selectionSet() {
			return getRuleContext(SelectionSetContext.class,0);
		}
		public DirectivesContext directives() {
			return getRuleContext(DirectivesContext.class,0);
		}
		public InlineFragmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineFragment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitInlineFragment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineFragmentContext inlineFragment() throws RecognitionException {
		InlineFragmentContext _localctx = new InlineFragmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inlineFragment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); 
			match(T__8);
			setState(139); 
			match(T__9);
			setState(140); 
			typeCondition();
			setState(142);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(141); 
				directives();
				}
			}

			setState(144); 
			selectionSet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FragmentDefinitionContext extends ParserRuleContext {
		public FragmentNameContext fragmentName() {
			return getRuleContext(FragmentNameContext.class,0);
		}
		public TypeConditionContext typeCondition() {
			return getRuleContext(TypeConditionContext.class,0);
		}
		public SelectionSetContext selectionSet() {
			return getRuleContext(SelectionSetContext.class,0);
		}
		public DirectivesContext directives() {
			return getRuleContext(DirectivesContext.class,0);
		}
		public FragmentDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitFragmentDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FragmentDefinitionContext fragmentDefinition() throws RecognitionException {
		FragmentDefinitionContext _localctx = new FragmentDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fragmentDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); 
			match(T__10);
			setState(147); 
			fragmentName();
			setState(148); 
			match(T__9);
			setState(149); 
			typeCondition();
			setState(151);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(150); 
				directives();
				}
			}

			setState(153); 
			selectionSet();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FragmentNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GraphQlParser.NAME, 0); }
		public FragmentNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fragmentName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitFragmentName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FragmentNameContext fragmentName() throws RecognitionException {
		FragmentNameContext _localctx = new FragmentNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fragmentName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155); 
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectivesContext extends ParserRuleContext {
		public List<DirectiveContext> directive() {
			return getRuleContexts(DirectiveContext.class);
		}
		public DirectiveContext directive(int i) {
			return getRuleContext(DirectiveContext.class,i);
		}
		public DirectivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directives; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitDirectives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectivesContext directives() throws RecognitionException {
		DirectivesContext _localctx = new DirectivesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_directives);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157); 
				directive();
				}
				}
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__11 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectiveContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GraphQlParser.NAME, 0); }
		public ValueOrVariableContext valueOrVariable() {
			return getRuleContext(ValueOrVariableContext.class,0);
		}
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitDirective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_directive);
		try {
			setState(168);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); 
				match(T__11);
				setState(163); 
				match(NAME);
				setState(164); 
				match(T__5);
				setState(165); 
				valueOrVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166); 
				match(T__11);
				setState(167); 
				match(NAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeConditionContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TypeConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitTypeCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeConditionContext typeCondition() throws RecognitionException {
		TypeConditionContext _localctx = new TypeConditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); 
			typeName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinitionsContext extends ParserRuleContext {
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public VariableDefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinitions; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitVariableDefinitions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionsContext variableDefinitions() throws RecognitionException {
		VariableDefinitionsContext _localctx = new VariableDefinitionsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variableDefinitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); 
			match(T__6);
			setState(173); 
			variableDefinition();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(174); 
				match(T__1);
				setState(175); 
				variableDefinition();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181); 
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinitionContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); 
			variable();
			setState(184); 
			match(T__5);
			setState(185); 
			type();
			setState(187);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(186); 
				defaultValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GraphQlParser.NAME, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); 
			match(T__12);
			setState(190); 
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultValueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); 
			match(T__13);
			setState(193); 
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueOrVariableContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ValueOrVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueOrVariable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitValueOrVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueOrVariableContext valueOrVariable() throws RecognitionException {
		ValueOrVariableContext _localctx = new ValueOrVariableContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_valueOrVariable);
		try {
			setState(197);
			switch (_input.LA(1)) {
			case T__14:
			case STRING:
			case BOOLEAN:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(195); 
				value();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(196); 
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringValueContext extends ValueContext {
		public TerminalNode STRING() { return getToken(GraphQlParser.STRING, 0); }
		public StringValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanValueContext extends ValueContext {
		public TerminalNode BOOLEAN() { return getToken(GraphQlParser.BOOLEAN, 0); }
		public BooleanValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberValueContext extends ValueContext {
		public TerminalNode NUMBER() { return getToken(GraphQlParser.NUMBER, 0); }
		public NumberValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitNumberValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayValueContext extends ValueContext {
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ArrayValueContext(ValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_value);
		try {
			setState(203);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(199); 
				match(STRING);
				}
				break;
			case NUMBER:
				_localctx = new NumberValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200); 
				match(NUMBER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201); 
				match(BOOLEAN);
				}
				break;
			case T__14:
				_localctx = new ArrayValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(202); 
				array();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public NonNullTypeContext nonNullType() {
			return getRuleContext(NonNullTypeContext.class,0);
		}
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type);
		int _la;
		try {
			setState(213);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(205); 
				typeName();
				setState(207);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(206); 
					nonNullType();
					}
				}

				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(209); 
				listType();
				setState(211);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(210); 
					nonNullType();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GraphQlParser.NAME, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_typeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215); 
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ListTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTypeContext listType() throws RecognitionException {
		ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_listType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); 
			match(T__14);
			setState(218); 
			type();
			setState(219); 
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonNullTypeContext extends ParserRuleContext {
		public NonNullTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonNullType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitNonNullType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonNullTypeContext nonNullType() throws RecognitionException {
		NonNullTypeContext _localctx = new NonNullTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_nonNullType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221); 
			match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQlVisitor ) return ((GraphQlVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_array);
		int _la;
		try {
			setState(236);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223); 
				match(T__14);
				setState(224); 
				value();
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(225); 
					match(T__1);
					setState(226); 
					value();
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(232); 
				match(T__15);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234); 
				match(T__14);
				setState(235); 
				match(T__15);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u00f1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\6\2>\n\2\r\2\16"+
		"\2?\3\3\3\3\5\3D\n\3\3\4\3\4\3\4\3\4\5\4J\n\4\3\4\5\4M\n\4\3\4\3\4\5\4"+
		"Q\n\4\3\5\3\5\3\5\5\5V\n\5\3\5\7\5Y\n\5\f\5\16\5\\\13\5\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\7\5\7e\n\7\3\b\3\b\5\bi\n\b\3\b\5\bl\n\b\3\b\5\bo\n\b\3\t"+
		"\3\t\5\ts\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13}\n\13\f\13\16\13"+
		"\u0080\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u008b\n\r\3\16"+
		"\3\16\3\16\3\16\5\16\u0091\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u009a\n\17\3\17\3\17\3\20\3\20\3\21\6\21\u00a1\n\21\r\21\16\21\u00a2"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00ab\n\22\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\7\24\u00b3\n\24\f\24\16\24\u00b6\13\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\5\25\u00be\n\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\5\30\u00c8"+
		"\n\30\3\31\3\31\3\31\3\31\5\31\u00ce\n\31\3\32\3\32\5\32\u00d2\n\32\3"+
		"\32\3\32\5\32\u00d6\n\32\5\32\u00d8\n\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00e6\n\36\f\36\16\36\u00e9\13\36"+
		"\3\36\3\36\3\36\3\36\5\36\u00ef\n\36\3\36\2\2\37\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\3\3\2\6\7\u00f1\2=\3\2\2\2"+
		"\4C\3\2\2\2\6P\3\2\2\2\bR\3\2\2\2\n_\3\2\2\2\fd\3\2\2\2\16f\3\2\2\2\20"+
		"r\3\2\2\2\22t\3\2\2\2\24x\3\2\2\2\26\u0083\3\2\2\2\30\u0087\3\2\2\2\32"+
		"\u008c\3\2\2\2\34\u0094\3\2\2\2\36\u009d\3\2\2\2 \u00a0\3\2\2\2\"\u00aa"+
		"\3\2\2\2$\u00ac\3\2\2\2&\u00ae\3\2\2\2(\u00b9\3\2\2\2*\u00bf\3\2\2\2,"+
		"\u00c2\3\2\2\2.\u00c7\3\2\2\2\60\u00cd\3\2\2\2\62\u00d7\3\2\2\2\64\u00d9"+
		"\3\2\2\2\66\u00db\3\2\2\28\u00df\3\2\2\2:\u00ee\3\2\2\2<>\5\4\3\2=<\3"+
		"\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3\2\2\2AD\5\6\4\2BD\5\34\17\2"+
		"CA\3\2\2\2CB\3\2\2\2D\5\3\2\2\2EQ\5\b\5\2FG\5\n\6\2GI\7\24\2\2HJ\5&\24"+
		"\2IH\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KM\5 \21\2LK\3\2\2\2LM\3\2\2\2MN\3\2\2"+
		"\2NO\5\b\5\2OQ\3\2\2\2PE\3\2\2\2PF\3\2\2\2Q\7\3\2\2\2RS\7\3\2\2SZ\5\f"+
		"\7\2TV\7\4\2\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WY\5\f\7\2XU\3\2\2\2Y\\\3"+
		"\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]^\7\5\2\2^\t\3\2\2\2_"+
		"`\t\2\2\2`\13\3\2\2\2ae\5\16\b\2be\5\30\r\2ce\5\32\16\2da\3\2\2\2db\3"+
		"\2\2\2dc\3\2\2\2e\r\3\2\2\2fh\5\20\t\2gi\5\24\13\2hg\3\2\2\2hi\3\2\2\2"+
		"ik\3\2\2\2jl\5 \21\2kj\3\2\2\2kl\3\2\2\2ln\3\2\2\2mo\5\b\5\2nm\3\2\2\2"+
		"no\3\2\2\2o\17\3\2\2\2ps\5\22\n\2qs\7\24\2\2rp\3\2\2\2rq\3\2\2\2s\21\3"+
		"\2\2\2tu\7\24\2\2uv\7\b\2\2vw\7\24\2\2w\23\3\2\2\2xy\7\t\2\2y~\5\26\f"+
		"\2z{\7\4\2\2{}\5\26\f\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2"+
		"\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\n\2\2\u0082\25\3\2\2"+
		"\2\u0083\u0084\7\24\2\2\u0084\u0085\7\b\2\2\u0085\u0086\5.\30\2\u0086"+
		"\27\3\2\2\2\u0087\u0088\7\13\2\2\u0088\u008a\5\36\20\2\u0089\u008b\5 "+
		"\21\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\31\3\2\2\2\u008c\u008d"+
		"\7\13\2\2\u008d\u008e\7\f\2\2\u008e\u0090\5$\23\2\u008f\u0091\5 \21\2"+
		"\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\5\b\5\2\u0093\33\3\2\2\2\u0094\u0095\7\r\2\2\u0095\u0096\5\36\20\2\u0096"+
		"\u0097\7\f\2\2\u0097\u0099\5$\23\2\u0098\u009a\5 \21\2\u0099\u0098\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\5\b\5\2\u009c"+
		"\35\3\2\2\2\u009d\u009e\7\24\2\2\u009e\37\3\2\2\2\u009f\u00a1\5\"\22\2"+
		"\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3!\3\2\2\2\u00a4\u00a5\7\16\2\2\u00a5\u00a6\7\24\2\2\u00a6"+
		"\u00a7\7\b\2\2\u00a7\u00ab\5.\30\2\u00a8\u00a9\7\16\2\2\u00a9\u00ab\7"+
		"\24\2\2\u00aa\u00a4\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab#\3\2\2\2\u00ac\u00ad"+
		"\5\64\33\2\u00ad%\3\2\2\2\u00ae\u00af\7\t\2\2\u00af\u00b4\5(\25\2\u00b0"+
		"\u00b1\7\4\2\2\u00b1\u00b3\5(\25\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b7\u00b8\7\n\2\2\u00b8\'\3\2\2\2\u00b9\u00ba\5*\26\2"+
		"\u00ba\u00bb\7\b\2\2\u00bb\u00bd\5\62\32\2\u00bc\u00be\5,\27\2\u00bd\u00bc"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be)\3\2\2\2\u00bf\u00c0\7\17\2\2\u00c0"+
		"\u00c1\7\24\2\2\u00c1+\3\2\2\2\u00c2\u00c3\7\20\2\2\u00c3\u00c4\5\60\31"+
		"\2\u00c4-\3\2\2\2\u00c5\u00c8\5\60\31\2\u00c6\u00c8\5*\26\2\u00c7\u00c5"+
		"\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8/\3\2\2\2\u00c9\u00ce\7\25\2\2\u00ca"+
		"\u00ce\7\27\2\2\u00cb\u00ce\7\26\2\2\u00cc\u00ce\5:\36\2\u00cd\u00c9\3"+
		"\2\2\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\61\3\2\2\2\u00cf\u00d1\5\64\33\2\u00d0\u00d2\58\35\2\u00d1\u00d0\3\2"+
		"\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d8\3\2\2\2\u00d3\u00d5\5\66\34\2\u00d4"+
		"\u00d6\58\35\2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2"+
		"\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d8\63\3\2\2\2\u00d9\u00da"+
		"\7\24\2\2\u00da\65\3\2\2\2\u00db\u00dc\7\21\2\2\u00dc\u00dd\5\62\32\2"+
		"\u00dd\u00de\7\22\2\2\u00de\67\3\2\2\2\u00df\u00e0\7\23\2\2\u00e09\3\2"+
		"\2\2\u00e1\u00e2\7\21\2\2\u00e2\u00e7\5\60\31\2\u00e3\u00e4\7\4\2\2\u00e4"+
		"\u00e6\5\60\31\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3"+
		"\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea"+
		"\u00eb\7\22\2\2\u00eb\u00ef\3\2\2\2\u00ec\u00ed\7\21\2\2\u00ed\u00ef\7"+
		"\22\2\2\u00ee\u00e1\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef;\3\2\2\2\35?CIL"+
		"PUZdhknr~\u008a\u0090\u0099\u00a2\u00aa\u00b4\u00bd\u00c7\u00cd\u00d1"+
		"\u00d5\u00d7\u00e7\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}