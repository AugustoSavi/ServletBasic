package com.example.core.Servlet.votosServlet;

import com.example.core.Model.Candidato;
import com.example.core.Model.Voto;
import com.example.core.View.VotosViews.VotoHTMLCreator;

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

        if(candidatos.isEmpty()) response.sendRedirect("candidatos");

        out.println(votoHTMLCreator.getPageHtml(new Voto(),candidatos));
    }

//  SALVAR VOTO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String id = request.getParameter("id");
        String candidatoID = request.getParameter("candidato");
        if (candidatoID.isEmpty()) response.sendRedirect("candidatos");

        try {
            if (Objects.nonNull(session.getAttribute("votos"))){
                votos = (List<Voto>)session.getAttribute("votos");
            }

            Candidato _candidato = candidatos.stream().filter(can -> can.getId().equals(candidatoID)).findFirst().orElse(null);
            if (Objects.isNull(_candidato)) response.sendRedirect("candidatos");

            if (Objects.isNull(id) || id.isEmpty()) {
                System.out.println("doPost: new Voto");
                Voto voto = new Voto(UUID.randomUUID().toString(), _candidato);
                votos.add(voto);
            }else{
                System.out.println("doPost: "+ id);
                for(Voto voto : votos){
                    if (voto.getId().equals(id)){
                        voto.setCandidato(_candidato);
                    }
                }
            }
            session.setAttribute("votos", votos);
        }catch (Exception e){
            response.sendRedirect("voto-error.html");
        }
        response.sendRedirect("voto-success.html");
    }
}
