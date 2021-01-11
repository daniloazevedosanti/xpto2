<%@page import="com.license.teste.dao.ContasDao" %>

<jsp:useBean id="u" class="com.license.teste.model.Contas"></jsp:useBean>
<jsp:setProperty property="*" name="u" />

<%
	int i = -1; boolean ok = false;
	
	if (u.getNumero() != 0 && u !=null){
		i = ContasDao.save(u);
		ok = true;
		}
	
	if (i > 0) {
		response.sendRedirect("add-success.jsp");
	} else if(ok && i < 0) {
		response.sendRedirect("add-error.jsp");
	}
	else {
		response.sendRedirect("add-current.jsp");
	}
%>
