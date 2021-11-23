package com.example.core.Votos.Controller;

import com.example.core.Votos.Model.Voto;
import com.example.core.Votos.Repository.VotoRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( value = "/votos")
public class VotosServlet extends HttpServlet {

    private List<Voto> votos = new ArrayList<>();
    private VotoRepository votoRepository = new VotoRepository();

//  PAGE VOTOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: votos");
        this.votos = votoRepository.findAll();

        request.setAttribute("votos", this.votos);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("votos.jsp");
        requestDispatcher.forward(request,response);
    }
}
