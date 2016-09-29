package br.com.faculdade.vinicius;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.faculdade.vinicius.dao.EstoqueDaoVinicius;
import br.com.faculdade.vinicius.interfaces.DaoIVinicius;
import br.com.faculdade.vinicius.model.EstoqueModelVinicius;

public class PrincipalActivity extends AppCompatActivity {

    private DaoIVinicius<EstoqueModelVinicius> dao = new EstoqueDaoVinicius();
    private EstoqueModelVinicius estoque = new EstoqueModelVinicius();
    private Intent intent;
    private EditText etProduto;
    private EditText etFornecedor;
    private EditText etValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etProduto = (EditText) findViewById(R.id.etProduto);
        etFornecedor = (EditText) findViewById(R.id.etFornecedor);
        etValor = (EditText) findViewById(R.id.etValor);
        intent = getIntent();
        if (intent != null) {
            EstoqueModelVinicius modelVinicius = (EstoqueModelVinicius) intent.getSerializableExtra("selecionado");
            if (modelVinicius != null) {
                preencherFormulario(modelVinicius);
            }
        }


    }


    public void preencherFormulario(EstoqueModelVinicius vinicius) {
        etProduto.setText(vinicius.getProduto());
        etFornecedor.setText(vinicius.getFornecedor());
        etValor.setText(String.valueOf(vinicius.getValor()));
        estoque.setId(vinicius.getId());
    }


    public void preencherObjeto() {

        estoque.setProduto(etProduto.getText().toString());
        estoque.setFornecedor(etFornecedor.getText().toString());
        estoque.setValor(Double.parseDouble(etValor.getText().toString()));

    }


    public void salvar(View view) {


            preencherObjeto();
            if (estoque.getId() == null) {
                dao.salvar(estoque);
                mensagem("Salvo com sucesso");
            } else {
                dao.alterar(estoque);
                mensagem("Dados Atualizado com sucesso");
            }



        limparCampos(view);
    }	

    public void listar(View view) {
        intent = new Intent(getBaseContext(), ListaActivity.class);
        startActivity(intent);
    }


    public void limparCampos(View view) {
        carregarEdit(etValor, etProduto, etFornecedor);
        estoque = new EstoqueModelVinicius();
    }


    public void carregarEdit(EditText... texts) {
        for (EditText t : texts) {
            t.setText("");
        }
    }

    public void mensagem(String texto) {
        Toast.makeText(getBaseContext(), texto, Toast.LENGTH_LONG).show();
    }

    public void validar(View view){

        if((checarVazio(etProduto)==true)||(checarVazio(etFornecedor)==true)||(checarVazio(etValor)==true)){
            mensagem("Campos invalidos corriga os dados");

        }else {salvar(view);
        }
    }


    public boolean checarVazio(EditText text){
        boolean check = false;
        check = (text.getText().toString()=="") ? true :false;
        return check;
    }
}
