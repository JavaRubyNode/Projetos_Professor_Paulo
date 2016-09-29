package br.com.faculdade.interfaces;

import android.view.View;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by root on 19/05/16.
 */
public interface MetodosIVinicius<T> {

    public void salvar(View view);
    public void listar(View view);
    public void LimparCampos(View view);
    public void carregarEditText(EditText ...texts);
    public void mensagem(String texto);
    public void preencherObjeto();
    public void preencherFormulario(T t);
    public String formatarData();
    public boolean validar(T t);
    public Date dataConvertida(EditText text, String texto);

}
