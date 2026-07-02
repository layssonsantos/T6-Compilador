package br.ufscar.dc.compiladores.TreinoLang;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class TabelaExercicios {

        private final Map<String, ExercicioInfo> tabela = new HashMap<>();

        public TabelaExercicios() {

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

        public boolean existe(String nome) {
                return tabela.containsKey(nome);
        }

        public ExercicioInfo get(String nome) {
                return tabela.get(nome);
        }
}