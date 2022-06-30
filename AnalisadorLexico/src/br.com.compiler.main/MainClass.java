package br.com.compiler.main;

import AnalisadorLexico.src.br.com.compiler.lexico.ScannerComp;

public class MainClass {
    public static void main(String[] args){
        try {
            ScannerComp sc = new ScannerComp("Input.txt");

            System.out.println("Compilado");
        } catch(Exception ex) {
            System.out.println("Erro!");
        }
    }
}