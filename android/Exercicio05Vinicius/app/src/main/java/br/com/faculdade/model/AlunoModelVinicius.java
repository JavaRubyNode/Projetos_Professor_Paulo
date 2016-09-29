package br.com.faculdade.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by root on 19/05/16.
 */
public class AlunoModelVinicius implements Serializable {

    private Long id;
    private String nome;
    private int idade;
    private Date dataNascimento;
    private String GrauInstrução;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGrauInstrução() {
        return GrauInstrução;
    }

    public void setGrauInstrução(String grauInstrução) {
        GrauInstrução = grauInstrução;
    }

    public AlunoModelVinicius(String nome, int idade, Date dataNascimento, String grauInstrução) {
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        GrauInstrução = grauInstrução;
    }

    public AlunoModelVinicius() {
        super();
    }
}
