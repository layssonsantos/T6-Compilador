package br.ufscar.dc.compiladores.TreinoLang;

// Enumeração dos objetivos possíveis para um exercício.
public enum Objetivo {

    FORCA,
    HIPERTROFIA,
    RESISTENCIA;

    // Converte uma string para o enum correspondente, ignorando caixa.
    // Retorna null se o texto não corresponder a um objetivo conhecido.
    public static Objetivo fromString(String objetivo) {

        switch (objetivo.toUpperCase()) {

            case "FORCA":
                return FORCA;

            case "HIPERTROFIA":
                return HIPERTROFIA;

            case "RESISTENCIA":
                return RESISTENCIA;

            default:
                return null;
        }
    }

}