<%@page import="java.util.Date"%>
<%@page import="vinicius.web.interfaces.DataI"%>
<%@page import="vinicius.web.bean.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trabalho de Java Web</title>
</head>


<body background="pictures/sky.jpg">
<center>
<h4>

<font color="white">Data de hoje: <% 

Date b = new Date();
DataI a = new Data();
out.println(a.mostrarData(b));

%>
</font>
</h4>

<h4>

<font color="white">Escolha umas das Paginas abaixo:
</font> 
 
</h4>
<br/>

<form action=" informarDados.jsp " method="post">
<input type="submit" name=" informar" value="Calcular Idade">
</form>
<br/>


<form action="aluno.jsp" method="post">
<input type ="submit" name="aluno" value="Fazer matriculas " >
</form>
<br/>
<form action="mediaNota.jsp" method="post">
<input type = "submit" name = "notas" value = "Calcular media da nota">
</form>
<br/>

<form action="tabelaTemperatura.jsp" method = "post">
<input type = "submit" name="conversor" value = "Converter Temperatura">
</form>
<br/>



</center>
</body>

</html>