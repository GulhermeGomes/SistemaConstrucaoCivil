<%@page import="modelo.Projeto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostra Projetos</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f0f0f0;
    }
    h1 {
        color: #333;
        text-align: center;
        margin-top: 20px;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }
    table, th, td {
        border: 1px solid #999;
        padding: 10px;
    }
    th {
        background-color: #333;
        color: #fff;
    }
    td {
        text-align: center;
    }
    .btn {
        display: block;
        width: 200px;
        height: 25px;
        margin: 20px auto;
        background-color: #3498db;
        text-align: center;
        border-radius: 5px;
        color: white;
        font-weight: bold;
        line-height: 25px;
    }
    .btn:hover {
        background-color: #2980b9;
    }
</style>
</head>
<body>

    <%
    List<Projeto> projetos = (List<Projeto>) request.getAttribute("projetos");
    %>

    <h1>Mostrar Projetos</h1>

    <a class="btn" href="cadastro.html">Cadastrar Projeto</a>

    <table>
        <thead>
            <tr>
                <th>CNPJ</th>
                <th>Nome Empresa</th>
                <th>Nome Projeto</th>
                <th>Quantidade M2</th>
                <th>Valor Projeto</th>
                <th>Status</th>
                <th>Nome Engenheiro</th>
                <th colspan="2">Ação</th>
            </tr>
        </thead>
        <tbody>
            <%
            for (Projeto projeto : projetos) {
            %>
            <tr>
                <td><%=projeto.getCnpj()%></td>
                <td><%=projeto.getNomeEmpresa()%></td>
                <td><%=projeto.getNomeProjeto()%></td>
                <td><%=projeto.getQuantidadeM2()%></td>
                <td><%=projeto.getValorProjeto()%></td>
                <td><%=projeto.getStatusProjeto()%></td>
                <td><%=projeto.getNomeEngenheiro()%></td>
                <td><a href="?acao=contratar&cnpj=<%=projeto.getCnpj()%>">Contratar Engenheiro</a></td>
                <td><a href="?acao=excluir&cnpj=<%=projeto.getCnpj()%>">Excluir</a></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

    <form action="chamadaservlet" method="GET">
        <input type="hidden" name="acao" value="estatistica">
        <input id="showButton" class="btn" type="submit" value="Mostrar Estatísticas">
    </form>
    
    <button id="hideButton" class="btn" style="display: none;">Ocultar Estatísticas</button>
    

	<table id="statisticsTable">
		<%
		if (request.getAttribute("quantidadeProjetos") != null) {
		%>
		<tr>
			<td>Quantidade de Projetos:</td>
			<td><%= request.getAttribute("quantidadeProjetos") %></td>
		</tr>
		<%
		}
		if (request.getAttribute("precoMedio") != null) {
		%>
		<tr>
			<td>Preço Médio:</td>
			<td><%= request.getAttribute("precoMedio") %></td>
		</tr>
		<%
		}
		if (request.getAttribute("quantidadeTotalM2") != null) {
		%>
		<tr>
			<td>Quantidade Total de Metros Quadrados:</td>
			<td><%= request.getAttribute("quantidadeTotalM2") %></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>
<script>
    var showButton = document.getElementById('showButton');
    var hideButton = document.getElementById('hideButton');
    var table = document.getElementById('statisticsTable');

    if (table.innerHTML.trim() !== '') {
        showButton.style.display = 'none';
        hideButton.style.display = 'block';
    }

    hideButton.addEventListener('click', function() {
        table.style.display = 'none';
        hideButton.style.display = 'none';
        showButton.style.display = 'block';
    });
</script>