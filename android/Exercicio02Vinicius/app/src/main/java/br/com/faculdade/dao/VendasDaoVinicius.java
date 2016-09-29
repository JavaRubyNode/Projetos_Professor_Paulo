package br.com.faculdade.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.VendasModelVinicius;

/**
 * Created by root on 16/05/16.
 */
public class VendasDaoVinicius implements DaoIVinicius<VendasModelVinicius>{

    private static List<VendasModelVinicius> listaModel = new ArrayList<>();
    private static Long idGerador = 1L;

    @Override
    public void salvar(VendasModelVinicius vendasModelVinicius) {
        vendasModelVinicius.setId(idGerador++);
        listaModel.add(vendasModelVinicius);

    }

    @Override
    public void excluir(VendasModelVinicius vendasModelVinicius) {
        listaModel.remove(vendasModelVinicius);

    }

    @Override
    public void atualizar(VendasModelVinicius vendasModelVinicius) {
        for (VendasModelVinicius vendas:listaModel) {
            long idModel = vendasModelVinicius.getId();
            long idAux = vendas.getId();
            if(idAux==idModel){
                listaModel.remove(vendas);
                listaModel.add(vendasModelVinicius);
            }
        }

    }

    @Override
    public List<VendasModelVinicius> listar() {
        return listaModel;
    }
}
