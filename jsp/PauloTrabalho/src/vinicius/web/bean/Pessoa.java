package vinicius.web.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import vinicius.web.interfaces.PessoaI;

public class Pessoa implements PessoaI,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private Date data;
	private String anoNascimento;
	
	
	//_______________________________________________________________
	
	public Pessoa() {
		super();
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public Pessoa(String nome, Date data, String anoNascimento) {
		super();
		this.nome = nome;
		this.data = data;
		this.anoNascimento = anoNascimento;
	}//_______________________________________________________________

	//_______________________________________________________________
	
	public String getAnoNascimento() {
		return anoNascimento;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public void setAnoNascimento(String anoNascimento) {
		this.anoNascimento = anoNascimento;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public String getNome() {
		return nome;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public void setNome(String nome) {
		this.nome = nome;
	}//_______________________________________________________________
	
	
	
	//_______________________________________________________________
	
	public Date getData() {
		return data;
	}//_______________________________________________________________
	
	
	//_______________________________________________________________
	
	public void setData(Date data) {
		this.data = data;
	}//_______________________________________________________________
	
	
	
	//_______________________________________________________________
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((anoNascimento == null) ? 0 : anoNascimento.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}//_______________________________________________________________


    //_______________________________________________________________
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (anoNascimento == null) {
			if (other.anoNascimento != null)
				return false;
		} else if (!anoNascimento.equals(other.anoNascimento))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}//_______________________________________________________________


	//_______________________________________________________________
	@Override
	public String calcularIdade(String mes1,String ano1) {
		
		
		String idade2 = "";
			
		int mes = Integer.parseInt(mes1); 
		int ano = Integer.parseInt(ano1); 
		int idade = 0;

		Calendar calendar = Calendar.getInstance();
		int mesAtual = (calendar.get(Calendar.MONTH))+1;
		int anoAtual = calendar.get(Calendar.YEAR); 
		int diaAtual = calendar.get(Calendar.DAY_OF_MONTH); 
		if (mesAtual < mes){
			idade = (anoAtual - ano) - 1;
		}else{
			idade = (anoAtual - ano);
		}
		if (mesAtual == mes){
			if (diaAtual < mes){
				idade = (anoAtual - ano) - 1;
			}
			if (diaAtual > mes){
				idade = (anoAtual - ano);
			}
		}
		
		idade2 = idade + "";
		
		return idade2;
	}//_______________________________________________________________



	
	
	
	
	
	
}
