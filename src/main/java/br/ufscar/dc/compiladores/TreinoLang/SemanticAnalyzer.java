package br.ufscar.dc.compiladores.TreinoLang;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.ufscar.dc.compiladores.parser.*;

public class SemanticAnalyzer extends TreinoLangBaseVisitor<Void> {

        // Acumula erros de validação encontrados no programa
        private final List<String> erros = new ArrayList<>();

        // Controla declarações duplicadas de exercício
        private final Set<String> exerciciosDeclarados = new HashSet<>();

        // Base de dados de exercícios conhecidos e suas regras
        private final TabelaExercicios tabela = new TabelaExercicios();

        // ===== Informações coletadas durante a visita =====

        // Grupos musculares usados no treino atual
        private final Set<GrupoMuscular> gruposTreino = new HashSet<>();

        // Volume total do treino calculado por exercício
        private int volumeTreino = 0;

        // Quantidade de exercícios por grupo muscular
        private final Map<GrupoMuscular, Integer> quantidadePorGrupo = new EnumMap<>(GrupoMuscular.class);

        public List<String> getErros() {
                return erros;
        }

        @Override
        public Void visitExercicio(TreinoLangParser.ExercicioContext ctx) {

                // Dados extraídos do contexto do exercício
                String nome = ctx.ID().getText();

                GrupoMuscular grupo = GrupoMuscular.fromString(
                                ctx.GRUPO().getText());

                Objetivo objetivo = Objetivo.fromString(
                                ctx.OBJETIVO().getText());

                int series = Integer.parseInt(ctx.INT(0).getText());

                int repeticoes = Integer.parseInt(ctx.INT(1).getText());

                int carga = Integer.parseInt(ctx.INT(2).getText());

                volumeTreino += series * repeticoes * carga;

                // Guarda informações para análise global do treino
                gruposTreino.add(grupo);

                quantidadePorGrupo.merge(grupo, 1, Integer::sum);

                // --------------------------
                // Exercício conhecido
                // --------------------------

                if (!tabela.existe(nome)) {

                        erros.add(
                                        "Exercicio " + nome + " nao existe.");

                        return null;
                }

                ExercicioInfo info = tabela.get(nome);

                // --------------------------
                // Exercício duplicado
                // --------------------------

                if (!exerciciosDeclarados.add(nome)) {

                        erros.add(
                                        "Exercicio " + nome +
                                                        " ja declarado.");

                        return null;
                }

                // --------------------------
                // Grupo compatível
                // --------------------------

                if (info.getGrupo() != grupo) {

                        erros.add(
                                        "Exercicio " + nome +
                                                        " nao pertence ao grupo " +
                                                        grupo + ".");
                }

                // --------------------------
                // Objetivo compatível
                // --------------------------

                if (!info.getObjetivos().contains(objetivo)) {

                        erros.add(
                                        "Exercicio " + nome +
                                                        " nao e recomendado para " +
                                                        objetivo + ".");
                }

                // --------------------------
                // Séries
                // --------------------------

                if (series <= 0) {

                        erros.add(
                                        "Exercicio " + nome +
                                                        ": series deve ser maior que zero.");
                }

                // --------------------------
                // Repetições
                // --------------------------

                if (repeticoes <= 0) {

                        erros.add(
                                        "Exercicio " + nome +
                                                        ": repeticoes deve ser maior que zero.");
                }

                // --------------------------
                // Carga
                // --------------------------

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

                // --------------------------
                // Objetivo x Repetições
                // --------------------------

                switch (objetivo) {

                        case FORCA:

                                if (repeticoes > 6) {

                                        erros.add(
                                                        "Exercicio " + nome +
                                                                        ": repeticoes incompatíveis com FORCA.");
                                }

                                break;

                        case HIPERTROFIA:

                                if (repeticoes < 6 || repeticoes > 15) {

                                        erros.add(
                                                        "Exercicio " + nome +
                                                                        ": repeticoes incompatíveis com HIPERTROFIA.");
                                }

                                break;

                        case RESISTENCIA:

                                if (repeticoes < 15) {

                                        erros.add(
                                                        "Exercicio " + nome +
                                                                        ": repeticoes incompatíveis com RESISTENCIA.");
                                }

                                break;
                }

                return null;
        }

