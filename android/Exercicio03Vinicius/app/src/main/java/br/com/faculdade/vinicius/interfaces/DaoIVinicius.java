package br.com.faculdade.vinicius.interfaces;

import java.util.List;

/**
 * Created by root on 17/05/16.
 */
public interface DaoIVinicius<T> {

    public void salvar(T t);
    public void excluir(T t);
    public void alterar(T t);
    public List<T> listar();

}
