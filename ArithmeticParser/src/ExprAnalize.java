import java.util.ArrayList;
import java.util.List;

public class ExprAnalize {
    List<Lexeme> lexemeList=new ArrayList<>();
    private String expr;
    LexemeBuffer lexemes;
    private int pos;
    ExprAnalize(String expr) {
        this.expr=expr;
    }


    public List<Lexeme> analize() {
        pos=0;

        while(pos<expr.length()) {

            char c=expr.charAt(pos);

            switch(c){
                case '*': lexemeList.add(new Lexeme(LexemeTypes.MULT,c));
                          pos++;
                          break;
                case '/': lexemeList.add(new Lexeme(LexemeTypes.DIV,c));
                          pos++;
                          break;
                case '+': lexemeList.add(new Lexeme(LexemeTypes.PLUS,c));
                          pos++;
                          break;
                case '-': lexemeList.add(new Lexeme(LexemeTypes.MINUS,c));
                          pos++;
                          break;
                case '(': lexemeList.add(new Lexeme(LexemeTypes.L_BRACKET,c));
                          pos++;
                          break;
                case ')': lexemeList.add(new Lexeme(LexemeTypes.R_BRACKET,c));
                          pos++;
                          break;
                default:

                    if (c>='0' && c<='9') {
                        StringBuffer sb=new StringBuffer();
                        do {
                            sb.append(c);
                            pos++;
                            if(pos>=expr.length()){
                                break;
                            }
                            c=expr.charAt(pos);
                        } while (c>='0' && c<='9');
                        lexemeList.add(new Lexeme(LexemeTypes.NUMBER,sb.toString()));
                    } else {
                        if (c!=' '){
                            throw new RuntimeException("Undefined symbol: " + c);
                        }
                        pos++;
                    }
            }
        }
        lexemeList.add(new Lexeme(LexemeTypes.EOF,""));
        return lexemeList;
    }
}
