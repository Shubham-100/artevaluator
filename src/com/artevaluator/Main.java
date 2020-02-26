package com.artevaluator;
import com.artevaluator.grammar.Lexer;
import  com.artevaluator.grammar.Token;
import  com.artevaluator.grammar.Parser;

import com.artevaluator.grammar.Node;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();

        Lexer lexr = new Lexer(exp+"##");
        lexr.tokenize();
        ArrayList<Token> a = lexr.getTokenized();
        a.add(new Token("EOF","EOF"));
        for (Token token : a) {
            System.out.println(token.tokToString() + " ");
        }

        Parser parsr = new Parser(a);
        System.out.println(parsr.isValid());
        System.out.println(parsr.getAST());
        parsr.printExp();
    }
}
