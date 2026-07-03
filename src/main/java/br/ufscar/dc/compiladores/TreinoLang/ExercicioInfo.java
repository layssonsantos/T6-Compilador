package br.ufscar.dc.compiladores.TreinoLang;

import java.util.Set;

// Representa as informações de um exercício treinado no TreinoLang.
public class ExercicioInfo {

    // Grupo muscular alvo do exercício.
    private final GrupoMuscular grupo;

    // Conjunto de objetivos associados ao exercício.
    private final Set<Objetivo> objetivos;

    public ExercicioInfo(
            GrupoMuscular grupo,
            Set<Objetivo> objetivos) {

        this.grupo = grupo;
        this.objetivos = objetivos;
    }

    // Retorna o grupo muscular do exercício.
    public GrupoMuscular getGrupo() {
        return grupo;
    }

    // Retorna os objetivos do exercício.
    public Set<Objetivo> getObjetivos() {
        return objetivos;
    }

}