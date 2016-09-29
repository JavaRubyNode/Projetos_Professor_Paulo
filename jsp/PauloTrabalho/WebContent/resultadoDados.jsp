<%@page import="java.util.Date"%>
<%@page import="vinicius.web.interfaces.DataI"%>
<%@page import="vinicius.web.bean.Data"%>
<%@page import="vinicius.web.interfaces.PessoaI"%>
<%@page import="vinicius.web.bean.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<%String nome = request.getParameter("nome");%>

</head>
<font color="white">
<h4> Data de hoje: <% 

Date b = new Date();
DataI a = new Data();
out.println(a.mostrarData(b));

%>
</h4></font> 

<center>
<br/>

<body background="pictures/wood.jpg">
<h3><font color="yellow"><% out.print(nome);%></font> você tem <font color="yellow">
<% String idade = (String)session.getAttribute("idade");
String Mes = request.getParameter("mes");
String Ano = request.getParameter("ano");
PessoaI persona = new Pessoa();

out.print(persona.calcularIdade(Mes, Ano)); %></font> Anos.</h3>

<table>

<td>
<form action="informarDados.jsp" method="post">
<input type="submit" name="voltar" value="Voltar">
</form>
</td>

<td>
<form action="index.jsp" method="post">
<input type="button"  value=" Ir para Página inicial" >

</form>
</td>

</table>
</center>
</body>
</html>