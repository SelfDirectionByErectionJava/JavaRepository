import java.util.List;

public class ExprParser {
//    expr: plusminus* EOF;
//    plusminus:multdiv((+|-)multdiv)*;
//    multdiv:factor((*|/)factor)*;
//    factor:number|('('expr')');


    LexemeBuffer lexemes;
    int value=0;


    public int expr(LexemeBuffer lexemes){
        Lexeme lex=lexemes.next();
        if(lex.lexemeType==LexemeTypes.EOF){
            return 0;
        }
         lexemes.back();
         return plusminus(lexemes);
    }

    public int plusminus(LexemeBuffer lexemes) {
        int value=multdiv(lexemes);

            while(true) {
                Lexeme lex=lexemes.next();
                switch(lex.lexemeType) {
                    case PLUS:
                        value+=multdiv(lexemes);
                        break;
                    case MINUS:
                        value-=multdiv(lexemes);
                        break;
                    case R_BRACKET:
                    case EOF:
                        lexemes.back();
                        return value;
                    default:
                        throw new RuntimeException("undefined operation or number at position:" + lexemes.getPos() + " is " + lex.value);
                }
            }

    }

    public int multdiv(LexemeBuffer lexemes) {
        int value=factor(lexemes);
        while(true){
            Lexeme lex=lexemes.next();
            switch (lex.lexemeType) {
                case MULT:
                    value*=factor(lexemes);
                    break;
                case DIV:
                    value/=factor(lexemes);
                    break;
                case MINUS:
                case PLUS:
                case EOF:
                case R_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("undefined operation or number at position:" + lexemes.getPos() + " is " + lex.value);
            }
        }
    }

    public int factor(LexemeBuffer lexemes) {
        Lexeme lex=lexemes.next();
        switch(lex.lexemeType) {
            case MINUS:
                int value=factor(lexemes);
                return -value;
            case NUMBER:
                return Integer.parseInt(lex.value);
            case L_BRACKET:
                value=plusminus(lexemes);
                lex=lexemes.next();
                if (lex.lexemeType==LexemeTypes.R_BRACKET) {
                    return value;
                } else {
                    throw new RuntimeException("undefined operation or number at position:" + lexemes.getPos() + " is " + lex.value);
                }
            default:
                throw new RuntimeException("undefined operation or number at position:" + lexemes.getPos() + " is " + lex.value);
        }


    }
    






}
