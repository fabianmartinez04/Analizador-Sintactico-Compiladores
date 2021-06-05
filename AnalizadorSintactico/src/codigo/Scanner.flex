package codigo;
import java_cup.runtime.*;
/* User code */
%%
%public
%class LexerCup
%cupsym Sym
%cup
%char
%column
%line
%full
%ignorecase
%line
%unicode

/* Regular expressions */
L=[a-zA-Z_]
Acentos  = [a-zA-Z]
DecDigit = [0-9]
HexDigit = (0|-0)(x|X)[0-9A-Fa-f]+
BinDigit = [0|1]+
OctDigit = 0[1-7]+
WhiteSpace = [ \t\r\n\f]+
BackSlash = [\\]
Invalid = "ç"|"Ç"|"ñ"|"'"|"Ñ"|"&"|"^"|"@"|"'"|"ê"|"«"|"¿"|"¡"|"Ü"|"╝"|"á"|"é"|"í"|"ó"|"ú"|"Á"|"É"|"Í"|"Ó"|"Ú"
CommentMultiline = "/*" ~"*/"
Comment = "//".*
%%

/* Lexical Rules */


/* Arithmetic Operators*/    
<YYINITIAL> "++" { return new Symbol(Sym.INCR, yycolumn, yyline, yytext()); }
<YYINITIAL> "--" { return new Symbol(Sym.DECR, yycolumn, yyline, yytext()); }
<YYINITIAL> "=" { return new Symbol(Sym.EQUAL, yycolumn, yyline, yytext()); }
<YYINITIAL> "+" { return new Symbol(Sym.ADD, yycolumn, yyline, yytext()); }
<YYINITIAL> "-" { return new Symbol(Sym.SUB, yycolumn, yyline, yytext()); }
<YYINITIAL> "*" { return new Symbol(Sym.MUL, yycolumn, yyline, yytext()); }
<YYINITIAL> "/" { return new Symbol(Sym.DIV, yycolumn, yyline, yytext()); }
<YYINITIAL> "%" { return new Symbol(Sym.MOD, yycolumn, yyline, yytext()); }
<YYINITIAL> "(" { return new Symbol(Sym.OPEN_BRACKET, yycolumn, yyline, yytext()); }
<YYINITIAL> ")" { return new Symbol(Sym.CLOSE_BRACKET, yycolumn, yyline, yytext()); }
<YYINITIAL> "+=" { return new Symbol(Sym.ADD_EQUAL, yycolumn, yyline, yytext()); }
<YYINITIAL> "-=" { return new Symbol(Sym.SUB_EQUAL, yycolumn, yyline, yytext()); }
<YYINITIAL> "*=" { return new Symbol(Sym.MUL_EQUAL, yycolumn, yyline, yytext()); }
<YYINITIAL> "/=" { return new Symbol(Sym.DIV_EQUAL, yycolumn, yyline, yytext()); }
<YYINITIAL> "{" { return new Symbol(Sym.OPEN_KEY, yycolumn, yyline, yytext()); }
<YYINITIAL> "}" { return new Symbol(Sym.CLOSE_KEY, yycolumn, yyline, yytext()); }

/*Logical Operators*/
<YYINITIAL> "==" { return new Symbol(Sym.EQUAL_TO, yycolumn, yyline, yytext()); }
<YYINITIAL> ">=" { return new Symbol(Sym.GREATER_EQUAL, yycolumn, yyline, yytext()); }
<YYINITIAL> ">" { return new Symbol(Sym.LESS, yycolumn, yyline, yytext()); }
<YYINITIAL> "<=" { return new Symbol(Sym.LESS_EQUAL, yycolumn, yyline, yytext()); }
<YYINITIAL> "<" { return new Symbol(Sym.GREATER, yycolumn, yyline, yytext()); }
<YYINITIAL> "!=" { return new Symbol(Sym.NOT_EQUAL, yycolumn, yyline, yytext()); }
<YYINITIAL> "||" { return new Symbol(Sym.LOGICAL_OR, yycolumn, yyline, yytext()); }
<YYINITIAL> "&&" { return new Symbol(Sym.LOGICAL_AND, yycolumn, yyline, yytext()); }
<YYINITIAL> "!" { return new Symbol(Sym.LOGICAL_NOT, yycolumn, yyline, yytext()); }


/*Comments*/
{Comment} {/*Ignore*/} 
{CommentMultiline} {/* Ignore */}

/*LITERALS*/

/*Strings*/
("\""({BackSlash}|{L}|{DecDigit}|" "|"\t"|"\r"|{Invalid}|{Acentos})*"\"") { return new Symbol(Sym.LITERAL_STR, yycolumn, yyline, yytext()); }

