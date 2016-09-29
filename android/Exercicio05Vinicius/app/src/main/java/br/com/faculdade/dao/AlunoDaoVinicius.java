package br.com.faculdade.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.AlunoModelVinicius;

/**
 * Created by root on 19/05/16.
 */
public class AlunoDaoVinicius implements DaoIVinicius<AlunoModelVinicius> {

    private static List<AlunoModelVinicius> listaAluno = new ArrayList<>();
    private static Long idgerador;


    @Override
    public void salvar(AlunoModelVinicius alunoModelVinicius) {
        alunoModelVinicius.setId(idgerador++);
        listaAluno.add(alunoModelVinicius);

    }

    @Override
    public void excluir(AlunoModelVinicius alunoModelVinicius) {
        listaAluno.remove(alunoModelVinicius);

    }

    @Override
    public void alterar(AlunoModelVinicius alunoModelVinicius) {
        for(AlunoModelVinicius aluno : listaAluno){
            long idAux = aluno.getId();
            long idAluno = alunoModelVinicius.getId();
            if(idAluno==idAux){
                listaAluno.remove(aluno);
                listaAluno.add( alunoModelVinicius);
            }
        }

    }

    @Override
    public List<AlunoModelVinicius> listar() {
        return listaAluno;
    }
}
