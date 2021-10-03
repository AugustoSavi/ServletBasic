package com.example.core.Servlet.relatoriosServlet;

import com.example.core.Model.Candidato;
import com.example.core.Model.Voto;
import com.example.core.View.Relatorios.RelatorioViewCreator;

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

@WebServlet( value = "/relatorios")
public class relatorioServlet extends HttpServlet {

    private List<Voto> votos = new ArrayList<>();
    private List<Candidato> candidatos = new ArrayList<>();
    private RelatorioViewCreator relatorioViewCreator = new RelatorioViewCreator();

    //  PAGE VOTOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: relatorios");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        List<Voto> votosSession = (List<Voto>) session.getAttribute("votos");
        this.votos = Objects.isNull(votosSession) ? this.votos : votosSession;

        List<Candidato> candidatosSession = (List<Candidato>) session.getAttribute("candidatos");
        this.candidatos = Objects.isNull(candidatosSession) ? this.candidatos : candidatosSession;

        out.println(relatorioViewCreator.getTableHtml(candidatos,votos));
    }
}
