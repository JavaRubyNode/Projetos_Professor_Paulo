package br.com.faculdade.vinicius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.util.List;

import br.com.faculdade.adapter.BibliotecaAdapterVinicius;
import br.com.faculdade.dao.BibliotecaDaoVinicius;
import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.BibliotecaModelVinicius;

public class PrincipalActivity extends AppCompatActivity {

    private DaoIVinicius<BibliotecaModelVinicius> dao = new BibliotecaDaoVinicius();
    private BibliotecaModelVinicius livros = new BibliotecaModelVinicius();
    private Intent intent;
    private EditText etNome;
    private EditText etEditora;
    private EditText etValor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etNome= (EditText)findViewById(R.id.etNome);
        etValor= (EditText)findViewById(R.id.etValor);
        etEditora= (EditText)findViewById(R.id.etEditora);

        intent = getIntent();
        if(intent!=null){
            BibliotecaModelVinicius biblioteca = (BibliotecaModelVinicius)intent.getSerializableExtra("selecionado");
            if(biblioteca!=null){
                preencherFormulario(biblioteca);
            }
        }


    }


    public void preencherFormulario(BibliotecaModelVinicius vinicius){
        etEditora.setText(vinicius.getEditora());
        etNome.setText(vinicius.getNome());
        etValor.setText(String.valueOf(vinicius.getValor()));
        livros.setId(vinicius.getId());
    }


    public void salvar(View view) {


        preencherObjeto();
        if (livros.getId() == null) {
            dao.salvar(livros);
            mensagem("Salvo com sucesso");
        } else {
            dao.alterar(livros);
            mensagem("Dados Atualizado com sucesso");
        }



        limparCampos(view);
    }

    private void preencherObjeto() {
        livros.setNome(etNome.getText().toString());
        livros.setEditora(etEditora.getText().toString());
        livros.setValor(Double.parseDouble(etValor.getText().toString()));
    }


    public void mensagem(String texto) {
        Toast.makeText(getBaseContext(), texto, Toast.LENGTH_LONG).show();
    }

    public void carregarEdit(EditText... texts) {
        for (EditText t : texts) {
            t.setText("");
        }
    }

    public void listar(View view) {
        intent = new Intent(getBaseContext(), ListaActivity.class);
        startActivity(intent);
    }

    public void limparCampos(View view) {
        carregarEdit(etValor, etEditora, etNome);
        livros = new BibliotecaModelVinicius();
    }


}
