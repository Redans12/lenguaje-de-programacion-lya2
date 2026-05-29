package com.u2proyecto;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    private static final String EXTENSION = "ebda";
    private static final String DIRBASE = "src/test/resources/";
    private static final String OUTBASE = "src/test/resources/output/";

    public static void main(String[] args) throws IOException {
        String files[] = args.length == 0
                ? new String[] {
                        "test." + EXTENSION,
                        "factorial." + EXTENSION,
                        "fibonacci." + EXTENSION,
                        "tablas." + EXTENSION,
                        "primos." + EXTENSION,
                        "mcd." + EXTENSION,
                        "sumatoria." + EXTENSION
                }
                : args;
        System.out.println("Dirbase: " + DIRBASE);

        // crear carpeta output si no existe
        new java.io.File(OUTBASE).mkdirs();

        for (String file : files) {
            System.out.println("Programa: " + file);
            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            EBDALexer lexer = new EBDALexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EBDAParser parser = new EBDAParser(tokens);
            EBDAParser.StartContext tree = parser.start();

            // intérprete
            EBDACustomVisitor visitor = new EBDACustomVisitor();
            visitor.visit(tree);

            // traducción y guardado
            String nombre = file.replace("." + EXTENSION, "");
            traducir(tree, new EBDAToPythonVisitor(), OUTBASE + nombre + ".py");
            traducir(tree, new EBDAToCVisitor(), OUTBASE + nombre + ".c");
            traducir(tree, new EBDAToCSharpVisitor(), OUTBASE + nombre + ".cs");
            traducir(tree, new EBDAToJavaScriptVisitor(), OUTBASE + nombre + ".js");
            traducir(tree, new EBDAToCppVisitor(), OUTBASE + nombre + ".cpp");

            System.out.println("FINISH: " + file);
        }
    }

    private static void traducir(EBDAParser.StartContext tree,
            EBDABaseVisitor<String> visitor,
            String rutaSalida) throws IOException {
        String codigo = visitor.visit(tree);
        try (PrintWriter pw = new PrintWriter(rutaSalida, "UTF-8")) {
            pw.print(codigo);
        }
        System.out.println("Exportado: " + rutaSalida);
    }
}