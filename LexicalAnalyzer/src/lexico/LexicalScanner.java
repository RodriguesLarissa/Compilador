package lexico;

import java.nio.file.Files;
import java.nio.file.Paths;

public class LexicalScanner {
    private char[] content;
    private int pos;

    public LexicalScanner(String filename) {
        try {
            pos = 0;
            String txtContent;
            txtContent = Files.readString(Paths.get(filename));
            content = txtContent.toCharArray();
            System.out.println("DEBUG------------");
            System.out.println(content);
            System.out.println("Length: " + content.length);
            System.out.println("------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Token nextToken() throws Exception {
        char currentChar;
        int state = 0;
        Token token;
        StringBuilder term = new StringBuilder();

        if (isEOF()) {
            return null;
        }

        while (true) {
            currentChar = nextChar();
            switch (state) {
                case 0:
                    if (isSpace(currentChar)) {
                        //Ignoring spaces, tabs and line breaks
                        break;
                    } else if (isChar(currentChar)) {
                        // Identifier
                        term.append(currentChar);
                        state = 1;
                    } else if (isDigit(currentChar)) {
                        // Number
                        term.append(currentChar);
                        state = 3;
                    } else if (isTwoDots(currentChar)) {
                        // Assignment
                        term.append(currentChar);
                        state = 6;
                    } else if (isOperator(currentChar)) {
                        // Operators
                        term.append(currentChar);
                        state = 9;
                    } else if (isExprSinals(currentChar)) {
                        // Expression signs
                        term.append(currentChar);
                        token = new Token(Token.TK_EXPR_SINAL);
                        token.setText(term.toString());
                        return token;
                    } else if (isPunctuation(currentChar)) {
                        // Punctuation
                        term.append(currentChar);
                        token = new Token(Token.TK_PUNCTUATION);
                        token.setText(term.toString());
                        return token;
                    } else if (isQuoteMark(currentChar)) {
                        // Text
                        term.append(currentChar);
                        state = 14;
                    } else {
                        // Error - unrecognized character
                        throw new Exception("Unrecognized character");
                    }
                    break;
                case 1: // Identifier
                    if (isDigit(currentChar) || isChar(currentChar)) {
                        term.append(currentChar);
                        break;
                    } else if (isOperator(currentChar) || isExprSinals(currentChar) || isPunctuation(currentChar)
                            || isSpace(currentChar) || isEOF(currentChar) || isTwoDots(currentChar)
                            || isQuoteMark(currentChar) || isDecimalSeparator(currentChar)) {
                        if (!isEOF(currentChar)) {
                            back();
                        }
                        token = new Token(Token.TK_IDENTIFIER);
                        token.setText(term.toString());
                        return token;
                    } else {
                        // Error - malformed identifier (expected digit or char)
                        throw new Exception(
                                "Malformed identifier, expected digit or char, received: " + currentChar);
                    }
                case 3: // Number
                    if (isDigit(currentChar)) {
                        term.append(currentChar);
                        break;
                    } else if (isDecimalSeparator(currentChar)) {
                        term.append(currentChar);
                        state = 4;
                    } else if (isChar(currentChar) || isOperator(currentChar) || isExprSinals(currentChar)
                            || isPunctuation(currentChar) || isSpace(currentChar) || isEOF(currentChar)
                            || isTwoDots(currentChar) || isQuoteMark(currentChar)) {
                        if (!isEOF(currentChar)) {
                            back();
                        }
                        token = new Token(Token.TK_NUMBER);
                        token.setText(term.toString());
                        return token;
                    } else {
                        // Error - malformed integer (expected digit)
                        throw new Exception("Malformed number, expected a digit or decimal separator, received: "
                                + currentChar);
                    }
                    break;
                case 4: // Decimal
                    if (isDigit(currentChar)) {
                        // term.append(currentChar);
                        state = 5;
                    } else {
                        // Error - malformed decimal
                        throw new Exception("\n" + "Malformed decimal, expected one digit, received: " + currentChar);
                    }
                case 5:
                    if (isDigit(currentChar)) {
                        term.append(currentChar);
                        break;
                    } else if (isChar(currentChar) || isOperator(currentChar) || isExprSinals(currentChar)
                            || isPunctuation(currentChar) || isSpace(currentChar) || isEOF(currentChar)
                            || isTwoDots(currentChar) || isQuoteMark(currentChar) || isDecimalSeparator(currentChar)) {
                        if (!isEOF(currentChar)) {
                            back();
                        }
                        token = new Token(Token.TK_DOUBLE);
                        token.setText(term.toString());
                        return token;
                    } else {
                        // Error - malformed decimal (expected digit)
                        throw new Exception("\n" + "Malformed decimal, expected digit, received: " + currentChar);
                    }
                case 6: // Assignment
                    if (isEqualChar(currentChar)) {
                        term.append(currentChar);
                        token = new Token(Token.TK_ASSIGN);
                        token.setText(term.toString());
                        return token;
                    } else {
                        // Error - assignment malformation (expected '=')
                        throw new Exception("Malformed attributor, expected '=', received: " + currentChar);
                    }
                case 9: // Relational operator
                    if (isEqualChar(currentChar)) {
                        term.append(currentChar);
                        token = new Token(Token.TK_OPERATOR);
                        token.setText(term.toString());
                        return token;
                    } else if (isChar(currentChar) || isDigit(currentChar) || isOperator(currentChar)
                            || isExprSinals(currentChar) || isPunctuation(currentChar) || isSpace(currentChar)
                            || isEOF(currentChar) || isTwoDots(currentChar) || isQuoteMark(currentChar)
                            || isDecimalSeparator(currentChar)) {
                        if (!isEOF(currentChar)) {
                            back();
                        }
                        token = new Token(Token.TK_OPERATOR);
                        token.setText(term.toString());
                        return token;
                    } else {
                        // Error - relational operator malformation
                        throw new Exception("\n" + "Malformed operator, received: " + currentChar);
                    }
                case 14: // Text
                    if (isDigit(currentChar) || isChar(currentChar) || isWordSpace(currentChar)) {
                        term.append(currentChar);
                        state = 15;
                    } else {
                        // Error - bad text formation
                        throw new Exception("Malformed text, expected a digit or character or space, received: "
                                + currentChar);
                    }
                    break;
                case 15: // Text Continuation
                    if (isDigit(currentChar) || isChar(currentChar) || isWordSpace(currentChar)) {
                        term.append(currentChar);
                        break;
                    } else if (isQuoteMark(currentChar)) {
                        term.append(currentChar);
                        token = new Token(Token.TK_TEXT);
                        token.setText(term.toString());
                        return token;
                    } else {
                        // Error - bad text formation
                        throw new Exception(
                                "Malformed text, expected a digit or character or space or quotes, received: "
                                        + currentChar);
                    }
                default:
                    // Error - malformation of the state machine
                    throw new Exception("\n" + "Malformed state machine, state: " + state);

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

    private boolean isExprSinals(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    private boolean isPunctuation(char c) {
        return c == '{' || c == '}' || c == '(' || c == ')' || c == '.';
    }

    private boolean isSpace(char c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }

    private boolean isEqualChar(char c) {
        return c == '=';
    }

    private boolean isQuoteMark(char c) {
        return c == '"';
    }

    private boolean isTwoDots(char c) {
        return c == ':';
    }

    private boolean isDecimalSeparator(char c) {
        return c == '.';
    }

    private boolean isWordSpace(char c) {
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
        // column--;
    }
}
