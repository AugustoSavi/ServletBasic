package com.example.core.View;

import com.example.core.Model.Candidato;
import com.example.core.Model.Voto;

import java.util.List;
import java.util.Objects;

public class VotoHTMLCreator {

    public String getPageHtml(Voto voto, List<Candidato> candidatos){
        String page = "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Novo Candidato</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-sm-9 col-md-7 col-lg-5 mx-auto\">\n" +
                "            <div class=\"card border-0 shadow rounded-3 my-5\">\n" +
                "                <div class=\"card-body p-4 p-sm-5\">\n" +
                "                    <form action=\"voto\" method=\"POST\">\n" +
                "                        <div class=\"form-floating mb-3\">\n" +
                "                            <input type=\"text\" class=\"form-control\" "+ formatId(voto.getId())+" id=\"floatingid\" disabled name=\"id\" placeholder=\"id\">\n" +
                "                            <label for=\"floatingid\">id</label>\n" +
                "                        </div>\n" +
                "                        <div class=\"form-floating mb-3\">\n" +
                "                            <select pattern=\"[^a-zA-Z0-9]\" class=\"form-control\" name=\"candidato\" id=\"floatingCandidato\">\n" +
                "                                <option value=\"\">Selecione o Candidato</option>\n" +
                                                    generateOption(candidatos) +
                "                            </select>\n" +
                "                            <label for=\"floatingCandidato\">Candidato</label>\n" +
                "                        </div>\n" +
                "                        <div class=\"d-grid\">\n" +
                "                            <button class=\"btn btn-primary btn-login text-uppercase fw-bold\"\n" +
                "                                    type=\"submit\">Votar\n" +
                "                            </button>\n" +
                "                        </div>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        return page;
    }
    private String formatId(String uuid){
        String value = Objects.isNull(uuid) ? "\"\"" : uuid;
        return "value=".concat(value);
    }

    private String generateOption(List<Candidato> candidatos){
        String dados = "";
        for (Candidato candidato : candidatos) {
            dados +=  "<option value="+candidato.getId()+">"+
                    candidato.getNumeroCandidato() +
                    " - "+
                    candidato.getNome()+"</option>\n";
        }
        return dados;
    }
}
