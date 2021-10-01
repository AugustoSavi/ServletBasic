package com.example.core.View;

import com.example.core.Model.Candidato;

import java.util.List;

public class CandidatosListCreator {

    public String getTableHtml(List<Candidato> candidatos){
        String page = "<html>" +
                "<head> " +
                "<meta charset=\"UTF-8\"> " +
                "<title>Candidatos</title> <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">" +
                "<script src=\"https://kit.fontawesome.com/311492eabd.js\" crossorigin=\"anonymous\"></script>" +
                "</head>" +
                "<body class=\"container text-align\">" +
                    "<div id=\"button-cadastrar\">" +
                        "<a href=\"newCandidato.html\" class=\"btn btn-primary btn-block mt-5\">Cadastrar candidato</a>" +
                    "</div>" +

                "<div id=\"table-dados\" class=\"mt-3\">" +
                    "<table class=\"table\">" +
                        "<thead>" +
                        "<tr>" +
                            "<th scope=\"col\">Id</th>" +
                            "<th scope=\"col\">Nome</th>" +
                            "<th scope=\"col\">Numero Candidato</th>" +
                            "<th scope=\"col\"></th>" +
                            "<th scope=\"col\"></th>" +
                        "</tr>" +
                        "</thead>" +
                "<tbody>";

        String dados = "";
        for (Candidato candidato : candidatos) {
            dados =  "<tr>" +
                        "<td>" + candidato.getId() + "</td>" +
                        "<td>" + candidato.getNome() + "</td>" +
                        "<td>" + candidato.getNumeroCandidato() + "</td>" +
                        "<td><a onclick=_delete(\""+ candidato.getId() +"\") class=\"fas fa-pencil-alt\"></a></td>" +
                    "</tr>" ;
        }
        page += dados;
        page += "</tbody>";
        page += "</table>";
        page += "</div>";
        page += "</body>";
        page +="<script>\n" +
                "    function _delete(id){\n" +
                "         console.log(id); \n" +
                "        var HEADERS = new Headers();\n" +
                "        HEADERS.append('id', id);\n" +
                "        var CONFIG = { method: 'DELETE',\n" +
                "            headers: HEADERS,\n" +
                "            mode: 'cors'};\n" +
                "\n" +
                "        fetch('candidato?'+ new URLSearchParams({id}),CONFIG)" +
                "       .then(function(response) {" +
                "       if (response.ok) {" +
                "       console.log(\"request ok\")} " +
                "       else {console.log(\"error: \" + response);}})" +
                "    }\n" +
                "</script>";
        page += "</html>";

        return page;
    }
}
