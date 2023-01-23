<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agenda de Contatos</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body id="tabela">
    <main>
        <div class="box">
            <h1>Agenda de Contatos</h1>
            <a href="novo.html" class="botao2">Novo Contato</a>
            <table>
            	<tr>
            		<th>ID</th>
            		<th>Nome</th>
            		<th>Telefone</th>
            		<th>Email</th>
            	</tr>
            	<%for(int i = 0; i < lista.size(); i++) { %>
	            	<tr>
	            		<td><%=lista.get(i).getIdicon()%></td>
	            		<td><%=lista.get(i).getNome()%></td>
	            		<td><%=lista.get(i).getTelefone()%></td>
	           			<td><%=lista.get(i).getEmail()%></td>
	           			<td><a href="Editar?idicon=<%=lista.get(i).getIdicon() %>" class="botao3">Editar</a></td> 		
	            	</tr>
            	<%} %>
            </table>
        </div>
    </main>
</body>
</html>