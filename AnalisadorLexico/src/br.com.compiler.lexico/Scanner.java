package br.com.compiler.lexico;

public class Scanner {
    private char[] content;

    public Scanner(String filename){
        try {
            String txtContent;
            txtContent = new String(Files.readAllBytes(Paths.get(filename), StandardCharsets.UTF_8));
            System.out.println("DEBUG------------");
            System.out.println(txtContent)
            System.out.println("------------")
            content = txtContent.toCharArray();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isOperator(char c) {
        return c == '>' || c == '<' || c == '=' || c == '!' || c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private boolean isPunctuation(char c){
        return c == '{' || c == '}' || c == '(' || c == ')' || c == '.';
    }

    private boolean isSpace(char c) {
        if (c == '\n' || c== '\r') {
            line++;
            column=0;
        }
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    private char nextChar() {
        if (isEOF()) {
            return '\0';
        }
        return content[pos++];
    }
    private boolean isEOF() {
        return pos >= content.length;
    }

    private void back() {
        pos--;
        column--;
    }

    private boolean isEOF(char c) {
        return c == '\0';
    }
}