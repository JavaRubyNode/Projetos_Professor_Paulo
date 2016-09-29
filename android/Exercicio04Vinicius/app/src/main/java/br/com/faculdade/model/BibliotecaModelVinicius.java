package br.com.faculdade.model;

import java.io.Serializable;

/**
 * Created by root on 18/05/16.
 */
public class BibliotecaModelVinicius implements Serializable {

    private Long id;
    private String nome;
    private String editora;
    private double valor;


    public BibliotecaModelVinicius(Long id, String nome, String editora, double valor) {
        this.id = id;
        this.nome = nome;
        this.editora = editora;
        this.valor = valor;
    }

    public BibliotecaModelVinicius() {
        super();
    }

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

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
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
        if (!(o instanceof BibliotecaModelVinicius)) return false;

        BibliotecaModelVinicius that = (BibliotecaModelVinicius) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
