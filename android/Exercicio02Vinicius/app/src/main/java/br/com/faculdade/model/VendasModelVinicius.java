package br.com.faculdade.model;

import java.io.Serializable;

/**
 * Created by root on 16/05/16.
 */
public class VendasModelVinicius implements Serializable {

    private Long id;
    private String cliente;
    private String produto;
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public VendasModelVinicius(String cliente, String produto, double valor) {
        this.cliente = cliente;
        this.produto = produto;
        this.valor = valor;
    }


    public VendasModelVinicius() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VendasModelVinicius that = (VendasModelVinicius) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
