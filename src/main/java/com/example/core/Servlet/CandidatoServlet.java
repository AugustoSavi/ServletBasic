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
import java.util.*;
import java.util.stream.Collectors;


@WebServlet(name = "CandidatoServlet", value = "/candidato")
public class CandidatoServlet extends HttpServlet {

    private List<Candidato> candidatos = new ArrayList<>();

    private CandidatosListCreator candidatosListCreator = new CandidatosListCreator();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        PrintWriter out = response.getWriter();
        out.println(candidatosListCreator.getTableHtml(candidatos));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if (Objects.nonNull(session.getAttribute("candidatos"))){
            candidatos.addAll((List<Candidato>)session.getAttribute("candidatos"));
        }
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String numero = request.getParameter("numero");

        System.out.println("doPost: "+ id);

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
        PrintWriter out = response.getWriter();
        out.println(candidatosListCreator.getTableHtml(candidatos));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");

        System.out.println("doDelete: "+ id);

        candidatos = candidatos.stream().filter(candidato -> !candidato.getId().equals(id)).collect(Collectors.toList());

        out.println(candidatosListCreator.getTableHtml(candidatos));
    }
}
