package com.example.core.Servlet;

import com.example.core.Model.Candidato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@WebServlet(name = "CandidatoDeleteServlet", value = "/candidato-delete/*")
public class CandidatoDeleteServlet extends HttpServlet {

    private List<Candidato> candidatos = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[] params =request.getParameterValues("id");
        System.out.println("id: " + params[0]);
        if (Objects.nonNull(session.getAttribute("candidatos"))){
            candidatos.addAll((List<Candidato>)session.getAttribute("candidatos"));
        }
        if (!candidatos.isEmpty()) {
            session.setAttribute("candidatos", candidatos.stream().filter(candidato -> !candidato.getId().equals(params[0])));
        }
        response.sendRedirect("../candidato.html");
    }
}
