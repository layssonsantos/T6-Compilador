package br.ufscar.dc.compiladores.TreinoLang;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;

public class TreinoLangErrorListener extends BaseErrorListener {

    public static List<String> erros = new ArrayList<>();

    @Override
    public void syntaxError(
            Recognizer<?, ?> recognizer,
            Object offendingSymbol,
            int line,
            int charPositionInLine,
            String msg,
            RecognitionException e) {

        erros.add(
                "Linha " + line +
                        ": erro sintatico proximo a " +
                        ((Token) offendingSymbol).getText());
    }
}