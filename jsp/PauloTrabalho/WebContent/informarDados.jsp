<%@page import="java.util.Date"%>
<%@page import="vinicius.web.interfaces.DataI"%>
<%@page import="vinicius.web.bean.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<center>
<font color="white"><h4> Data de hoje: <% 

Date b = new Date();
DataI a = new Data();
out.println(a.mostrarData(b));

%> </h4></font>
<body background="pictures/tribal.jpg">

<form action="resultadoDados.jsp" method="post" >
<font color="white">Nome: </font><input type="text" name="nome"><br />
<br />
<font color="white">Data de Nascimento:</font><br /><br />


<font color="white">Dia: </font><input type="text" name="dia" maxlength="2" size="2"> 
<font color="white">Mes: </font><input type="text" name="mes" maxlength="2" size="2"> 
<font color="white">Ano: </font><input type="text" name="ano" maxlength="4" size="4"><br /><br />
<br />

<table>

<td>
<input type="submit" name="enviar" value="Enviar">
</td>
</form>
<td>

<form action="index.jsp" method="post">
<input type="submit" name=" voltar" value ="Voltar para a Pagina prinicpal">
</form>
</td>

<br/>

</table>
</body>
</center>
</html>