package vinicius.web.bean;

import java.io.Serializable;

import vinicius.web.interfaces.AlunoI;

public class Aluno extends Pessoa implements AlunoI, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double nota1;
	private double nota2;
	private double media;
	
	
	
	
	
	//_______________________________________________________________
	
	public Aluno() {
		super();
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public Aluno(double nota1, double nota2, double media) {
		super();
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.media = media;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public double getNota1() {
		return nota1;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public double getNota2() {
		return nota2;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public void setNota2(double nota2) {
	
		this.nota2 = nota2;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public double getMedia() {
		
		return media;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public void setMedia(double media) {
		this.media = media;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(media);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(nota1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(nota2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}//_______________________________________________________________
	
	
	
	//_______________________________________________________________
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (Double.doubleToLongBits(media) != Double
				.doubleToLongBits(other.media))
			return false;
		if (Double.doubleToLongBits(nota1) != Double
				.doubleToLongBits(other.nota1))
			return false;
		if (Double.doubleToLongBits(nota2) != Double
				.doubleToLongBits(other.nota2))
			return false;
		return true;
	}//_______________________________________________________________


	@Override
	public double calcularMedia(String nota1, String nota2) {
		
		double n1 = Double.parseDouble(nota1);
		double n2 = Double.parseDouble(nota2);
		double media = (n1+n2)/2;
		
		
		return media;
	}


	@Override
	public String mostrarResultado(String nota1, String nota2) {

		double n1 = Double.parseDouble(nota1);
        double n2 = Double.parseDouble(nota2);
		
 String texto =" Para calcular a media das notas basta fazer, "+
 "\n a media aritimetica, ou seja, pegar a soma das duas notas e dividir "+
		 "\npor 2 ficando assim:"+"\n"+
 "\n Nota1 = "+nota1+
 "\n Nota2 = "+nota2+"\n"+
 "\n Media = n1 + n2 / 2 "+
 "\n Media = "+nota1+" + "+nota2+" / 2"+
 "\n Media = "+(n1+n2)+" / 2"+
 "\n Media = "+calcularMedia(nota1, nota2)+"\n"+
 "\n Com essa media o Resultado final:"+
 resultadoFinal(nota1, nota2);
		
		return texto;
	}


	@Override
	public String resultadoFinal(String nota1, String nota2) {
		
		
		String temp="";
		if(calcularMedia(nota1, nota2)>=7){
			temp="Aprovado parab�ns";
		}else if (calcularMedia(nota1, nota2)<7){
			temp="Reprovado estude mais por favor !!!";
		}
		
				String texto = " Sendo a media 7 da faculdade: "+
		"\n com medias menores que 7 o aluno se encontra Reprovado,"+
				"\n mas se a media for maior ou igual a 7 o aluno,  "+
		"\n estar� Aprovado "+
				"\n Resultado final = "+temp;
		
		return texto;
	}
	
	
	
	
	
}
