package com.example.core.Canditatos.Controller;

import com.example.core.Canditatos.Repository.CandidatoRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet( value = "/candidato-remove")
public class CandidatoRemoveServlet extends HttpServlet {

    CandidatoRepository candidatoRepository = new CandidatoRepository();

    // DELETE CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));
        System.out.println("Delete: "+ id);

        if (Objects.isNull(id)) response.sendRedirect("/candidatos");

        candidatoRepository.remove(id);

        response.sendRedirect(request.getContextPath() + "/candidatos");
    }
}
