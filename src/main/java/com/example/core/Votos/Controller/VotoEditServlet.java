package com.example.core.Votos.Controller;

import com.example.core.Canditatos.Model.Candidato;
import com.example.core.Votos.Model.Voto;
import com.example.core.Canditatos.Repository.CandidatoRepository;
import com.example.core.Votos.Repository.VotoRepository;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( value = "/voto-edit")
public class VotoEditServlet extends HttpServlet {

    private VotoRepository votoRepository = new VotoRepository();
    private CandidatoRepository candidatoRepository = new CandidatoRepository();

    // EDIT VOTO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));

        List<Candidato> candidatos = candidatoRepository.findAll();
        Voto voto = votoRepository.findOne(id).orElse(new Voto());

        request.setAttribute("candidatos", candidatos);
        request.setAttribute("voto", voto);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("voto.jsp");
        requestDispatcher.forward(request,response);
    }
}
