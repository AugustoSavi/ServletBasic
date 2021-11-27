package com.example.core.Mesarios.Controller;

import com.example.core.Mesarios.Model.Mesario;
import com.example.core.Mesarios.Repository.MesarioRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( value = "/mesario-edit")
public class MesarioEditServlet extends HttpServlet {

    private MesarioRepository candidatoRepository = new MesarioRepository();

    // EDIT CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));

        Mesario candidato = candidatoRepository.findOne(id).orElse(new Mesario());

        request.setAttribute("mesario", candidato);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("mesarios/mesario.jsp");
        requestDispatcher.forward(request,response);
    }
}
