package br.ufscar.dc.compiladores.TreinoLang;

// Representa os grupos musculares válidos para exercícios no TreinoLang.
public enum GrupoMuscular {

    PEITO,
    COSTAS,
    PERNAS,
    OMBROS,
    BICEPS,
    TRICEPS;

    // Converte uma string para o enum correspondente, ignorando caixa.
    // Retorna null se o texto não corresponder a um grupo conhecido.
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