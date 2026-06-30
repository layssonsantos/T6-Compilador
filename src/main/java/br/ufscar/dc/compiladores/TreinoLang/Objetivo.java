package br.ufscar.dc.compiladores.TreinoLang;

public enum Objetivo {

    FORCA,
    HIPERTROFIA,
    RESISTENCIA;

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