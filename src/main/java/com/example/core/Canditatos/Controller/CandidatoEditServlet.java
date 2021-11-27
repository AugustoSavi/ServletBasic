package com.example.core.Canditatos.Controller;

import com.example.core.Canditatos.Model.Candidato;
import com.example.core.Canditatos.Repository.CandidatoRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( value = "/candidato-edit")
public class CandidatoEditServlet extends HttpServlet {

    private CandidatoRepository candidatoRepository = new CandidatoRepository();

    // EDIT CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));

        Candidato candidato = candidatoRepository.findOne(id).orElse(new Candidato());

        request.setAttribute("candidato", candidato);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidatos/candidato.jsp");
        requestDispatcher.forward(request,response);
    }
}
