package br.com.faculdade.dao;

import java.util.List;

import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.BensModelVinicius;

/**
 * Created by root on 30/05/16.
 */
public class BensDaoVinicius implements DaoIVinicius<BensModelVinicius> {

    private static List<BensModelVinicius> listaObjeto;
    private static Long idGerador =1L;


    @Override
    public void salvar(BensModelVinicius bensModel) {
        bensModel.setId(idGerador++);
        listaObjeto.add(bensModel);

    }

    @Override
    public void excluir(BensModelVinicius bensModel) {
            listaObjeto.remove(bensModel);
    }

    @Override
    public void atualizar(BensModelVinicius bensModel) {
        for (BensModelVinicius bens:listaObjeto) {
            long idmodel = bensModel.getId();
            long idAux = bens.getId();
            if (idAux==idmodel){
                listaObjeto.remove(bens);
                listaObjeto.add(bensModel);
            }
        }
    }

    @Override
    public List<BensModelVinicius> listar() {
        return listaObjeto;
    }
}
