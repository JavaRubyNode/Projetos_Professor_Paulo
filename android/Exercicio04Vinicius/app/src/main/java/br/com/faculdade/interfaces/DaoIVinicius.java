package br.com.faculdade.interfaces;

import java.util.List;

import br.com.faculdade.model.BibliotecaModelVinicius;

/**
 * Created by root on 18/05/16.
 */
public interface DaoIVinicius<T> {

    public void salvar(T t);
    public void excluir(T t);
    public void alterar(T t);
    public List<BibliotecaModelVinicius> listar();
}
