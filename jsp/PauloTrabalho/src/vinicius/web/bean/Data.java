package vinicius.web.bean;


import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;

import vinicius.web.interfaces.DataI;

public class Data implements DataI {

	@Override
	public Object mostrarData(Date data) {
		Date a = new Date();

		Locale local = new Locale("pt","BR");
		SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy , E",local);
		
		return form.format(a);
	}

	
	

	
	}
