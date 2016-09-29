package br.com.faculdade.interfaces;

import java.util.List;

import br.com.faculdade.model.VendasModelVinicius;

/**
 * Created by root on 16/05/16.
 */
public interface DaoIVinicius<T> {

    public void salvar(T t);
    public void excluir(T t);
    public void atualizar(T t);
    public List<VendasModelVinicius> listar();
}
