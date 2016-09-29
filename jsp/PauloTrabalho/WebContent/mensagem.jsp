<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mensagem</title>
</head>

<body>

<center>
<form action="salvarMensagem.jsp" method="post">
Informe seu nome: <input type="text" name="nome1">
<br/>
<br/>
coloque aqui sua observação:
<br/>

<textarea rows="15" cols="40" name="mensagem">
</textarea>
<br/>
<br/>

<input type="submit" value="Salvar">
</form>








</center>
</body>
</html>