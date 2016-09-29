package br.com.faculdade.vinicius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.faculdade.dao.VendasDaoVinicius;
import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.VendasModelVinicius;

public class PrincipalActivity extends AppCompatActivity {

    private DaoIVinicius<VendasModelVinicius> dao = new VendasDaoVinicius();
    private VendasModelVinicius vendasModelVinicius = new VendasModelVinicius();
    private Intent intent;
    private EditText etCliente;
    private EditText etProduto;
    private EditText etValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etCliente = (EditText)findViewById(R.id.etCliente);
        etProduto = (EditText)findViewById(R.id.etProduto);
        etValor = (EditText)findViewById(R.id.etValor);

        intent =getIntent();
        if(intent!=null){
            VendasModelVinicius vendaSelecionada = (VendasModelVinicius) intent.getSerializableExtra("selecionado");
                if(vendaSelecionada!=null){
                    preencherFormulario(vendaSelecionada);
                }
        }

    }

    public void preencherFormulario(VendasModelVinicius modelVinicius){
        etProduto.setText(modelVinicius.getProduto());
        etCliente.setText(modelVinicius.getCliente());
        etValor.setText(String.valueOf(modelVinicius.getValor()));
        vendasModelVinicius.setId(modelVinicius.getId());
    }

    public void preencherModel(){
        vendasModelVinicius.setValor(Double.parseDouble(etValor.getText().toString()));
        vendasModelVinicius.setCliente(etProduto.getText().toString());
        vendasModelVinicius.setProduto(etProduto.getText().toString());

    }


    public void listaEdit(EditText ...texts){
        for (EditText t : texts){
            t.setText("");
        }
    }

    public void limparCampos(View view){
        listaEdit(etCliente,etProduto,etValor);
        vendasModelVinicius = new VendasModelVinicius();
    }

    public void listar(View view){
        intent = new Intent(getBaseContext(),ListaActivity.class);
        startActivity(intent);
    }

    public void salvar(View view){
        preencherModel();
        if(vendasModelVinicius.getId()==null){
            dao.salvar(vendasModelVinicius);
        }else{dao.atualizar(vendasModelVinicius);}
        limparCampos(view);
    }

}
