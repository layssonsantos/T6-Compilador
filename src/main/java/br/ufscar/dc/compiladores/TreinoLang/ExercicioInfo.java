package br.ufscar.dc.compiladores.TreinoLang;

import java.util.Set;

public class ExercicioInfo {

    private final GrupoMuscular grupo;

    private final Set<Objetivo> objetivos;

    public ExercicioInfo(
            GrupoMuscular grupo,
            Set<Objetivo> objetivos) {

        this.grupo = grupo;
        this.objetivos = objetivos;
    }

    public GrupoMuscular getGrupo() {
        return grupo;
    }

    public Set<Objetivo> getObjetivos() {
        return objetivos;
    }

}