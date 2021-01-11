<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes Cadastrados</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">XPTO</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="../../index.jsp">Home </a></li>
			</ul>
		</div>
	</nav>


	<%@page
		import="com.license.teste.dao.MovimentacaoDao, com.license.teste.model.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
	<a href="listar.jsp">Lista de Clientes</a>
	<br>
	<hr>
	<%
			int id = Integer.parseInt(request.getParameter("id"));
			List<Relatorio> list = MovimentacaoDao.getMovimentacoes(id);
			request.setAttribute("list", list);
			request.setAttribute("id", id);
			String end = MovimentacaoDao.getEnderecoCliente(id);
			String nome = MovimentacaoDao.getCliente(id);
			request.setAttribute("end", end);
			request.setAttribute("nome", nome);
		%>
		<h1>Relatório de Saldo do cliente: ${nome}, Id: ${id} </h1>
		<br>
		<hr>
		Nome: ${nome} <br>
		Endereço: ${end}
		<hr>
		<p> Movimentações:</p>
		<table border="1" width="90%">
			<tr>
				<th>Crédito</th>
				<th>Débito</th>
				<th>Total</th>
				<th>Valor movimentações</th>
				<th>Saldo atual</th>
				<th>Quantidade de contas</th>
			</tr>
			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.getCredito()}</td>
					<td>${u.getDebito()}</td>
					<td>${u.getDebito() + u.getCredito()}</td>
					<td>${u.getValor()}</td>
					<td>${u.getSaldoatual()}</td>
					<td>${u.getQuantidadeContas()}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
	</div>
</body>
</html>