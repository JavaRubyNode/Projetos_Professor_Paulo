package br.com.faculdade.interfaces;

import android.view.View;
import android.widget.EditText;

/**
 * Created by root on 30/05/16.
 */
public interface MetodosIVinicius<T> {

    public void mensagem(String texto);
    public void carregarEditText(EditText ...texts);
    public void limparCampos(View view);
    public void preencherObjeto();
    public void peencherFormulario(T t);
    public void listar(View view);
    public void salvar(View view);
}
