package com.example.core.Votos.Controller;

import com.example.core.Canditatos.Model.Candidato;
import com.example.core.Utils.Utils;
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
import java.util.Objects;

@WebServlet( value = "/voto")
public class VotoServlet extends HttpServlet {

    private CandidatoRepository candidatoRepository = new CandidatoRepository();
    private VotoRepository votoRepository = new VotoRepository();
    private Utils utils = new Utils();

//  PAGE VOTACAO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Candidato> candidatos = candidatoRepository.findAll();

        System.out.println("doGet: voto");

        if(candidatos.isEmpty()){
            response.sendRedirect("candidatos/sem-candidatos.html");
        }
        else {
            request.setAttribute("candidatos", candidatos);
            request.setAttribute("voto", new Voto());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("votos/voto.jsp");
            requestDispatcher.forward(request, response);
        }
    }

//  SALVAR VOTO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = utils.getId(request.getParameter("id"));
        Long candidatoID = utils.getId(request.getParameter("candidato"));
        if (utils.isZero(candidatoID)) response.sendRedirect("candidatos");
        try {
            Candidato _candidato = candidatoRepository.findOne(candidatoID).orElse(null);
            if (Objects.isNull(_candidato)) response.sendRedirect("candidatos");
            if (utils.isZero(id)) {
                System.out.println("doPost: new Voto");
                Voto voto = new Voto(_candidato);
                votoRepository.save(voto);
            }else{
                System.out.println("doPost: update: "+ id);
                Voto voto = votoRepository.findOne(id).orElse(new Voto());
                voto.setCandidato(_candidato);
                votoRepository.save(voto);
            }
        }catch (Exception e){
            response.sendRedirect("votos/voto-error.html");
        }
        response.sendRedirect("votos/voto-success.html");
    }
}
