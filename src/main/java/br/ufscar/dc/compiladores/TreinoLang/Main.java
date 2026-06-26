package br.ufscar.dc.compiladores.TreinoLang;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import br.ufscar.dc.compiladores.parser.TreinoLangLexer;
import br.ufscar.dc.compiladores.parser.TreinoLangParser;

public class Main {

    private static final List<String> errosLexSint = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        if (args.length != 2) {
            System.out.println(
                    "Uso: java -jar compilador.jar <entrada> <saida>");
            return;
        }

        String arquivoEntrada = args[0];
        String arquivoSaida = args[1];

        CharStream input = CharStreams.fromFileName(arquivoEntrada);

        TreinoLangLexer lexer = new TreinoLangLexer(input);

        lexer.removeErrorListeners();
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(
                    Recognizer<?, ?> recognizer,
                    Object offendingSymbol,
                    int line,
                    int charPositionInLine,
                    String msg,
                    RecognitionException e) {

                errosLexSint.add(
                        "Linha " + line +
                                ": erro lexico proximo a " +
                                offendingSymbol);
            }
        });

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        TreinoLangParser parser = new TreinoLangParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(
                    Recognizer<?, ?> recognizer,
                    Object offendingSymbol,
                    int line,
                    int charPositionInLine,
                    String msg,
                    RecognitionException e) {

                errosLexSint.add(
                        "Linha " + line +
                                ": erro sintatico proximo a " +
                                ((Token) offendingSymbol).getText());
            }
        });

        ParseTree tree = parser.program();

        try (PrintWriter writer = new PrintWriter(arquivoSaida)) {

            if (!errosLexSint.isEmpty()) {
                for (String erro : errosLexSint) {
                    writer.println(erro);
                }
                return;
            }

            SemanticAnalyzer semantico = new SemanticAnalyzer();

            semantico.visit(tree);

            if (!semantico.getErros().isEmpty()) {
                for (String erro : semantico.getErros()) {
                    writer.println(erro);
                }
            } else {
                HTMLGenerator generator = new HTMLGenerator();

                writer.print(generator.visit(tree));
            }
        }
    }
}