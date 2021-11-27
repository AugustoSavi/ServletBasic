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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@WebServlet( value = "/voto")
public class VotoServlet extends HttpServlet {

    private List<Candidato> candidatos = new ArrayList<>();
    private CandidatoRepository candidatoRepository = new CandidatoRepository();
    private VotoRepository votoRepository = new VotoRepository();

//  PAGE VOTACAO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: voto");
        this.candidatos = candidatoRepository.findAll();
        if(candidatos.isEmpty()){
            response.sendRedirect("candidatos/sem-candidatos.html");
        }
        else {
            request.setAttribute("candidatos", this.candidatos);
            request.setAttribute("voto", new Voto());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("voto.jsp");
            requestDispatcher.forward(request, response);
        }
    }

//  SALVAR VOTO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String candidatoID = request.getParameter("candidato");
        if (candidatoID.isEmpty()) response.sendRedirect("candidatos");
        try {
            Candidato _candidato = candidatoRepository.findOne(candidatoID).orElse(null);
            if (Objects.isNull(_candidato)) response.sendRedirect("candidatos");
            if (Objects.isNull(id) || id.isEmpty()) {
                System.out.println("doPost: new Voto");
                Voto voto = new Voto(UUID.randomUUID().toString(), _candidato);
                votoRepository.save(voto);
            }else{
                System.out.println("doPost: update: "+ id);
                Voto voto = votoRepository.findOne(id).orElse(new Voto());
                voto.setCandidato(_candidato);
                votoRepository.save(voto);
            }
        }catch (Exception e){
            response.sendRedirect("voto-error.html");
        }
        response.sendRedirect("voto-success.html");
    }
}
