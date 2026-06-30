package br.ufscar.dc.compiladores.TreinoLang;

public enum GrupoMuscular {

    PEITO,
    COSTAS,
    PERNAS,
    OMBROS,
    BICEPS,
    TRICEPS;

    public static GrupoMuscular fromString(String grupo) {

        switch (grupo.toUpperCase()) {

            case "PEITO":
                return PEITO;

            case "COSTAS":
                return COSTAS;

            case "PERNAS":
                return PERNAS;

            case "OMBROS":
                return OMBROS;

            case "BICEPS":
                return BICEPS;

            case "TRICEPS":
                return TRICEPS;

            default:
                return null;
        }
    }
}