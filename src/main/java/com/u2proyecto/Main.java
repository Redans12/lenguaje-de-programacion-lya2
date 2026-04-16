package com.u2proyecto;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final String EXTENSION = "ebda";
    private static final String DIRBASE = "src/test/resources/";

    public static void main(String[] args) throws IOException {
        String files[] = args.length==0? new String[]{ "test." + EXTENSION } : args;
        System.out.println("Dirbase: " + DIRBASE);
        for (String file : files){
            System.out.println("START: " + file);

            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            EBDALexer lexer = new EBDALexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EBDAParser parser = new EBDAParser(tokens);
            EBDAParser.StartContext tree = parser.start();
            EBDACustomVisitor visitor = new EBDACustomVisitor();
            visitor.visit(tree);

            System.out.println("FINISH: " + file);
        }
    }
}
