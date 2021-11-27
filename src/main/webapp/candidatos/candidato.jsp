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
                    <form action="candidatos" method="POST">
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" value="${candidato.getId()}" id="floatingid"
                                   readonly name="id" placeholder="id">
                            <label for="floatingid">id</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control"
                                   value="${candidato.getNome()}"
                                   id="floatingcandidato" name="nome"
                                   placeholder="Nome candidato" minlength="3" required maxlength="255">
                            <label for="floatingcandidato">Nome candidato</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" id="floatingNumero"
                                   value="${candidato.getNumeroCandidato()}" name="numero"
                                   placeholder="Numero" required pattern="[0-9]" min="00001" max="99999">
                            <label for="floatingNumero">Numero candidato</label>
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