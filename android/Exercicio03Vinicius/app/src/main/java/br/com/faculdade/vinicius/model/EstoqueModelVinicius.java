package br.com.faculdade.vinicius.model;

import java.io.Serializable;

/**
 * Created by root on 17/05/16.
 */
public class EstoqueModelVinicius implements Serializable {

    private Long id;
    private String produto;
    private String fornecedor;
    private double valor;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto() {
        return this.produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getFornecedor() {
        return this.fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public EstoqueModelVinicius() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EstoqueModelVinicius)) return false;

        EstoqueModelVinicius that = (EstoqueModelVinicius) o;

        return this.id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public EstoqueModelVinicius(String produto, String fornecedor, double valor) {

        this.produto = produto;
        this.fornecedor = fornecedor;
        this.valor = valor;
    }
}
