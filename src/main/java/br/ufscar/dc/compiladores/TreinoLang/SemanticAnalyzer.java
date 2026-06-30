package br.ufscar.dc.compiladores.TreinoLang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ufscar.dc.compiladores.parser.*;

public class SemanticAnalyzer extends TreinoLangBaseVisitor<Void> {

    private final List<String> erros = new ArrayList<>();

    private final Set<String> exerciciosDeclarados = new HashSet<>();

    private final TabelaExercicios tabela = new TabelaExercicios();

    public List<String> getErros() {
        return erros;
    }

    @Override
    public Void visitExercicio(
            TreinoLangParser.ExercicioContext ctx) {

        String nome = ctx.ID().getText();

        GrupoMuscular grupo = GrupoMuscular.fromString(
                ctx.GRUPO().getText());

        Objetivo objetivo = Objetivo.fromString(
                ctx.OBJETIVO().getText());

        int series = Integer.parseInt(ctx.INT(0).getText());

        int repeticoes = Integer.parseInt(ctx.INT(1).getText());

        int carga = Integer.parseInt(ctx.INT(2).getText());

        // 1 - Exercício duplicado
        if (!exerciciosDeclarados.add(nome)) {

            erros.add(
                    "Exercicio " + nome +
                            " ja declarado.");
        }

        // 2 - Exercício conhecido
        if (!tabela.existe(nome)) {

            erros.add(
                    "Exercicio " + nome +
                            " nao existe.");

            return null;
        }

        ExercicioInfo info = tabela.get(nome);

        // 3 - Grupo compatível
        if (info.getGrupo() != grupo) {

            erros.add(
                    "Exercicio " + nome +
                            " nao pertence ao grupo "
                            + grupo + ".");
        }

        // 4 - Objetivo compatível
        if (!info.getObjetivos().contains(objetivo)) {

            erros.add(
                    "Exercicio " + nome +
                            " nao e recomendado para "
                            + objetivo + ".");
        }

        // 5 - Séries
        if (series <= 0) {

            erros.add(
                    "Exercicio " + nome +
                            ": series deve ser maior que zero.");
        }

        // 6 - Repetições
        if (repeticoes <= 0) {

            erros.add(
                    "Exercicio " + nome +
                            ": repeticoes deve ser maior que zero.");
        }

        // 7 - Carga
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