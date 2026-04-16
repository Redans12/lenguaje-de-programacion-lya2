// Generated from c:/Users/Andres/OneDrive/Documentos/UNIVERSIDAD/8VO SEMESTRE/LENG y AUT II/u2proyecto/src/main/antlr4/com/u2proyecto/EBDA.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EBDAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, IDENTIFIER=27, NUMBER=28, STRING=29, DELIM=30, WS=31;
	public static final int
		RULE_start = 0, RULE_statement = 1, RULE_declaration = 2, RULE_assignment = 3, 
		RULE_printStmt = 4, RULE_rushStmt = 5, RULE_respawnStmt = 6, RULE_winStmt = 7, 
		RULE_type = 8, RULE_expression = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "statement", "declaration", "assignment", "printStmt", "rushStmt", 
			"respawnStmt", "winStmt", "type", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'plant'", "'->'", "'buffear'", "'nerfear'", "'\\u00F1'", "'('", 
			"')'", "'rush'", "'{'", "'}'", "'afk'", "'respawn'", "'win'", "'healthpoints'", 
			"'chat'", "'online'", "'+'", "'-'", "'*'", "'/'", "'='", "'<'", "'>'", 
			"'!'", "'offline'", "'npc'", null, null, null, "':)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "IDENTIFIER", "NUMBER", "STRING", "DELIM", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "EBDA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EBDAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(EBDAParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134230330L) != 0)) {
				{
				{
				setState(20);
				statement();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public RushStmtContext rushStmt() {
			return getRuleContext(RushStmtContext.class,0);
		}
		public RespawnStmtContext respawnStmt() {
			return getRuleContext(RespawnStmtContext.class,0);
		}
		public WinStmtContext winStmt() {
			return getRuleContext(WinStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				declaration();
				}
				break;
			case T__2:
			case T__3:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				assignment();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				printStmt();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				rushStmt();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				respawnStmt();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(33);
				winStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(EBDAParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DELIM() { return getToken(EBDAParser.DELIM, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__0);
			setState(37);
			type();
			setState(38);
			match(IDENTIFIER);
			setState(39);
			match(T__1);
			setState(40);
			expression(0);
			setState(41);
			match(DELIM);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(EBDAParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DELIM() { return getToken(EBDAParser.DELIM, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(IDENTIFIER);
				setState(44);
				match(T__1);
				setState(45);
				expression(0);
				setState(46);
				match(DELIM);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(T__2);
				setState(49);
				match(IDENTIFIER);
				setState(50);
				match(DELIM);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				match(T__3);
				setState(52);
				match(IDENTIFIER);
				setState(53);
				match(DELIM);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DELIM() { return getToken(EBDAParser.DELIM, 0); }
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__4);
			setState(57);
			match(T__5);
			setState(58);
			expression(0);
			setState(59);
			match(T__6);
			setState(60);
			match(DELIM);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RushStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RushStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rushStmt; }
	}

	public final RushStmtContext rushStmt() throws RecognitionException {
		RushStmtContext _localctx = new RushStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rushStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__7);
			setState(63);
			match(T__5);
			setState(64);
			expression(0);
			setState(65);
			match(T__6);
			setState(66);
			match(T__8);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134230330L) != 0)) {
				{
				{
				setState(67);
				statement();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			match(T__9);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(74);
				match(T__10);
				setState(75);
				match(T__8);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134230330L) != 0)) {
					{
					{
					setState(76);
					statement();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(82);
				match(T__9);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RespawnStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RespawnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_respawnStmt; }
	}

	public final RespawnStmtContext respawnStmt() throws RecognitionException {
		RespawnStmtContext _localctx = new RespawnStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_respawnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__11);
			setState(86);
			match(T__5);
			setState(87);
			expression(0);
			setState(88);
			match(T__6);
			setState(89);
			match(T__8);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 134230330L) != 0)) {
				{
				{
				setState(90);
				statement();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(T__9);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WinStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DELIM() { return getToken(EBDAParser.DELIM, 0); }
		public WinStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_winStmt; }
	}

	public final WinStmtContext winStmt() throws RecognitionException {
		WinStmtContext _localctx = new WinStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_winStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__12);
			setState(99);
			expression(0);
			setState(100);
			match(DELIM);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(EBDAParser.IDENTIFIER, 0); }
		public TerminalNode NUMBER() { return getToken(EBDAParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(EBDAParser.STRING, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				{
				setState(105);
				match(T__23);
				setState(106);
				expression(8);
				}
				break;
			case T__5:
				{
				setState(107);
				match(T__5);
				setState(108);
				expression(0);
				setState(109);
				match(T__6);
				}
				break;
			case IDENTIFIER:
				{
				setState(111);
				match(IDENTIFIER);
				}
				break;
			case NUMBER:
				{
				setState(112);
				match(NUMBER);
				}
				break;
			case STRING:
				{
				setState(113);
				match(STRING);
				}
				break;
			case T__15:
				{
				setState(114);
				match(T__15);
				}
				break;
			case T__24:
				{
				setState(115);
				match(T__24);
				}
				break;
			case T__25:
				{
				setState(116);
				match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(125);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(120);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(121);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(123);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(124);
						expression(10);
						}
						break;
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u0083\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0005\u0000\u0016\b\u0000"+
		"\n\u0000\f\u0000\u0019\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001#\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u00037\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005E\b\u0005\n\u0005\f\u0005H\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005N\b"+
		"\u0005\n\u0005\f\u0005Q\t\u0005\u0001\u0005\u0003\u0005T\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\\\b\u0006\n\u0006\f\u0006_\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tv\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t~\b\t\n\t\f\t\u0081\t\t\u0001\t\u0000\u0001\u0012\n"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0003\u0001\u0000"+
		"\u000e\u0010\u0001\u0000\u0011\u0014\u0001\u0000\u0015\u0017\u008d\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u0004$"+
		"\u0001\u0000\u0000\u0000\u00066\u0001\u0000\u0000\u0000\b8\u0001\u0000"+
		"\u0000\u0000\n>\u0001\u0000\u0000\u0000\fU\u0001\u0000\u0000\u0000\u000e"+
		"b\u0001\u0000\u0000\u0000\u0010f\u0001\u0000\u0000\u0000\u0012u\u0001"+
		"\u0000\u0000\u0000\u0014\u0016\u0003\u0002\u0001\u0000\u0015\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0019\u0001\u0000\u0000\u0000\u0017\u0015\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u001a\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u001a\u001b\u0005"+
		"\u0000\u0000\u0001\u001b\u0001\u0001\u0000\u0000\u0000\u001c#\u0003\u0004"+
		"\u0002\u0000\u001d#\u0003\u0006\u0003\u0000\u001e#\u0003\b\u0004\u0000"+
		"\u001f#\u0003\n\u0005\u0000 #\u0003\f\u0006\u0000!#\u0003\u000e\u0007"+
		"\u0000\"\u001c\u0001\u0000\u0000\u0000\"\u001d\u0001\u0000\u0000\u0000"+
		"\"\u001e\u0001\u0000\u0000\u0000\"\u001f\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0003\u0001\u0000\u0000"+
		"\u0000$%\u0005\u0001\u0000\u0000%&\u0003\u0010\b\u0000&\'\u0005\u001b"+
		"\u0000\u0000\'(\u0005\u0002\u0000\u0000()\u0003\u0012\t\u0000)*\u0005"+
		"\u001e\u0000\u0000*\u0005\u0001\u0000\u0000\u0000+,\u0005\u001b\u0000"+
		"\u0000,-\u0005\u0002\u0000\u0000-.\u0003\u0012\t\u0000./\u0005\u001e\u0000"+
		"\u0000/7\u0001\u0000\u0000\u000001\u0005\u0003\u0000\u000012\u0005\u001b"+
		"\u0000\u000027\u0005\u001e\u0000\u000034\u0005\u0004\u0000\u000045\u0005"+
		"\u001b\u0000\u000057\u0005\u001e\u0000\u00006+\u0001\u0000\u0000\u0000"+
		"60\u0001\u0000\u0000\u000063\u0001\u0000\u0000\u00007\u0007\u0001\u0000"+
		"\u0000\u000089\u0005\u0005\u0000\u00009:\u0005\u0006\u0000\u0000:;\u0003"+
		"\u0012\t\u0000;<\u0005\u0007\u0000\u0000<=\u0005\u001e\u0000\u0000=\t"+
		"\u0001\u0000\u0000\u0000>?\u0005\b\u0000\u0000?@\u0005\u0006\u0000\u0000"+
		"@A\u0003\u0012\t\u0000AB\u0005\u0007\u0000\u0000BF\u0005\t\u0000\u0000"+
		"CE\u0003\u0002\u0001\u0000DC\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000"+
		"\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0001\u0000"+
		"\u0000\u0000HF\u0001\u0000\u0000\u0000IS\u0005\n\u0000\u0000JK\u0005\u000b"+
		"\u0000\u0000KO\u0005\t\u0000\u0000LN\u0003\u0002\u0001\u0000ML\u0001\u0000"+
		"\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000"+
		"RT\u0005\n\u0000\u0000SJ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000"+
		"T\u000b\u0001\u0000\u0000\u0000UV\u0005\f\u0000\u0000VW\u0005\u0006\u0000"+
		"\u0000WX\u0003\u0012\t\u0000XY\u0005\u0007\u0000\u0000Y]\u0005\t\u0000"+
		"\u0000Z\\\u0003\u0002\u0001\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0005\n\u0000\u0000a\r"+
		"\u0001\u0000\u0000\u0000bc\u0005\r\u0000\u0000cd\u0003\u0012\t\u0000d"+
		"e\u0005\u001e\u0000\u0000e\u000f\u0001\u0000\u0000\u0000fg\u0007\u0000"+
		"\u0000\u0000g\u0011\u0001\u0000\u0000\u0000hi\u0006\t\uffff\uffff\u0000"+
		"ij\u0005\u0018\u0000\u0000jv\u0003\u0012\t\bkl\u0005\u0006\u0000\u0000"+
		"lm\u0003\u0012\t\u0000mn\u0005\u0007\u0000\u0000nv\u0001\u0000\u0000\u0000"+
		"ov\u0005\u001b\u0000\u0000pv\u0005\u001c\u0000\u0000qv\u0005\u001d\u0000"+
		"\u0000rv\u0005\u0010\u0000\u0000sv\u0005\u0019\u0000\u0000tv\u0005\u001a"+
		"\u0000\u0000uh\u0001\u0000\u0000\u0000uk\u0001\u0000\u0000\u0000uo\u0001"+
		"\u0000\u0000\u0000up\u0001\u0000\u0000\u0000uq\u0001\u0000\u0000\u0000"+
		"ur\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000ut\u0001\u0000\u0000"+
		"\u0000v\u007f\u0001\u0000\u0000\u0000wx\n\n\u0000\u0000xy\u0007\u0001"+
		"\u0000\u0000y~\u0003\u0012\t\u000bz{\n\t\u0000\u0000{|\u0007\u0002\u0000"+
		"\u0000|~\u0003\u0012\t\n}w\u0001\u0000\u0000\u0000}z\u0001\u0000\u0000"+
		"\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0013\u0001\u0000\u0000\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\n\u0017\"6FOS]u}\u007f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}