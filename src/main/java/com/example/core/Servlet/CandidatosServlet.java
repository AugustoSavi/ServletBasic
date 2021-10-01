package com.example.core.Servlet;

import com.example.core.Model.Candidato;
import com.example.core.View.CandidatosListCreator;

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
    private CandidatosListCreator candidatosListCreator = new CandidatosListCreator();
    private List<Candidato> candidatos = new ArrayList<>();

    // LISTAGEM CANDIDATOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        if (session.isNew()) {
            out.println(candidatosListCreator.getTableHtml(candidatos));
        }
        else {
            candidatos = (List<Candidato>) session.getAttribute("candidatos");
            out.println(candidatosListCreator.getTableHtml(candidatos));
        }
    }

    // SALVAR CANDIDATO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String numero = request.getParameter("numero");

        System.out.println("doPost: new candidato");

        if (Objects.isNull(id)){
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