/*Char*/
 ("\'"({BackSlash}|{L}|{DecDigit}|" "|"\t"|"\r"|{Invalid}|{Acentos})"\'")  { return new Symbol(Sym.LITERAL_CHAR, yycolumn, yyline, yytext()); }


/*Numbers*/

/*Flotante con exponente*/
// {DecDigit}+.{DecDigit}+(e|E)(-{DecDigit}+|{DecDigit}+) { return new Symbol(Sym.FLOAT_POINT_NUMBER, yycolumn, yyline, yytext()); }


/*Octal number*/
 {OctDigit} {return new Symbol(Sym.OCTAL_NUMBER, yycolumn, yyline, yytext()); }

/*Decimal number*/
 {DecDigit}+|("-"{DecDigit}+) { return new Symbol(Sym.NUMBER, yycolumn, yyline, yytext()); }

/*Hexadecimal number*/
 {HexDigit} { return new Symbol(Sym.HEXADECIMAL_NUMBER, yycolumn, yyline, yytext()); }


/*Float number*/
// ({DecDigit}+|{DecDigit}+)"."{DecDigit}+ { return new Symbol(Sym.FLOAT_NUMBER, yycolumn, yyline, yytext()); }


/*ERROR*/
(({DecDigit}|{Invalid}{L})({L}|{DecDigit}|{Invalid})*)|({L}*{Invalid}+{DecDigit}*{L}*)* { System.out.println("ERROR: " + yytext() + " columna: " + yycolumn + " fila: " + yyline); }

/*White Space*/
{WhiteSpace} {/*Ignore*/}

/*KeyWords*/
<YYINITIAL> "break" { return new Symbol(Sym.I_BREAK, yycolumn, yyline, yytext()); }
<YYINITIAL> "case" { return new Symbol(Sym.I_CASE, yycolumn, yyline, yytext()); }
<YYINITIAL> "char" { return new Symbol(Sym.I_CHAR, yycolumn, yyline, yytext()); }
<YYINITIAL> "const" { return new Symbol(Sym.I_CONST, yycolumn, yyline, yytext()); }
<YYINITIAL> "continue" { return new Symbol(Sym.I_CONTINUE, yycolumn, yyline, yytext()); }
<YYINITIAL> "default" { return new Symbol(Sym.I_DEFAULT, yycolumn, yyline, yytext()); }
<YYINITIAL> "do" { return new Symbol(Sym.I_DO, yycolumn, yyline, yytext()); }
<YYINITIAL> "else" { return new Symbol(Sym.I_ELSE, yycolumn, yyline, yytext()); }
<YYINITIAL> "for" { return new Symbol(Sym.I_FOR, yycolumn, yyline, yytext()); }
<YYINITIAL> "if" { return new Symbol(Sym.I_IF, yycolumn, yyline, yytext()); }
<YYINITIAL> "int" { return new Symbol(Sym.I_INT, yycolumn, yyline, yytext()); }
<YYINITIAL> "long" { return new Symbol(Sym.I_LONG, yycolumn, yyline, yytext()); }
<YYINITIAL> "return" { return new Symbol(Sym.I_RETURN, yycolumn, yyline, yytext()); }
<YYINITIAL> "short" { return new Symbol(Sym.I_SHORT, yycolumn, yyline, yytext()); }
<YYINITIAL> "switch" { return new Symbol(Sym.I_SWITCH, yycolumn, yyline, yytext()); }
<YYINITIAL> "void" { return new Symbol(Sym.I_VOID, yycolumn, yyline, yytext()); }
<YYINITIAL> "while" { return new Symbol(Sym.I_WHILE, yycolumn, yyline, yytext()); }
<YYINITIAL> ";" { return new Symbol(Sym.SEMICOLON, yycolumn, yyline, yytext()); }
<YYINITIAL> "," { return new Symbol(Sym.COMMA, yycolumn, yyline, yytext()); }
<YYINITIAL> ":" { return new Symbol(Sym.COLON, yycolumn, yyline, yytext()); }
<YYINITIAL> "read" { return new Symbol(Sym.I_READ, yycolumn, yyline, yytext()); }
<YYINITIAL> "write" { return new Symbol(Sym.I_WRITE, yycolumn, yyline, yytext()); }

/*Identifiers*/
{L}({L}|{DecDigit})* { return new Symbol(Sym.IDENTIFIER, yycolumn, yyline, yytext()); }



<YYINITIAL> . { System.out.println("ERROR:" + yytext() + " columna: " + yycolumn + " fila: " + yyline); }