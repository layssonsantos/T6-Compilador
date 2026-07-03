package br.ufscar.dc.compiladores.TreinoLang;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

// Mantém um cadastro fixo de exercícios válidos para o compilador.
public class TabelaExercicios {

        // Mapeia nome de exercício para suas informações de grupo e objetivos.
        private final Map<String, ExercicioInfo> tabela = new HashMap<>();

        public TabelaExercicios() {

                // Inicializa a tabela com os exercícios suportados.

                // =====================
                // PEITO
                // =====================

                adicionar(
                                "Supino",
                                GrupoMuscular.PEITO,
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "SupinoInclinado",
                                GrupoMuscular.PEITO,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "Crucifixo",
                                GrupoMuscular.PEITO,
                                Objetivo.HIPERTROFIA);

                // =====================
                // COSTAS
                // =====================

                adicionar(
                                "Remada",
                                GrupoMuscular.COSTAS,
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "RemadaBaixa",
                                GrupoMuscular.COSTAS,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "RemadaCurvada",
                                GrupoMuscular.COSTAS,
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "Puxada",
                                GrupoMuscular.COSTAS,
                                Objetivo.HIPERTROFIA,
                                Objetivo.RESISTENCIA);

                adicionar(
                                "PuxadaFrente",
                                GrupoMuscular.COSTAS,
                                Objetivo.HIPERTROFIA,
                                Objetivo.RESISTENCIA);

                // =====================
                // PERNAS
                // =====================

                adicionar(
                                "Agachamento",
                                GrupoMuscular.PERNAS,
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "LegPress",
                                GrupoMuscular.PERNAS,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "MesaFlexora",
                                GrupoMuscular.PERNAS,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "CadeiraExtensora",
                                GrupoMuscular.PERNAS,
                                Objetivo.HIPERTROFIA,
                                Objetivo.RESISTENCIA);

                adicionar(
                                "Stiff",
                                GrupoMuscular.PERNAS,
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA);

                // =====================
                // OMBROS
                // =====================

                adicionar(
                                "Desenvolvimento",
                                GrupoMuscular.OMBROS,
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "ElevacaoLateral",
                                GrupoMuscular.OMBROS,
                                Objetivo.HIPERTROFIA);

                // =====================
                // BÍCEPS
                // =====================

                adicionar(
                                "RoscaDireta",
                                GrupoMuscular.BICEPS,
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "RoscaMartelo",
                                GrupoMuscular.BICEPS,
                                Objetivo.HIPERTROFIA);

                // =====================
                // TRÍCEPS
                // =====================

                adicionar(
                                "TricepsPulley",
                                GrupoMuscular.TRICEPS,
                                Objetivo.HIPERTROFIA,
                                Objetivo.RESISTENCIA);

                adicionar(
                                "TricepsFrances",
                                GrupoMuscular.TRICEPS,
                                Objetivo.HIPERTROFIA);

                adicionar(
                                "Mergulho",
                                GrupoMuscular.TRICEPS,
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA);
        }

        // Adiciona um exercício à tabela, criando um conjunto de objetivos.
        private void adicionar(
                        String nome,
                        GrupoMuscular grupo,
                        Objetivo... objetivos) {

                tabela.put(
                                nome,
                                new ExercicioInfo(
                                                grupo,
                                                EnumSet.of(objetivos[0], objetivos)));
        }

        // Verifica se o exercício existe na tabela.
        public boolean existe(String nome) {
                return tabela.containsKey(nome);
        }

        // Retorna as informações do exercício, ou null se não existir.
        public ExercicioInfo get(String nome) {
                return tabela.get(nome);
        }
}