package com.example.core.Canditatos.Controller;

import com.example.core.Canditatos.Model.Candidato;
import com.example.core.Canditatos.Repository.CandidatoRepository;
import com.example.core.Utils.Utils;

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


@WebServlet(value = "/candidatos")
public class CandidatosServlet extends HttpServlet {

    private List<Candidato> candidatos = new ArrayList<>();
    private CandidatoRepository candidatoRepository = new CandidatoRepository();
    private Utils utils = new Utils();

    // LISTAGEM CANDIDATOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.candidatos = candidatoRepository.findAll();

        request.setAttribute("candidatos", this.candidatos);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidatos/candidatos.jsp");
        requestDispatcher.forward(request,response);
    }

    // SALVAR CANDIDATO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = utils.getId(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String numero = request.getParameter("numero");

        if (validaDuplicado(id, nome, numero)){
            response.sendRedirect("candidatos/candidato-duplicado.html");
        }else {
            if (utils.isZero(id)) {
                System.out.println("doPost: new candidato");
                Candidato candidato = new Candidato(nome, Integer.valueOf(numero));
                candidatoRepository.save(candidato);
            } else {
                System.out.println("doPost: candidato update: " + id);
                Candidato candidato = candidatoRepository.findOne(id).orElse(new Candidato());
                candidato.setNome(nome);
                candidato.setNumeroCandidato(Integer.valueOf(numero));
                candidatoRepository.save(candidato);
            }
            response.sendRedirect(request.getRequestURI());
        }
    }

    private boolean validaDuplicado(Long id, String nome, String numero){
        for (Candidato candidato: this.candidatos){
            if (candidato.getNome().equals(nome) && candidato.getNumeroCandidato().equals(Integer.valueOf(numero)) && !candidato.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
