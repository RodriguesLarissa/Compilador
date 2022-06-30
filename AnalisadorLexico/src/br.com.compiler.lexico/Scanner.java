package br.com.compiler.lexico;

public class Scanner {
    private char[] content;
    private int estado;
    private int    pos;
    private int    line;
    private int    column;

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

    public Token nextToken(){
        char currentChar;
        estado = 0;
        Token token;
        String term="";

        if(isEOF()){
            return null;
        }

        while(true){
            currentChar = nextChar();
            column++;

            switch(estado){
                case 0:
                    if (isSpace(currentChar)) {
                        estado = 0;
                    }
                    else if isChar(currentChar){
                        term += currentChar;
                        estado = 1;
                    }
                    else if (isDigit(currentChar)){
                        term += currentChar;
                        estado = 3;
                    }
                    
            }
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
}