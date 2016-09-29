package br.com.faculdade.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.BibliotecaModelVinicius;

/**
 * Created by root on 18/05/16.
 */
public class BibliotecaDaoVinicius implements DaoIVinicius<BibliotecaModelVinicius> {

    private static List<BibliotecaModelVinicius> listaLivros = new ArrayList<>();
    private static Long idGerador = 1L;

    @Override
    public void salvar(BibliotecaModelVinicius bibliotecaModelVinicius) {
    bibliotecaModelVinicius.setId(idGerador++);
        listaLivros.add(bibliotecaModelVinicius);
    }

    @Override
    public void excluir(BibliotecaModelVinicius bibliotecaModelVinicius) {
    listaLivros.remove(bibliotecaModelVinicius);
    }

    @Override
    public void alterar(BibliotecaModelVinicius bibliotecaModelVinicius) {
        for (BibliotecaModelVinicius livros:listaLivros) {
            long idAux = livros.getId();
            long idBiblioteca = bibliotecaModelVinicius.getId();
            if (idAux==idBiblioteca){
                listaLivros.remove(livros);
                listaLivros.add(bibliotecaModelVinicius);
            }
        }

    }

    @Override
    public List<BibliotecaModelVinicius> listar() {
        return listaLivros;
    }
}
