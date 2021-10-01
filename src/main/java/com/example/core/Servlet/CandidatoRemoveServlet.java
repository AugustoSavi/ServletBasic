package com.example.core.Servlet;

import com.example.core.Model.Candidato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet( value = "/candidato-remove")
public class CandidatoRemoveServlet extends HttpServlet {

    private List<Candidato> candidatos = new ArrayList<>();

    // DELETE CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));
        HttpSession session=request.getSession();

        if (Objects.nonNull(session.getAttribute("candidatos"))){
            candidatos = (List<Candidato>)session.getAttribute("candidatos");
        }

        System.out.println("Delete: "+ id);

        if (Objects.isNull(id)) response.sendRedirect("/candidatos");

        candidatos = candidatos.stream().filter(candidato -> !candidato.getId().equals(id)).collect(Collectors.toList());

        session.setAttribute("candidatos",candidatos);
        response.sendRedirect(request.getContextPath() + "/candidatos");
    }
}
