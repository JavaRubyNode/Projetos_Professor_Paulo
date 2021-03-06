package vinicius.web.bean;

import java.text.DecimalFormat;

import vinicius.web.interfaces.ConversorI;

public class Conversor implements ConversorI{

	// classe para calcular a temperatura

	//_______________________________________________________
	@Override
	public double converterCelsus(String farenheit) {

		
		double valor = 1.8;
		double farenheit1 = Double.parseDouble(farenheit);
		double celsus = valor/(farenheit1-32);
			
		return celsus;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public double converterFarenheit(String celsus) {
		double valor = 1.8;
		double celsus1 = Double.parseDouble(celsus);
		
		double far = ((celsus1*valor)+ 32);
		
		return far;
	}//_______________________________________________________

	@Override
	public double converterKelvin(String celsus) {
		
		double celsus1 = Double.parseDouble(celsus);
		double kelvin1 = celsus1 + 273.15;
		
		return kelvin1;
	}//_______________________________________________________
	
	
	//_______________________________________________________
	@Override
	public double converterCelsus2(String kelvin) {
		double kelvin1 = Double.parseDouble(kelvin);
		double celsus1 = kelvin1 - 273.15;
		return celsus1;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public double converterFarenheit2(String kelvin) {
		
		double cel = converterCelsus2(kelvin);
		double far = converterFarenheit(String.valueOf(cel));
		
		return far;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public double converterKelvin2(String farenheit) {
	
		double cel = converterCelsus(farenheit);
		double kel = converterKelvin(String.valueOf(cel));
		
		return kel;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public String mostrarCelsus(String farenheit) {
		
		DecimalFormat a = new DecimalFormat();
		a.applyPattern("#,###0.00");
		
		double far= Double.parseDouble(farenheit);
		
		String texto = "Convertendo a temperatura Fahrenheit ( �F ), para "+
		"\n Celsus ( �C ), basta usar a seguinte formula:"+
				"\n �C = (�F - 32) / 1,8  \n "+
		"\n �F = "+farenheit+
		"\n Fazendo o calculo:"+
		"\n �C = (�"+farenheit+" - 32) / 1,8 "+
		"\n �C = "+(far-32)+" / 1,8 "+
		"\n �C = "+a.format(((far-32)/1.8));
		
		return texto;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public String mostrarFarenheit(String clesus) {
		
		DecimalFormat a = new DecimalFormat();
		a.applyPattern("#,###0.00");
		
		double cel = Double.parseDouble(clesus);
		
		String texto = "Convertendo a temperatura Celsus ( �C ), para "+
				"\n Fahrenheit ( �F ), basta usar a seguinte formula:"+
						"\n �F = (�C . 1,8) + 32  \n "+
				"\n �C = "+clesus+
				"\n Fazendo o calculo:"+
				"\n �F = (�"+clesus+" . 1,8) + 32 "+
				"\n �F = "+(cel*1.8)+" + 32 "+
				"\n �F = "+a.format(((cel*1.8)+32));
		
		return texto;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public String mostrarKelvin(String celsus) {
		
		DecimalFormat a = new DecimalFormat();
		a.applyPattern("#,###0.00");
		
		double cel = Double.parseDouble(celsus);
		String texto = " Convertendo a temperatura Celsus ( �C ), para"+
		"\n Kelvin ( K ), basta usar a seguinte formula:"+
				"\n K = �C + 273,15 \n"+
		"\n �C = "+celsus+"\n"+
		"\n K = �"+celsus+" + 273,15"+
		"\n K = "+a.format((cel+273.15));
		
		
		return texto;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public String mostarFarenheit2(String kelvin) {
		
		DecimalFormat a = new DecimalFormat();
		a.applyPattern("#,###0.00");
		
		double kelvin1 = Double.parseDouble(kelvin);
		
		String texto ="Convertendo a temperatura Kelvin ( K ), para"+
		"\n Fahrenheit ( �F ), basta usar a seguinte formula:"+
				"\n �F = (1,8 .(K - 273,15 )) + 32"+
		"\n �F = (1,8 .( "+kelvin+" - 273,15 )) + 32 "+
				"\n �F = 1,8 .("+(kelvin1-273.15)+") + 32 "+
		"\n �F = "+(1.8*(kelvin1-273.15))+" + 32"+
				"\n �F = "+a.format(converterFarenheit2(kelvin));
		
		return texto;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public String mostrarCelsus2(String kelvin) {
		
		DecimalFormat a = new DecimalFormat();
		a.applyPattern("#,###0.00");
		
		String texto = "Convertendo a temperatura Kelvin( K ), para"+
		"\n Celsus ( �C ), basta usar seguinte formula: "+
				"\n �C = K - 273,15 "+
		"\n K = "+kelvin+"\n"+
		"\n �C = "+kelvin+" - 273,15"+
		"\n �C = "+a.format((converterCelsus2(kelvin)));
		
		return texto;
	}//_______________________________________________________

	
	//_______________________________________________________
	@Override
	public String mostrarKelvin2(String farenheit) {
		
		DecimalFormat a = new DecimalFormat();
		a.applyPattern("#,###0.00");
		
		double far = Double.parseDouble(farenheit);
		
		String texto ="Convertendo a temperatura Fahrenheit ( �F ), para "+
		"\n Kelvin ( K ), basta usar a seguinte formula:"+
				"\n K = (5/9 .(�F - 32 )) + 273,15 "+
		"\n �F = "+farenheit+"\n"+
				"\n K = (5/9 .( "+farenheit+" - 32 ) ) + 273,15"+
		"\n K = ( 5/9 .( "+(far-32)+" ) ) + 273,15"+
				"\n K = "+((far-32)*5/9)+" + 273,15"+
		"\n K = "+a.format(converterKelvin2(farenheit));
		
		
		
		return texto;
	}//_______________________________________________________


	@Override
	public String escolherCalculo(String valor, String opc) {
	 
		int val = Integer.parseInt(valor);
		
		String texto ="";
		
		if(val==1){
			texto = mostrarCelsus(opc);
		}else if (val==2){
			texto = mostrarFarenheit(opc);
		}else if(val==3){
			texto = mostrarCelsus2(opc);
		}else if (val==4){
			texto = mostrarKelvin(opc);
		}else if (val==5){
			texto = mostarFarenheit2(opc);
		}else if (val==6){
			texto = mostrarKelvin2(opc);
		}
		
		
		return texto;
	}

}
