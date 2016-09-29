<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%

String nova= String.valueOf((request.getAttribute("mensagem") == null ? "" : request.getAttribute("mensagem")));
String texto = nova;
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar a observação </title>
</head>

<body>


<textarea rows="" cols="" name="mens">
<%=texto %>
</textarea>



<table>
<td>

<form action="mensagem.jsp" method="post">
<input type="submit" value="Voltar">
</form>
</td>

<td>
<form action="index.jsp">
<input type="submit" value="Voltar a Pagina Inicial">
</form>

</td>

</table>

</body>
</html>