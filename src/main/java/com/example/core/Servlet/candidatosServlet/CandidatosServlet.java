package com.example.core.Servlet.candidatosServlet;

import com.example.core.Model.Candidato;
import com.example.core.View.CandidatosHTMLCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@WebServlet( value = "/candidatos")
public class CandidatosServlet extends HttpServlet {
    private CandidatosHTMLCreator candidatosHTMLCreator = new CandidatosHTMLCreator();
    private List<Candidato> candidatos = new ArrayList<>();

    // LISTAGEM CANDIDATOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        if (session.isNew()) {
            out.println(candidatosHTMLCreator.getTableHtml(candidatos));
        }
        else {
            List<Candidato> candidatosSession = (List<Candidato>) session.getAttribute("candidatos");
            this.candidatos = Objects.isNull(candidatosSession) ? this.candidatos : candidatosSession;
            out.println(candidatosHTMLCreator.getTableHtml(this.candidatos));
        }
    }

    // SALVAR CANDIDATO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String numero = request.getParameter("numero");


        if (Objects.isNull(id) || id.length() == 0){
            System.out.println("doPost: new candidato");
            Candidato candidato = new Candidato(UUID.randomUUID().toString(),nome,Integer.valueOf(numero));
            candidatos.add(candidato);
            session.setAttribute("candidatos",candidatos);
        }
        else {
            System.out.println("doPost: "+ id);
            for(Candidato candidato : candidatos){
                if (candidato.getId().equals(id)){
                    candidato.setNome(nome);
                    candidato.setNumeroCandidato(Integer.valueOf(numero));
                }
            }
        }
        response.sendRedirect(request.getRequestURI());
    }
}
