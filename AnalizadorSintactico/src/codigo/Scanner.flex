package codigo;
import java_cup.runtime.*;
/* User code */
%%
%public
%class Scanner
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
WhiteSpace = [ \t\r\n]+
BackSlash = [\\]
Operators = ","|";"|"++"|"--"|"=="|">="|">"|"?"|"<="|"<"|"!="|"||"|"&&"|"!"|"="|"+"|"-"|"*"|"/"|"%"|"("|")"|"["|"]"|"{"|"}"|":"|"."|"+="|"-="|"*="|"/="|"&"|"^"|"|"|">>"|"<<"|"~"|"%="|"&="|"^="|"|="|"<<="|">>="|"->"
Invalid = "ç"|"Ç"|"ñ"|"'"|"Ñ"|"&"|"/"|"%"|"^"|"@"|"'"|"ê"|"«"|"¿"|"¡"|"Ü"|"╝"|"á"|"é"|"í"|"ó"|"ú"|"Á"|"É"|"Í"|"Ó"|"Ú"
KeyWords = "auto"|"break"|"case"|"char"|"const"|"continue"|"default"|"do"|"double"|"else"|"enum"|"extern"|"float"|"for"|"goto"|"if"|"int"|"long"|"register"|"return"|"short"|"signed"|"sizeof"|"static"|"struct"|"switch"|"typedef"|"union"|"unsigned"|"void"|"volatile"|"while"
CommentMultiline = "/*" ~"*/"
Comment = "//".*
%%

/* Lexical Rules */


/* Arithmetic Operators*/    
<YYINITIAL> "++" { return new Symbol(Sym.incr, yycolumn, yyline, yytext()); }
<YYINITIAL> "--" { return new Symbol(Sym.decr, yycolumn, yyline, yytext()); }
<YYINITIAL> "=" { return new Symbol(Sym.equal, yycolumn, yyline, yytext()); }
<YYINITIAL> "+" { return new Symbol(Sym.add, yycolumn, yyline, yytext()); }
<YYINITIAL> "-" { return new Symbol(Sym.sub, yycolumn, yyline, yytext()); }
<YYINITIAL> "*" { return new Symbol(Sym.mul, yycolumn, yyline, yytext()); }
<YYINITIAL> "/" { return new Symbol(Sym.div, yycolumn, yyline, yytext()); }
<YYINITIAL> "%" { return new Symbol(Sym.mod, yycolumn, yyline, yytext()); }
<YYINITIAL> "(" { return new Symbol(Sym.open_bracket, yycolumn, yyline, yytext()); }
<YYINITIAL> ")" { return new Symbol(Sym.close_bracket, yycolumn, yyline, yytext()); }
<YYINITIAL> "+=" { return new Symbol(Sym.add_equal, yycolumn, yyline, yytext()); }
<YYINITIAL> "-=" { return new Symbol(Sym.sub_equal, yycolumn, yyline, yytext()); }
<YYINITIAL> "*=" { return new Symbol(Sym.mul_equal, yycolumn, yyline, yytext()); }
<YYINITIAL> "/=" { return new Symbol(Sym.div_equal, yycolumn, yyline, yytext()); }

/*Logical Operators*/
<YYINITIAL> "==" { return new Symbol(Sym.equal_to, yycolumn, yyline, yytext()); }
<YYINITIAL> ">=" { return new Symbol(Sym.greater_equal, yycolumn, yyline, yytext()); }
<YYINITIAL> ">" { return new Symbol(Sym.less, yycolumn, yyline, yytext()); }
<YYINITIAL> "<=" { return new Symbol(Sym.less_equal, yycolumn, yyline, yytext()); }
<YYINITIAL> "<" { return new Symbol(Sym.greater, yycolumn, yyline, yytext()); }
<YYINITIAL> "!=" { return new Symbol(Sym.not_equal, yycolumn, yyline, yytext()); }
<YYINITIAL> "||" { return new Symbol(Sym.logical_or, yycolumn, yyline, yytext()); }
<YYINITIAL> "&&" { return new Symbol(Sym.logical_and, yycolumn, yyline, yytext()); }
<YYINITIAL> "!" { return new Symbol(Sym.logical_not, yycolumn, yyline, yytext()); }
 

