<%@ page import="com.example.core.Votos.Model.Voto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Candidatos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/311492eabd.js" crossorigin="anonymous"></script>
</head>

<body class="container text-align">
<div id="button-cadastrar">
    <a href="index.html" class="btn btn-primary btn-block mt-5">Home</a>
</div>

<div id="table-dados" class="mt-3">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id voto</th>
            <th scope="col">Nome Candidato</th>
            <th scope="col">Numero Candidato</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>

        <% List<Voto> votos = (List<Voto>) request.getAttribute("votos");
            for (Voto voto : votos) {%>
        <tr>
            <td><%= voto.getId()%>
            </td>
            <td><%= voto.getCandidato().getNome()%>
            </td>
            <td><%= voto.getCandidato().getNumeroCandidato()%>
            </td>
            <td><a href=voto-edit?id=<%=voto.getId()%> class="fas fa-pencil-alt"></a></td>
            <td><a href=voto-remove?id=<%=voto.getId()%> class="fas fa-trash-alt"></a></td>
        </tr>
        <% } %>
        </tbody>
        <tfoot>
        <tr>
            <td>Total registros:${votos.size()}</td>
        </tr>
        </tfoot>
    </table>
</div>
</body>

</html>
