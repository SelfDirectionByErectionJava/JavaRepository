public class MainClass {
    public static void main(String[] args) {
        String expr = "45 + 5 * (104-54*(15-14)) / 2 - 10";
       // String expr = "5 + - - 5";
        ExprAnalize exprAnalize=new ExprAnalize(expr);
        LexemeBuffer lexemeBuffer=new LexemeBuffer(exprAnalize.analize());
        ExprParser exprParser=new ExprParser();
        int g=exprParser.expr(lexemeBuffer);
        System.out.println(g);





    }
}
