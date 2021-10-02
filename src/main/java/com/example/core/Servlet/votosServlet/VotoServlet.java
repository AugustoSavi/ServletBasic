package com.example.core.Servlet.votosServlet;

import com.example.core.Model.Candidato;
import com.example.core.Model.Voto;
import com.example.core.View.VotoHTMLCreator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@WebServlet( value = "/voto")
public class VotoServlet extends HttpServlet {

    private List<Voto> votos = new ArrayList<>();
    private List<Candidato> candidatos = new ArrayList<>();
    private VotoHTMLCreator votoHTMLCreator = new VotoHTMLCreator();

//  PAGE VOTACAO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: voto");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        List<Candidato> candidatosSession = (List<Candidato>) session.getAttribute("candidatos");
        this.candidatos = Objects.isNull(candidatosSession) ? this.candidatos : candidatosSession;
        out.println(votoHTMLCreator.getPageHtml(new Voto(),candidatos));
    }

//  SALVAR VOTO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost: new voto");

        HttpSession session=request.getSession();
        String candidatoID = request.getParameter("candidato");
        Candidato _candidato = candidatos.stream().filter(can -> can.getId().equals(candidatoID)).findFirst().orElse(null);

        if (Objects.isNull(_candidato)) response.sendRedirect("candidatos");

        Voto voto = new Voto(UUID.randomUUID().toString(), _candidato);
        votos.add(voto);
        session.setAttribute("votos", votos);

        response.sendRedirect(request.getRequestURI());
    }
}
