package com.example.core.Servlet;

import com.example.core.Model.Candidato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;


@WebServlet(name = "CandidatoServlet", value = "/candidato")
public class CandidatoServlet extends HttpServlet {

    private List<Candidato> candidatos = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (Objects.nonNull(session.getAttribute("candidatos"))){
            candidatos.addAll((List<Candidato>)session.getAttribute("candidatos"));
        }
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String numero = request.getParameter("numero");
        if (Objects.isNull(id)){
            id = UUID.randomUUID().toString();
            Candidato candidato = new Candidato(id,nome,Integer.valueOf(numero));
            candidatos.add(candidato);
            session.setAttribute("candidatos",candidatos);
        }
        else {
            for(Candidato candidato : candidatos){
                if (candidato.getId().equals(id)){
                    candidato.setNome(nome);
                    candidato.setNumeroCandidato(Integer.valueOf(numero));
                }
            }
        }
        response.sendRedirect("candidato.html");
    }
}
