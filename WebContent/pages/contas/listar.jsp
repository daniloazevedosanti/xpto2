<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contas Cadastradas</title>
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
		import="com.license.teste.dao.ContasDao, com.license.teste.model.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
		<h1>Contas</h1>
		<br>
		<hr>
		<a href="add.jsp">Adicionar nova conta</a>
		<hr>
		<br>

		<%
			List<Contas> list = ContasDao.getListarTodos();
			request.setAttribute("list", list);
		%>

		<table border="1" width="90%">
			<tr>
				<th>Id</th>
				<th>Número</th>
				<th>Saldo</th>
				<th>Id Cliente</th>
			</tr>
			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.getId()}</td>
					<td>${u.getNumero()}</td>
					<td>${u.getSaldo()}</td>
					<td>${u.getCliente()}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
	</div>
</body>
</html>