        @Override
        public Void visitProgram(TreinoLangParser.ProgramContext ctx) {

                // Visita todos os exercícios antes de validar regras globais
                visitChildren(ctx);

                String tipoTreino = ctx.TIPO_TREINO().getText();

                // ---------------------------------------
                // 1) Consistência do treino
                // ---------------------------------------

                switch (tipoTreino) {

                        case "PUSH":

                                for (GrupoMuscular grupo : gruposTreino) {

                                        if (grupo != GrupoMuscular.PEITO
                                                        && grupo != GrupoMuscular.OMBROS
                                                        && grupo != GrupoMuscular.TRICEPS) {

                                                erros.add(
                                                                "Treino PUSH nao permite exercicios do grupo "
                                                                                + grupo + ".");
                                        }
                                }

                                break;

                        case "PULL":

                                for (GrupoMuscular grupo : gruposTreino) {

                                        if (grupo != GrupoMuscular.COSTAS
                                                        && grupo != GrupoMuscular.BICEPS) {

                                                erros.add(
                                                                "Treino PULL nao permite exercicios do grupo "
                                                                                + grupo + ".");
                                        }
                                }

                                break;

                        case "LEGS":

                                for (GrupoMuscular grupo : gruposTreino) {

                                        if (grupo != GrupoMuscular.PERNAS) {

                                                erros.add(
                                                                "Treino LEGS nao permite exercicios do grupo "
                                                                                + grupo + ".");
                                        }
                                }

                                break;

                        case "FULLBODY":
                                // aceita qualquer grupo
                                break;
                }

                // ---------------------------------------
                // 2) Balanceamento do treino por grupo muscular
                // ---------------------------------------

                switch (tipoTreino) {

                        case "PUSH":

                                if (!quantidadePorGrupo.containsKey(GrupoMuscular.PEITO)
                                                || !quantidadePorGrupo.containsKey(GrupoMuscular.OMBROS)
                                                || !quantidadePorGrupo.containsKey(GrupoMuscular.TRICEPS)) {

                                        erros.add("Treino PUSH esta desbalanceado.");
                                }

                                break;

                        case "PULL":

                                if (!quantidadePorGrupo.containsKey(GrupoMuscular.COSTAS)
                                                || !quantidadePorGrupo.containsKey(GrupoMuscular.BICEPS)) {

                                        erros.add("Treino PULL esta desbalanceado.");
                                }

                                break;

                        case "LEGS":

                                if (!quantidadePorGrupo.containsKey(GrupoMuscular.PERNAS)) {

                                        erros.add("Treino LEGS esta desbalanceado.");
                                }

                                break;

                        case "FULLBODY":

                                if (quantidadePorGrupo.size() < 3) {

                                        erros.add("Treino FULLBODY esta desbalanceado.");
                                }

                                break;
                }

                // ---------------------------------------
                // 3) Volume total do treino (séries x repetições x carga)
                // ---------------------------------------

                switch (tipoTreino) {

                        case "PUSH":

                                if (volumeTreino < 4000) {
                                        erros.add("Treino PUSH possui volume muito baixo.");
                                }

                                if (volumeTreino > 9000) {
                                        erros.add("Treino PUSH possui volume muito alto.");
                                }

                                break;

                        case "PULL":

                                if (volumeTreino < 4000) {
                                        erros.add("Treino PULL possui volume muito baixo.");
                                }

                                if (volumeTreino > 9000) {
                                        erros.add("Treino PULL possui volume muito alto.");
                                }

                                break;

                        case "LEGS":

                                if (volumeTreino < 8000) {
                                        erros.add("Treino LEGS possui volume muito baixo.");
                                }

                                if (volumeTreino > 18000) {
                                        erros.add("Treino LEGS possui volume muito alto.");
                                }

                                break;

                        case "FULLBODY":

                                if (volumeTreino < 7000) {
                                        erros.add("Treino FULLBODY possui volume muito baixo.");
                                }

                                if (volumeTreino > 16000) {
                                        erros.add("Treino FULLBODY possui volume muito alto.");
                                }

                                break;
                }

                return null;
        }

}