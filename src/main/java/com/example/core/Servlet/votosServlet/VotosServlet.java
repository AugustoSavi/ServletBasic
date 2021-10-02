package com.example.core.Servlet.votosServlet;

import com.example.core.Model.Voto;
import com.example.core.View.VotosViews.VotosHTMLCreator;
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

@WebServlet( value = "/votos")
public class VotosServlet extends HttpServlet {

    private List<Voto> votos = new ArrayList<>();
    private VotosHTMLCreator votosHTMLCreator = new VotosHTMLCreator();

//  PAGE VOTOS
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: votos");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        List<Voto> votosSession = (List<Voto>) session.getAttribute("votos");
        this.votos = Objects.isNull(votosSession) ? this.votos : votosSession;
        out.println(votosHTMLCreator.getTableHtml(votos));
    }
}
