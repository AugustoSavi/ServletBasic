<%@ page import="com.example.core.Canditatos.Model.Candidato" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.core.Votos.Model.Voto" %>
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
  <h2 class="mx-auto" style="width: 200px;">
    Candidatos
  </h2>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nome</th>
      <th scope="col">Numero Candidato</th>
      <th scope="col">Total de votos recebidos</th>
    </tr>
    </thead>
    <tbody>
    <% List<Candidato> candidatos = (List<Candidato>) request.getAttribute("candidatos");
      List<Voto> votos = (List<Voto>) request.getAttribute("votos");
      for (Candidato candidato : candidatos) { %>
    <tr>
      <td>  <%= candidato.getId() %></td>
      <td>  <%= candidato.getNome() %></td>
      <td>  <%= candidato.getNumeroCandidato() %> </td>
      <td><%= votos.stream().filter(voto -> voto.getCandidato().getId().equals(candidato.getId())).count() %></td>
    </tr>
    <% } %>

    </tbody>
    <tfoot>
    <tr>
      <td>Total registros: ${candidatos.size()} </td>
    </tr>
    </tfoot>
  </table>

  <h2 class="mx-auto" style="width: 200px;">
    Votos
  </h2>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">Id voto</th>
      <th scope="col">Nome Candidato</th>
      <th scope="col">Numero Candidato</th>
    </tr>
    </thead>
    <tbody>

      <%for (Voto voto : votos) {%>
    <tr>
      <td> <%= voto.getId()%></td>
      <td> <%= voto.getCandidato().getNome()%></td>
      <td> <%= voto.getCandidato().getNumeroCandidato()%></td>
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
