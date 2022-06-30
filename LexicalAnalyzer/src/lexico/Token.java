package lexico;

public class Token {
    public static final int TK_IDENTIFIER = 0;
    public static final int TK_NUMBER = 1;
    public static final int TK_OPERATOR = 2;
    public static final int TK_PONCTUATION = 3;
    public static final int TK_ASSIGN = 4;
    public static final int TK_TEXT = 5;
    public static final int TK_EXPR_SINAL = 6;
    public static final int TK_DOUBLE = 7;

    public static final String TK_LABELS[] = {
            "IDENTIFIER", "NUMBER", "OPERATOR", "PONCTUACTION", "ASSIGNMENT", "TEXT", "EXPRESSION SINAL", "DOUBLE"
    };
    private int type;
    private String text;

    public Token(int type, String text) {
        super();
        this.type = type;
        this.text = text;
    }

    public Token(int type) {
        super();
        this.type = type;
    }

    public int getType() {
        return type;
    }

    // public void setType(int type) {
    // this.type = type;
    // }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Token [type=" + TK_LABELS[type] + ", text=" + text + "]";
    }
}
