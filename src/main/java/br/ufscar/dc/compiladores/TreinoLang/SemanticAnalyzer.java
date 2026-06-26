package br.ufscar.dc.compiladores.TreinoLang;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import br.ufscar.dc.compiladores.parser.*;

public class SemanticAnalyzer extends TreinoLangBaseVisitor<Void> {

    private final List<String> erros = new ArrayList<>();

    private final Set<String> exercicios = new HashSet<>();

    public List<String> getErros() {
        return erros;
    }

    @Override
    public Void visitExercicio(TreinoLangParser.ExercicioContext ctx) {

        int series = Integer.parseInt(ctx.INT(0).getText());

        int repeticoes = Integer.parseInt(ctx.INT(1).getText());

        int carga = Integer.parseInt(ctx.INT(2).getText());

        String nome = ctx.ID().getText();

        if (!exercicios.add(nome)) {
            erros.add(
                    "Exercicio " + nome +
                            " ja declarado.");
        }

        if (series <= 0) {
            erros.add(
                    "Exercicio " + nome +
                            ": series deve ser maior que zero.");
        }

        if (repeticoes <= 0) {
            erros.add(
                    "Exercicio " + nome +
                            ": repeticoes deve ser maior que zero.");
        }

        if (carga <= 0) {
            erros.add(
                    "Exercicio " + nome +
                            ": carga deve ser maior que zero.");
        }

        if (carga > 500) {
            erros.add(
                    "Exercicio " + nome +
                            ": carga excede o limite permitido.");
        }

        return null;
    }
}