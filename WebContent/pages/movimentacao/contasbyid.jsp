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
		import="com.license.teste.dao.ClienteDao, com.license.teste.model.*,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="container">
	<%
			int id = Integer.parseInt(request.getParameter("id"));
			List<Contas> list = ClienteDao.getContas(id);
			request.setAttribute("list", list);
			request.setAttribute("id", id);
		%>
		<h1>Cliente Id: ${id} </h1>
		<br>
		<hr>
		<a href="listar.jsp">Lista de Clientes</a>
		<hr>
		<p>Contas:</p>
		<table border="1" width="90%">
			<tr>
				<th>Id</th>
				<th>Numero</th>
				<th>Saldo</th>
			</tr>
			<c:forEach items="${list}" var="u">
				<tr>
					<td>${u.getId()}</td>
					<td>${u.getNumero()}</td>
					<td>${u.getSaldo()}</td>
				</tr>
			</c:forEach>
		</table>
		<br />
	</div>
</body>
</html>
