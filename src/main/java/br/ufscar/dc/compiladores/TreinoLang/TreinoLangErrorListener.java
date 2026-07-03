package br.ufscar.dc.compiladores.TreinoLang;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;

// Listener de erro usado pelo ANTLR para capturar mensagens de análise sintática.
public class TreinoLangErrorListener extends BaseErrorListener {

    // Acumula mensagens de erro sintático encontradas durante a análise.
    public static List<String> erros = new ArrayList<>();

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e) {

        // Registra erro sintático com a linha e o token próximo ao erro.
        erros.add(
                "Linha " + line +
                        ": erro sintatico proximo a " +
                        ((Token) offendingSymbol).getText());
    }
}