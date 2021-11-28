package com.example.core.Mesarios.Controller;

import com.example.core.Mesarios.Repository.MesarioRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet( value = "/mesario-remove")
public class MesarioRemoveServlet extends HttpServlet {

    MesarioRepository mesarioRepository = new MesarioRepository();

    // DELETE MESARIO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));
        System.out.println("Delete: "+ id);

        if (Objects.isNull(id)) response.sendRedirect("/mesarios");

        mesarioRepository.remove(id);

        response.sendRedirect(request.getContextPath() + "/mesarios");
    }
}