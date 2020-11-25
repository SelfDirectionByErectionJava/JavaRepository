import java.util.List;

public class LexemeBuffer {
    List<Lexeme> lexemes;
    private int pos;

    LexemeBuffer(List<Lexeme> lexemes){
        this.lexemes=lexemes;
    }

    public Lexeme next() {
        return lexemes.get(pos++);
    }
    public void back() {
        pos--;
    }
    public int getPos() {
        return pos;
    }
}
