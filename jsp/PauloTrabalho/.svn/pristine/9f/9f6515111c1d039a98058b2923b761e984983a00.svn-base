<%@page import="vinicius.web.bean.Aluno"%>
<%@page import="vinicius.web.interfaces.AlunoI"%>
<%

String valor1 = request.getParameter("nota1");
String valor2 = request.getParameter("nota2");

AlunoI a = new Aluno();

request.setAttribute("mostrarMedia", a.mostrarResultado(valor1, valor2));
pageContext.forward("mediaNota.jsp");


%>