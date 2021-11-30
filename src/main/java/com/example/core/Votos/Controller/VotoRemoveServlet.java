package com.example.core.Votos.Controller;

import com.example.core.Utils.Utils;
import com.example.core.Votos.Repository.VotoRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = "/voto-remove")
public class VotoRemoveServlet extends HttpServlet {

    private VotoRepository votoRepository = new VotoRepository();
    private Utils utils = new Utils();

    // DELETE CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = utils.getId(request.getParameter("id"));
        System.out.println("Delete: "+ id);
        if (utils.isZero(id)) response.sendRedirect("/votos");
        votoRepository.remove(id);
        response.sendRedirect(request.getContextPath() + "/votos");
    }
}
