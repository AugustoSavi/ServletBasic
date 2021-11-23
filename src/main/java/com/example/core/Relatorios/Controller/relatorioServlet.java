package com.example.core.Relatorios.Controller;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet( value = "/relatorios")
public class relatorioServlet extends HttpServlet {

    private List<Voto> votos = new ArrayList<>();
    private List<Candidato> candidatos = new ArrayList<>();
    private VotoRepository votoRepository = new VotoRepository();
    private CandidatoRepository candidatoRepository = new CandidatoRepository();

    //  PAGE VOTOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: relatorios");

        this.votos = votoRepository.findAll();
        this.candidatos = candidatoRepository.findAll();

        request.setAttribute("candidatos", this.candidatos);
        request.setAttribute("votos", this.votos);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("relatorio.jsp");
        requestDispatcher.forward(request,response);
    }
}
