<%@ page import="java.util.List" %>
<%@ page import="com.example.core.Mesarios.Model.Mesario" %>
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
    <a href="mesario-edit" class="btn btn-primary btn-block mt-5">Cadastrar mesario</a>
    <a href="index.html" class="btn btn-primary btn-block mt-5 mx-3">Home</a>
</div>

<div id="table-dados" class="mt-3">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Nome</th>
            <th scope="col">Cpf</th>
            <th scope="col">Numero telefone</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>

        <% List<Mesario> mesarios = (List<Mesario>) request.getAttribute("mesarios");
            for (Mesario mesario : mesarios) { %>
                <tr>
                    <td>  <%= mesario.getId() %></td>
                    <td>  <%= mesario.getNome() %></td>
                    <td>  <%= mesario.getCpf() %> </td>
                    <td>  <%= mesario.getNumeroTelefone() %> </td>
                    <td><a href=mesario-edit?id=<%=mesario.getId()%> class="fas fa-pencil-alt"></a></td>
                    <td><a href=mesario-remove?id=<%=mesario.getId()%> class="fas fa-trash-alt"></a></td>
                </tr>
        <% } %>

        </tbody>
        <tfoot>
        <tr>
            <td>Total registros:${ mesarios.size() }</td>
        </tr>
        </tfoot>
    </table>
</div>
</body>

</html>
