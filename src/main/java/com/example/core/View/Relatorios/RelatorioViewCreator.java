package com.example.core.View.Relatorios;

import com.example.core.Model.Candidato;
import com.example.core.Model.Voto;

import java.util.List;
import java.util.stream.Collectors;

public class RelatorioViewCreator {

    public String getTableHtml(List<Candidato> candidatos, List<Voto> votos){
        String page = "<html>" +
                "<head> " +
                "<meta charset=\"UTF-8\"> " +
                "<title>Candidatos</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">" +
                "<script src=\"https://kit.fontawesome.com/311492eabd.js\" crossorigin=\"anonymous\"></script>" +
                "</head>" +
                "<body class=\"container text-align\">" +
                "<div id=\"button-cadastrar\">" +
                "<a href=\"index.html\" class=\"btn btn-primary btn-block mt-5\">Home</a>" +
                "</div>" +

                "<div id=\"table-dados\" class=\"mt-3\">" +
                "<h2 class=\"mx-auto\" style=\"width: 200px;\">\n" +
                "            Candidatos\n" +
                "        </h2>" +
                "<table class=\"table\">" +
                "<thead>" +
                "<tr>" +
                "<th scope=\"col\">Id</th>" +
                "<th scope=\"col\">Nome</th>" +
                "<th scope=\"col\">Numero Candidato</th>" +
                "<th scope=\"col\">Total de votos recebidos</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";

        String dados = "";
        for (Candidato candidato : candidatos) {
            dados +=  "<tr>" +
                    "<td>" + candidato.getId() + "</td>" +
                    "<td>" + candidato.getNome() + "</td>" +
                    "<td>" + candidato.getNumeroCandidato() + "</td>" +
                    "<td>" + totalVotosByCandidato(votos, candidato) + "</td>" +
                    "</tr>" ;
        }
        page += dados;
        page += "</tbody>";
        page += " <tfoot>\n" +
                "                <tr>\n" +
                "                  <td>Total registros: "+ candidatos.size() +"</td>\n" +
                "                </tr>\n" +
                "            </tfoot>";
        page += "</table>";

        page += getTableVoto(votos);

        page += "</div>";
        page += "</body>";
        page += "</html>";

        return page;
    }

    public String getTableVoto(List<Voto> votos){
        String page =
                "<h2 class=\"mx-auto\" style=\"width: 200px;\">\n" +
                        "            Votos\n" +
                        "        </h2>" +
                "<table class=\"table\">" +
                "<thead>" +
                "<tr>" +
                "<th scope=\"col\">Id voto</th>" +
                "<th scope=\"col\">Nome Candidato</th>" +
                "<th scope=\"col\">Numero Candidato</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>";

        String dados = "";
        for (Voto voto : votos) {
            dados +=  "<tr>" +
                    "<td>" + voto.getId() + "</td>" +
                    "<td>" + voto.getCandidato().getNome() + "</td>" +
                    "<td>" + voto.getCandidato().getNumeroCandidato() + "</td>" +
                    "</tr>" ;
        }
        page += dados;
        page += "</tbody>";
        page += " <tfoot>\n" +
                "                <tr>\n" +
                "                  <td>Total registros: "+ votos.size() +"</td>\n" +
                "                </tr>\n" +
                "            </tfoot>";
        page += "</table>";

        return page;
    }

    private Integer totalVotosByCandidato(List<Voto> votos, Candidato candidato) {
        return votos.stream().filter(voto -> voto.getCandidato().equals(candidato)).collect(Collectors.toList()).size();
    }
}
