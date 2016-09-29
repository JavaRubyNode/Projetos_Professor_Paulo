package br.com.faculdade.model;

import java.io.Serializable;

/**
 * Created by root on 30/05/16.
 */
public class BensModelVinicius implements Serializable{

    private Long id;
    private String descricao;
    private String especificacao;
    private String departamento;
    private double valor;

    public BensModelVinicius(String descricao, String especificacao, String departamento, double valor) {
        this.descricao = descricao;
        this.especificacao = especificacao;
        this.departamento = departamento;
        this.valor = valor;
    }

    public BensModelVinicius() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BensModelVinicius)) return false;

        BensModelVinicius that = (BensModelVinicius) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
