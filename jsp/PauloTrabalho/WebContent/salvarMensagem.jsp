<%@page import="vinicius.web.bean.Notas"%>
<%@page import="vinicius.web.interfaces.NotasI"%>
<%

String nome = request.getParameter("nome1");
String texto = request.getParameter("mensagem");

NotasI a = new Notas();
session.setAttribute("mensagem", a.gravar(texto));
pageContext.forward("mostrarMensagem.jsp");

%>