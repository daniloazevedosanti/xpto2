<%@page import="com.license.teste.dao.CadastroDao"%>

<jsp:useBean id="u" class="com.license.teste.model.Cadastro"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%
	int i = -1;
	boolean ok = false;

	if (u.getDocumento() != null && u != null) {
		i =  CadastroDao.save(u);
		ok = true;
	}

	if (i > 0) {
		response.sendRedirect("add-success.jsp");
	} else if (ok && i < 0) {
		response.sendRedirect("add-error.jsp");
	} else {
		response.sendRedirect("add-current.jsp");
	}
%>
