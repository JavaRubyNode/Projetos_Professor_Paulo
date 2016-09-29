package vinicius.web.bean;

import vinicius.web.interfaces.NotasI;

public class Notas implements NotasI{

	@Override
	public String gravar(String mensagem) {
	String texto = "A sua observação foi:"+mensagem;
		return texto;
	}

}
