<%@ page import="com.example.core.Canditatos.Model.Candidato" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.core.Votos.Model.Voto" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Novo Candidato</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card border-0 shadow rounded-3 my-5">
                <div class="card-body p-4 p-sm-5">
                    <form action="voto" method="POST">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" value="${voto.getId()}" id="floatingid" readonly
                                   name="id" placeholder="id">
                            <label for="floatingid">id</label>
                        </div>
                        <div class="form-floating mb-3">
                            <select pattern="[^a-zA-Z0-9]" class="form-control" name="candidato"
                                    id="floatingCandidato" required>
                                <option value="">Selecione o candidato</option>
                                <% List<Candidato> candidatos = (List<Candidato>) request.getAttribute("candidatos");
                                    Voto voto = (Voto)request.getAttribute("voto");
                                    for (Candidato candidato : candidatos) { %>
                                <option value=<%=candidato.getId()%> <%= selectedCandidato(voto,candidato) %> >
                                    <%=candidato.getNumeroCandidato()%> - <%=candidato.getNome()%>
                                </option>
                                <% } %>
                            </select>
                            <label for="floatingCandidato">Candidato</label>
                        </div>
                        <div class="d-grid">
                            <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">Votar
                            </button>
                            <a href="index.html" class="btn btn-secondary btn-login text-uppercase fw-bold mt-5"
                               type="submit">Home
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%!
    private String selectedCandidato(Voto voto, Candidato candidato){
        if (Objects.nonNull(voto.getCandidato())) {
            if (voto.getCandidato().getId().equals(candidato.getId())) {
                return "selected";
            }
        }
        return null;
    }
%>