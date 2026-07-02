package br.ufscar.dc.compiladores.TreinoLang;

import br.ufscar.dc.compiladores.parser.*;

public class HTMLGenerator extends TreinoLangBaseVisitor<String> {

    @Override
    public String visitProgram(TreinoLangParser.ProgramContext ctx) {

        StringBuilder html = new StringBuilder();

        String nomeTreino = ctx.ID().getText();
        String tipoTreino = ctx.TIPO_TREINO().getText();

        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"pt-BR\">\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <title>Treino ");
        html.append(nomeTreino);
        html.append("</title>\n");

        adicionarCSS(html);

        html.append("</head>\n");

        html.append("<body>\n");

        html.append("<div class=\"container\">\n");

        html.append("<h1>Ficha de Treino</h1>\n");

        html.append("<h2>");
        html.append(nomeTreino);
        html.append("</h2>\n");

        html.append("<p class=\"tipo\">");
        html.append("<strong>Tipo:</strong> ");
        html.append(tipoTreino);
        html.append("</p>\n");

        html.append("<table>\n");

        html.append("<thead>\n");
        html.append("<tr>\n");
        html.append("<th>Exercício</th>\n");
        html.append("<th>Grupo</th>\n");
        html.append("<th>Objetivo</th>\n");
        html.append("<th>Séries</th>\n");
        html.append("<th>Repetições</th>\n");
        html.append("<th>Carga</th>\n");
        html.append("</tr>\n");
        html.append("</thead>\n");

        html.append("<tbody>\n");

        for (TreinoLangParser.ExercicioContext ex : ctx.exercicio()) {
            html.append(visitExercicio(ex));
        }

        html.append("</tbody>\n");
        html.append("</table>\n");

        html.append("<p class=\"total\">");
        html.append("Total de exercícios: ");
        html.append(ctx.exercicio().size());
        html.append("</p>\n");

        html.append("<footer>\n");
        html.append("Gerado automaticamente pelo compilador TreinoLang.");
        html.append("</footer>\n");

        html.append("</div>\n");

        html.append("</body>\n");
        html.append("</html>\n");

        return html.toString();
    }

    @Override
    public String visitExercicio(TreinoLangParser.ExercicioContext ctx) {

        StringBuilder html = new StringBuilder();

        html.append("<tr>\n");

        html.append("<td>");
        html.append(ctx.ID().getText());
        html.append("</td>\n");

        html.append("<td>");
        html.append(ctx.GRUPO().getText());
        html.append("</td>\n");

        html.append("<td>");
        html.append(ctx.OBJETIVO().getText());
        html.append("</td>\n");

        html.append("<td>");
        html.append(ctx.INT(0).getText());
        html.append("</td>\n");

        html.append("<td>");
        html.append(ctx.INT(1).getText());
        html.append("</td>\n");

        html.append("<td>");
        html.append(ctx.INT(2).getText());
        html.append(" kg");
        html.append("</td>\n");

        html.append("</tr>\n");

        return html.toString();
    }

    private void adicionarCSS(StringBuilder html) {

        html.append("<style>\n");

        html.append("body {\n");
        html.append("    font-family: Arial, Helvetica, sans-serif;\n");
        html.append("    background-color: #f4f4f4;\n");
        html.append("    margin: 0;\n");
        html.append("    padding: 40px;\n");
        html.append("}\n");

        html.append(".container {\n");
        html.append("    max-width: 1000px;\n");
        html.append("    margin: auto;\n");
        html.append("    background: white;\n");
        html.append("    padding: 30px;\n");
        html.append("    border-radius: 10px;\n");
        html.append("    box-shadow: 0 0 10px rgba(0,0,0,0.15);\n");
        html.append("}\n");

        html.append("h1 {\n");
        html.append("    text-align: center;\n");
        html.append("    color: #1f2937;\n");
        html.append("    margin-bottom: 5px;\n");
        html.append("}\n");

        html.append("h2 {\n");
        html.append("    text-align: center;\n");
        html.append("    color: #4b5563;\n");
        html.append("    margin-top: 0;\n");
        html.append("    margin-bottom: 30px;\n");
        html.append("}\n");

        html.append(".tipo {\n");
        html.append("    font-size: 18px;\n");
        html.append("    margin-bottom: 25px;\n");
        html.append("}\n");

        html.append("table {\n");
        html.append("    width: 100%;\n");
        html.append("    border-collapse: collapse;\n");
        html.append("}\n");

        html.append("th {\n");
        html.append("    background-color: #2563eb;\n");
        html.append("    color: white;\n");
        html.append("    padding: 12px;\n");
        html.append("}\n");

        html.append("td {\n");
        html.append("    border: 1px solid #dddddd;\n");
        html.append("    padding: 10px;\n");
        html.append("    text-align: center;\n");
        html.append("}\n");

        html.append("tr:nth-child(even) {\n");
        html.append("    background-color: #f8fafc;\n");
        html.append("}\n");

        html.append("tr:hover {\n");
        html.append("    background-color: #eef4ff;\n");
        html.append("}\n");

        html.append(".total {\n");
        html.append("    margin-top: 20px;\n");
        html.append("    font-size: 17px;\n");
        html.append("    font-weight: bold;\n");
        html.append("}\n");

        html.append("footer {\n");
        html.append("    margin-top: 35px;\n");
        html.append("    text-align: center;\n");
        html.append("    color: #666666;\n");
        html.append("    font-size: 13px;\n");
        html.append("    border-top: 1px solid #dddddd;\n");
        html.append("    padding-top: 15px;\n");
        html.append("}\n");

        html.append("</style>\n");
    }
}