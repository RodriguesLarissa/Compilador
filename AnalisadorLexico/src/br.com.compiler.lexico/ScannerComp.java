package br.com.compiler.lexico;

import AnalisadorLexico.src.br.com.compiler.lexico.Token;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScannerComp {
    private char[] content;
    private int estado;
    private int    pos;
    private int    line;
    private int    column;

    public ScannerComp(String filename){
        try {
            line = 1;
			column = 0;
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
                        //Ignorando espaços, tabulações e quebra linhas
                        estado = 0;
                    }
                    else if isChar(currentChar){
                        //Indentificador
                        term += currentChar;
                        estado = 1;
                    }
                    else if (isDigit(currentChar)){
                        //Numero
                        term += currentChar;
                        estado = 3;
                    }
                    else if (isTwoDots(currentChar)) {
                        //Atribuição
                        term += currentChar;
                        estado = 6;
                    }
                    else if (isOperator(currentChar)) {
                        //Operadores
                        term += currentChar;
                        estado = 9;
                    }
                    else if (isExprSinals(currentChar)) {
                        //Sinais de expressão
                        term += currentChar;
                        token = new Token(Token.TK_EXPR_SINAL);
                        token.setText(term);
                        return token;
                    }
                    else if (isPunctuation(currentChar)) {
                        //POntuação
                        term += currentChar;
                        token = new Token(Token.TK_PONCTUATION);
                        token.setText(term);
                        return token;
                    }
                    else if (isQuoteMark(currentChar)) {
                        //Texto
                        term += currentChar;
                        estado = 14;
                    }
                    else {
                        //Erro - caracter não reconhecido
                        throw new Exception("Caracter não reconhecido");
                    }                
                case 1: // Ientificador
                    if (isDigit(currentChar) || isChar(currentChar)) {
                        term += currentChar;
                        estado = 1;
                    }
                    else if (isOperator(currentChar) || isExprSinals(currentChar) || isPunctuation(currentChar) || isSpace(currentChar) || isEOF(currentChar) || isTwoDots(currentChar) || isQuoteMark(currentChar) || isDecimalSeparator(currentChar)) {
                        if (!isEOF(currentChar)) {
                            back();
                        }
                        token = new Token(Token.TK_IDENTIFIER);
                        token.setText(term);
                        return token;
                    }
                    else {
                        //Erro - identificador mal formado (esperado digito ou char)
                        throw new Exception("Indentificador mal formado, esperado um dígito ou caracter, recebido: " + currentChar);
                    }
                case 3: //Número
                    if (isDigit(currentChar)) {
                        term += currentChar;
                        estado = 3;
                    }
                    else if (isDecimalSeparator(currentChar)) {
                        term += currentChar;
                        estado = 4;
                    }
                    else if (isChar(currentChar) || isOperator(currentChar) || isExprSinals(currentChar) || isPunctuation(currentChar) || isSpace(currentChar) || isEOF(currentChar) || isTwoDots(currentChar) || isQuoteMark(currentChar)) {
                        if (!isEOF(currentChar)) {
                            back();
                        }
                        token = new Token(Token.TK_NUMBER);
                        token.setText(term);
                        return token;
                    }
                    else {
                        //Erro - número inteiro mal formado (esperado digito)
                        throw new Exception("Número mal formado, esperado um dígito ou separador de decimal, recebido: " + currentChar);
                    }
                case 4: //Decimal
                    if (isDigit(currentChar)) {
                        term += currentChar;
                        estado = 4;
                    }
                    else if (isChar(currentChar) || isOperator(currentChar) || isExprSinals(currentChar) || isPunctuation(currentChar) || isSpace(currentChar) || isEOF(currentChar) || isTwoDots(currentChar) || isQuoteMark(currentChar) || isDecimalSeparator(currentChar)) {
                        if (!isEOF(currentChar)) {
                            back();
                        }
                        token = new Token(Token.TK_DOUBLE);
                        token.setText(term);
                        return token;
                    }
                    else {
                        //Erro - decimal mal formado (esperado digito)
                        throw new Exception("Decimal mal formado, esperado um dígito, recebido: " + currentChar);
                    }
                case 6: //Atribuição
                    if (isEqualChar(currentChar)) {
                        term += currentChar;
                        token = new Token(Token.TK_ASSIGN);
                        token.setText(term);
                        return token;
                    }
                    else {
                        //Erro - má formação de atribuição (esperado '=')
                        throw new Exception("Atribuidor mal formado, esperado '=', recebido: " + currentChar);
                    }
                case 9: // Operador relacional
                    if(isEqualChar(currentChar)) {
                        term += currentChar;
                        token = new Token(Token.TK_OPERATOR);
                        token.setText(term);
                        return token;
                    }
                    else if (isChar(currentChar) || isDigit(currentChar) || isOperator(currentChar) || isExprSinals(currentChar) || isPunctuation(currentChar) || isSpace(currentChar) || isEOF(currentChar) || isTwoDots(currentChar) || isQuoteMark(currentChar) || isDecimalSeparator(currentChar)) {
                        if (!isEOF(currentChar)) {
                            back();
                        }
                        token = new Token(Token.TK_OPERATOR);
                        token.setText(term);
                        return token;
                    }
                    else {
                        //Erro - má formação de operador relacional (esperando '=')
                        throw new Exception("Operador mal formado, esperado '=', recebido: " + currentChar);
                    }
                case 14: //Texto
                    if (isDigit(currentChar) || isChar(currentChar) || isWordSpace(currentChar)) {
                        term += currentChar;
                        estado = 15;
                    }
                    else {
                        //Erro - má formação do texto
                        throw new Exception("Texto mal formado, esperado um dígito ou caracter ou espaço, recebido: " + currentChar);
                    }
                case 15: //Continuação do texto
                    if (isDigit(currentChar) || isChar(currentChar) || isWordSpace(currentChar)) {
                        term += currentChar;
                        estado = 15;
                    }
                    else if (isQuoteMark(currentChar)) {
                        term += currentChar;
                        token = new Token(Token.TK_TEXT);
                        token.setText(term);
                        return token;
                    }
                    else {
                        //Erro - má formação do texto
                        throw new Exception("Texto mal formado, esperado um dígito ou caracter ou espaço ou '""', recebido: " + currentChar);
                    }
                default:
                //Erro - mal formação da máquina de estado
                throw new Exception("Máquina de estado mal formada, estado: " + estado);
                    
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
        return c == '>' || c == '<' || c == '=' || c == '!';
    }

    private boolean isExprSinals () {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
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

    private boolean isEqualChar(char c) {
        return c == '=';
    }

    private boolean isQuoteMark (char c) {
        return c == '"';
    }

    private boolean isTwoDots (char c) {
        return c == ':';
    }

    private boolean isDecimalSeparator (char c) {
        return c == '.';
    }

    private boolean isWordSpace (char c) {
        return c == ' ';
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

    private boolean isEOF(char c) {
    	return c == '\0';
    }

    private void back() {
        pos--;
        column--;
    }
}