<%@page import="vinicius.web.bean.Conversor"%>
<%@page import="vinicius.web.interfaces.ConversorI"%>
<%    


String valor2 = request.getParameter("conversor");
String val1  = request.getParameter("valor");

ConversorI a = new Conversor();

request.setAttribute("mensagem", a.escolherCalculo(valor2, val1));
pageContext.forward("tabelaTemperatura.jsp");
//out.print("valor" + a.escolherCalculo(valor2, val1));
%>