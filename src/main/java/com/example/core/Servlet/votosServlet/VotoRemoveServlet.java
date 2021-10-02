package com.example.core.Servlet.votosServlet;

import com.example.core.Model.Voto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet(value = "/voto-remove")
public class VotoRemoveServlet extends HttpServlet {

    private List<Voto> votos = new ArrayList<>();

    // DELETE CANDIDATO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = String.valueOf(request.getParameter("id"));
        HttpSession session=request.getSession();

        if (Objects.nonNull(session.getAttribute("votos"))){
            votos = (List<Voto>)session.getAttribute("votos");
        }

        System.out.println("Delete: "+ id);

        if (Objects.isNull(id)) response.sendRedirect("/votos");

        votos = votos.stream().filter(voto -> !voto.getId().equals(id)).collect(Collectors.toList());

        session.setAttribute("votos",votos);
        response.sendRedirect(request.getContextPath() + "/votos");
    }
}
