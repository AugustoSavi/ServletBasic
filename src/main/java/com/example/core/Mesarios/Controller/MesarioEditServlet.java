package com.example.core.Mesarios.Controller;

import com.example.core.Mesarios.Model.Mesario;
import com.example.core.Mesarios.Repository.MesarioRepository;
import com.example.core.Utils.Utils;

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
    private Utils utils = new Utils();

    // EDIT CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = utils.getId(request.getParameter("id"));

        Mesario mesario = candidatoRepository.findOne(id).orElse(new Mesario());

        request.setAttribute("mesario", mesario);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("mesarios/mesario.jsp");
        requestDispatcher.forward(request,response);
    }
}
