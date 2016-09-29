package br.com.faculdade.vinicius.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.faculdade.vinicius.interfaces.DaoIVinicius;
import br.com.faculdade.vinicius.model.EstoqueModelVinicius;

/**
 * Created by root on 17/05/16.
 */
public class EstoqueDaoVinicius implements DaoIVinicius<EstoqueModelVinicius> {

    private static List<EstoqueModelVinicius> listaEstoque = new ArrayList<>();
    private static Long idGerador = 1L;


    @Override
    public void salvar(EstoqueModelVinicius estoqueModelVinicius) {
        estoqueModelVinicius.setId(idGerador++);
        listaEstoque.add(estoqueModelVinicius);

    }

    @Override
    public void excluir(EstoqueModelVinicius estoqueModelVinicius) {
        listaEstoque.remove(estoqueModelVinicius);

    }

    @Override
    public void alterar(EstoqueModelVinicius estoqueModelVinicius) {
        for(EstoqueModelVinicius aux : listaEstoque){
            long idAuxilar = aux.getId();
            long idEstoque = estoqueModelVinicius.getId();
            if (idAuxilar==idEstoque){
                listaEstoque.remove(aux);
                listaEstoque.add(estoqueModelVinicius);
            }
        }

    }

    @Override
    public List<EstoqueModelVinicius> listar() {
        return listaEstoque;
    }
}
