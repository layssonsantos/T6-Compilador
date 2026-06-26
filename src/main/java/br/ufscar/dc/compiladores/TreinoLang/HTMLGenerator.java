package br.ufscar.dc.compiladores.TreinoLang;

import br.ufscar.dc.compiladores.parser.*;

public class HTMLGenerator extends TreinoLangBaseVisitor<String> {

    @Override
    public String visitProgram(TreinoLangParser.ProgramContext ctx) {

        StringBuilder html = new StringBuilder();

        String nomeTreino = ctx.ID().getText();

        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <title>");
        html.append(nomeTreino);
        html.append("</title>\n");
        html.append("</head>\n");

        html.append("<body>\n");

        html.append("    <h1>");
        html.append(nomeTreino);
        html.append("</h1>\n");

        html.append("    <table border=\"1\">\n");
        html.append("        <tr>\n");
        html.append("            <th>Exercício</th>\n");
        html.append("            <th>Séries</th>\n");
        html.append("            <th>Repetições</th>\n");
        html.append("            <th>Carga (kg)</th>\n");
        html.append("        </tr>\n");

        for (TreinoLangParser.ExercicioContext ex : ctx.exercicio()) {
            html.append(visitExercicio(ex));
        }

        html.append("    </table>\n");
        html.append("</body>\n");
        html.append("</html>\n");

        return html.toString();
    }

    @Override
    public String visitExercicio(TreinoLangParser.ExercicioContext ctx) {

        String nome = ctx.ID().getText();
        String series = ctx.INT(0).getText();
        String repeticoes = ctx.INT(1).getText();
        String carga = ctx.INT(2).getText();

        StringBuilder html = new StringBuilder();

        html.append("        <tr>\n");

        html.append("            <td>");
        html.append(nome);
        html.append("</td>\n");

        html.append("            <td>");
        html.append(series);
        html.append("</td>\n");

        html.append("            <td>");
        html.append(repeticoes);
        html.append("</td>\n");

        html.append("            <td>");
        html.append(carga);
        html.append("</td>\n");

        html.append("        </tr>\n");

        return html.toString();
    }
}