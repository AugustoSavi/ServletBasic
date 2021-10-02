package com.example.core.Servlet.candidatosServlet;

import com.example.core.Model.Candidato;
import com.example.core.View.CandidatoHTMLCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@WebServlet( value = "/candidato-edit")
public class CandidatoEditServlet extends HttpServlet {

    private CandidatoHTMLCreator candidatoHTMLCreator = new CandidatoHTMLCreator();
    private static Pattern pattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    // EDIT CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String id = String.valueOf(request.getParameter("id"));
        Candidato candidato = new Candidato();

        List<Candidato> candidatos = (List<Candidato>)session.getAttribute("candidatos");
        if(pattern.matcher(id).matches() && Objects.nonNull(candidatos)) {
            candidato = candidatos.stream().filter(cand -> cand.getId().equals(id)).findFirst().orElse(null);
        }
        out.println(candidatoHTMLCreator.getPageHtml(candidato));
    }
}
