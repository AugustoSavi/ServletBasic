package com.example.core.Canditatos.Controller;

import com.example.core.Canditatos.Model.Candidato;
import com.example.core.Canditatos.Repository.CandidatoRepository;
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


@WebServlet(value = "/candidatos")
public class CandidatosServlet extends HttpServlet {
    private List<Candidato> candidatos = new ArrayList<>();

    private CandidatoRepository candidatoRepository = new CandidatoRepository();

    // LISTAGEM CANDIDATOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.candidatos = candidatoRepository.findAll();

        request.setAttribute("candidatos", this.candidatos);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("candidatos.jsp");
        requestDispatcher.forward(request,response);
    }

    // SALVAR CANDIDATO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String numero = request.getParameter("numero");

        if (validaDuplicado(nome,numero)){
            response.sendRedirect("candidato-duplicado.html");
        }else {
            if (Objects.isNull(id) || id.length() == 0) {
                System.out.println("doPost: new candidato");
                Candidato candidato = new Candidato(UUID.randomUUID().toString(), nome, Integer.valueOf(numero));
                candidatoRepository.save(candidato);
            } else {
                System.out.println("doPost: update: " + id);
                Candidato candidato = candidatoRepository.findOne(id).orElse(new Candidato());
                candidato.setNome(nome);
                candidato.setNumeroCandidato(Integer.valueOf(numero));
                candidatoRepository.save(candidato);
            }
            response.sendRedirect(request.getRequestURI());
        }
    }

    private boolean validaDuplicado(String nome, String numero){
        for (Candidato candidato: this.candidatos){
            if (candidato.getNome().equals(nome) && candidato.getNumeroCandidato().equals(Integer.valueOf(numero))){
                return true;
            }
        }
        return false;
    }
}
