package main;

import lexico.LexicalScanner;
import lexico.Token;

public class MainClass {
    public static void main(String[] args) {
        try {
            LexicalScanner sc = new LexicalScanner("LexicalAnalyzer/Input.txt");
            Token token = null;
            do {
                token = sc.nextToken();
                if (token != null) {
                    System.out.println(token);
                }
            } while (token != null);

            System.out.println("Compilado");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