/*Comments*/
{Comment} {/*Ignore*/} 
{CommentMultiline} {/* Ignore */}

/*LITERALS*/

/*Strings*/
<YYINITIAL> ("\""({BackSlash}|{L}|{DecDigit}|" "|"\t"|"\r"|{Invalid}|{Acentos})*"\"") | ("\'"({BackSlash}|{L}|{DecDigit}|" "|"\t"|"\r"|{Invalid}|{Acentos})*"\'")  { return new Symbol(Sym.literal_str, yycolumn, yyline, yytext()); }


/*Numbers*/

/*Flotante con exponente*/
<YYINITIAL> {DecDigit}+.{DecDigit}+(e|E)(-{DecDigit}+|{DecDigit}+) { return new Symbol(Sym.float_point_number, yycolumn, yyline, yytext()); }


/*Octal number*/
<YYINITIAL> {OctDigit} {return new Symbol(Sym.octal_number, yycolumn, yyline, yytext()); }

/*Decimal number*/
<YYINITIAL> {DecDigit}+|("-"{DecDigit}+) { return new Symbol(Sym.number, yycolumn, yyline, yytext()); }

/*Hexadecimal number*/
<YYINITIAL> {HexDigit} { return new Symbol(Sym.hexadecimal_number, yycolumn, yyline, yytext()); }


/*Float number*/
<YYINITIAL> ({DecDigit}+|{DecDigit}+)"."{DecDigit}+ { return new Symbol(Sym.float_number, yycolumn, yyline, yytext()); }


/*ERROR*/
<YYINITIAL> (({DecDigit}|{Invalid}{L})({L}|{DecDigit}|{Invalid})*)|({L}*{Invalid}+{DecDigit}*{L}*)* { return new Symbol(Sym.ERROR, yycolumn, yyline, yytext()); }

/*White Space*/
{WhiteSpace} {/*Ignore*/}



/*KeyWords*/
<YYINITIAL> "break" { return new Symbol(Sym.i_break, yycolumn, yyline, yytext()); }
<YYINITIAL> "case" { return new Symbol(Sym.i_case., yycolumn, yyline, yytext()); }
<YYINITIAL> "char" { return new Symbol(Sym.i_char, yycolumn, yyline, yytext()); }
<YYINITIAL> "const" { return new Symbol(Sym.i_const, yycolumn, yyline, yytext()); }
<YYINITIAL> "continue" { return new Symbol(Sym.i_continue, yycolumn, yyline, yytext()); }
<YYINITIAL> "default" { return new Symbol(Sym.i_default, yycolumn, yyline, yytext()); }
<YYINITIAL> "do" { return new Symbol(Sym.i_do, yycolumn, yyline, yytext()); }
<YYINITIAL> "else" { return new Symbol(Sym.i_else, yycolumn, yyline, yytext()); }
<YYINITIAL> "for" { return new Symbol(Sym.i_for, yycolumn, yyline, yytext()); }
<YYINITIAL> "if" { return new Symbol(Sym.i_if, yycolumn, yyline, yytext()); }
<YYINITIAL> "int" { return new Symbol(Sym.i_int, yycolumn, yyline, yytext()); }
<YYINITIAL> "long" { return new Symbol(Sym.i_long, yycolumn, yyline, yytext()); }
<YYINITIAL> "return" { return new Symbol(Sym.i_return, yycolumn, yyline, yytext()); }
<YYINITIAL> "short" { return new Symbol(Sym.i_short, yycolumn, yyline, yytext()); }
<YYINITIAL> "switch" { return new Symbol(Sym.i_switch, yycolumn, yyline, yytext()); }
<YYINITIAL> "void" { return new Symbol(Sym.i_void, yycolumn, yyline, yytext()); }
<YYINITIAL> "while" { return new Symbol(Sym.i_while, yycolumn, yyline, yytext()); }

/*Identifiers*/
<YYINITIAL> {L}({L}|{DecDigit})* { return new Symbol(Sym.identifier, yycolumn, yyline, yytext()); }



. { return new Symbol(Sym.ERROR, yycolumn, yyline, yytext()); }