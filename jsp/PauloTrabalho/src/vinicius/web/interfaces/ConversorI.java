package vinicius.web.interfaces;

public interface ConversorI {

	
	public double converterCelsus(String farenheit);
	
	public double converterFarenheit(String celsus);
	
	public double converterKelvin(String celsus);
	
	public double converterCelsus2(String kelvin);
	
	public double converterFarenheit2(String kelvin);
	
	public double converterKelvin2(String farenheit);
	
	public String mostrarCelsus(String farenheit);
	
	public String mostrarFarenheit(String clesus);
	
	public String mostrarKelvin(String celsus);
	
	public String mostarFarenheit2(String kelvin);
	
	public String mostrarCelsus2(String kelvin);
	
	public String mostrarKelvin2(String farenheit);
	
	public String escolherCalculo(String valor, String opc);
	
	
	
	
	
	
	
	
	
}
