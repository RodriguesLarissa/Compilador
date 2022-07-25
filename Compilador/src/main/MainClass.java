package main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import parser.IsiLangLexer;
import parser.IsiLangParser;

public class MainClass {
  public static void main(String[] args) {

    try {
      IsiLangLexer lexer;
      IsiLangParser parser;

      // Leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
      lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));

      // crio um fluxo de tokens para passar para o PARSER
      CommonTokenStream tokenStream = new CommonTokenStream(lexer);

      // crio meu parser a partir desse tokenStream
      parser = new IsiLangParser(tokenStream);

      parser.prog();

      System.out.println("Compilation Successful");
    } catch (Exception ex) {
      System.err.println("ERROR " + ex.getMessage());
    }
  }

}