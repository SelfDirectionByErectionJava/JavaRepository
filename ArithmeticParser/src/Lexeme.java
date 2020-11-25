public class Lexeme {
    LexemeTypes lexemeType;
    String value;

    public Lexeme(LexemeTypes lexemeType, String value) {
        this.lexemeType = lexemeType;
        this.value = value;
    }
    public Lexeme(LexemeTypes lexemeType, Character value) {
        this.lexemeType = lexemeType;
        this.value = value.toString();
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "lexemeType=" + lexemeType +
                ", value='" + value + '\'' +
                '}';
    }
}
