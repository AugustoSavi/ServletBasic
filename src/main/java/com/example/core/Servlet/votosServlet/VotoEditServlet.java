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
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@WebServlet( value = "/voto-edit")
public class VotoEditServlet extends HttpServlet {

    private VotoHTMLCreator votoHTMLCreator = new VotoHTMLCreator();
    private static Pattern pattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    // EDIT VOTO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String id = String.valueOf(request.getParameter("id"));
        Voto voto = new Voto();

        List<Candidato> candidatos = (List<Candidato>)session.getAttribute("candidatos");
        List<Voto> votosSession = (List<Voto>) session.getAttribute("votos");

        if(pattern.matcher(id).matches() && Objects.nonNull(votosSession)) {
            voto = votosSession.stream().filter(vot -> vot.getId().equals(id)).findFirst().orElse(null);
        }
        out.println(votoHTMLCreator.getPageHtml(voto,candidatos));
    }
}
