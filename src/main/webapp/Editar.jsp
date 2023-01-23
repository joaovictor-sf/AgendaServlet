<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda de Contatos</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body id="novo">
    <main>
        <div class="box">
            <h1>Editar contato</h1>
            <form name="frmContato" action="/Update">
            	<input type="text" name="idcon" id="caixa3" readonly="readonly"
            	value="<%out.print(request.getAttribute("idicon"));%>"><br>
                <input type="text" name="nome"
                value="<%out.print(request.getAttribute("nome"));%>"><br>
                <input type="text" name="fone" class="fone"
                value="<%out.print(request.getAttribute("telefone"));%>"><br>
                <input type="text" name="email"
                value="<%out.print(request.getAttribute("email"));%>"><br>
                <input type="button" value="Salvar" onclick="validar()">
            </form>
        </div>
    </main>
    <script src="scripts/validador.js"></script>
</body>
</html>