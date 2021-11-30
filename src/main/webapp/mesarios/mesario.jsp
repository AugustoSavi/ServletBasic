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
                    <form action="mesarios" method="POST">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" value="${mesario.getId()}" id="floatingid"
                                   readonly name="id" placeholder="id">
                            <label for="floatingid">id</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control"
                                   value="${mesario.getNome()}"
                                   id="floatingmesario" name="nome"
                                   placeholder="Nome mesario" minlength="3" required maxlength="255">
                            <label for="floatingmesario">Nome mesario</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingCpf"
                                   value="${mesario.getCpf()}" name="cpf"
                                   placeholder="Cpf" minlength="3" required maxlength="255">
                            <label for="floatingCpf">Cpf mesario</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="floatingNumeroTelefone"
                                   value="${mesario.getNumeroTelefone()}" name="numeroTelefone"
                                   placeholder="Numero Telefone" minlength="3" required maxlength="255">
                            <label for="floatingNumeroTelefone">Numero Telefone mesario</label>
                        </div>
                        <div class="d-grid">
                            <button class="btn btn-primary btn-login text-uppercase fw-bold"
                                    type="submit">Salvar
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>