package com.example.core.Mesarios.Controller;

import com.example.core.Mesarios.Model.Mesario;
import com.example.core.Mesarios.Repository.MesarioRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@WebServlet(value = "/mesarios")
public class MesariosServlet extends HttpServlet {

    private MesarioRepository mesarioRepository = new MesarioRepository();

    // LISTAGEM MESARIOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Mesario> mesarios = mesarioRepository.findAll();

        request.setAttribute("mesarios", mesarios);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("mesarios/mesarios.jsp");
        requestDispatcher.forward(request,response);
    }

    // SALVAR MESARIO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String numeroTelefone = request.getParameter("numeroTelefone");

        if (validaDuplicado(id,cpf)){
            response.sendRedirect("mesarios/mesario-duplicado.html");
        }else {
            if (Objects.isNull(id) || id.length() == 0) {
                System.out.println("doPost: new mesario");
                Mesario candidato = new Mesario(UUID.randomUUID().toString(), nome, cpf, numeroTelefone);
                mesarioRepository.save(candidato);
            } else {
                System.out.println("doPost mesario: update: " + id);
                Mesario candidato = mesarioRepository.findOne(id).orElse(new Mesario());
                candidato.setNome(nome);
                candidato.setCpf(cpf);
                candidato.setNumeroTelefone(numeroTelefone);
                mesarioRepository.save(candidato);
            }
            response.sendRedirect(request.getRequestURI());
        }
    }

    private boolean validaDuplicado(String id, String cpf){
        List<Mesario> mesarios = mesarioRepository.findAll();
        for (Mesario mesario: mesarios){
            if (mesario.getCpf().equals(cpf) && !mesario.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
