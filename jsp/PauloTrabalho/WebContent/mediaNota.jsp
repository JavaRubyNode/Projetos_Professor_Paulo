<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<% 

String nova= String.valueOf((request.getAttribute("mostrarMedia") == null ? "" : request.getAttribute("mostrarMedia")));

%>

<br/>
<br/>

<body>
<center>

Informe a nota 1: <input type="text" name ="nota1">
<br/>
<br/>
Informe a nota 2: <input type="text" name ="nota2">
<br/>
<br/>

<table>
<td>
<form action="resultadoNota.jsp" method="post">
<input type="submit" name="media" value =" Calcualr Media">
</form>
</td>


<td>
<form>
<input type="submit" name ="voltar" value =" Pagina Principal">
</form>
</td>


</table>

<br/>
<br/>

<textarea rows="10" cols="50" name="mostrarMedia" ><%=nova %>

</textarea>

</center>


</body>

</html>