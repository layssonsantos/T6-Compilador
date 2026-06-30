package br.ufscar.dc.compiladores.TreinoLang;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class TabelaExercicios {

    private final Map<String, ExercicioInfo> tabela = new HashMap<>();

    public TabelaExercicios() {

        tabela.put(
                "Supino",
                new ExercicioInfo(
                        GrupoMuscular.PEITO,
                        EnumSet.of(
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA)));

        tabela.put(
                "Crucifixo",
                new ExercicioInfo(
                        GrupoMuscular.PEITO,
                        EnumSet.of(
                                Objetivo.HIPERTROFIA)));

        tabela.put(
                "Remada",
                new ExercicioInfo(
                        GrupoMuscular.COSTAS,
                        EnumSet.of(
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA)));

        tabela.put(
                "Puxada",
                new ExercicioInfo(
                        GrupoMuscular.COSTAS,
                        EnumSet.of(
                                Objetivo.RESISTENCIA,
                                Objetivo.HIPERTROFIA)));

        tabela.put(
                "Agachamento",
                new ExercicioInfo(
                        GrupoMuscular.PERNAS,
                        EnumSet.of(
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA)));

        tabela.put(
                "LegPress",
                new ExercicioInfo(
                        GrupoMuscular.PERNAS,
                        EnumSet.of(
                                Objetivo.HIPERTROFIA)));

        tabela.put(
                "Desenvolvimento",
                new ExercicioInfo(
                        GrupoMuscular.OMBROS,
                        EnumSet.of(
                                Objetivo.FORCA,
                                Objetivo.HIPERTROFIA)));

        tabela.put(
                "RoscaDireta",
                new ExercicioInfo(
                        GrupoMuscular.BICEPS,
                        EnumSet.of(
                                Objetivo.HIPERTROFIA)));

        tabela.put(
                "TricepsPulley",
                new ExercicioInfo(
                        GrupoMuscular.TRICEPS,
                        EnumSet.of(
                                Objetivo.HIPERTROFIA,
                                Objetivo.RESISTENCIA)));
    }

    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }

    public ExercicioInfo get(String nome) {
        return tabela.get(nome);
    }

}