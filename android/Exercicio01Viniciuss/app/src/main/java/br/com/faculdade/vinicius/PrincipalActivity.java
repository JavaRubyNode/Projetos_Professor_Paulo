package br.com.faculdade.vinicius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.faculdade.dao.BensDaoVinicius;
import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.interfaces.MetodosIVinicius;
import br.com.faculdade.model.BensModelVinicius;

public class PrincipalActivity extends AppCompatActivity implements MetodosIVinicius<BensModelVinicius> {

    private Intent intent;
    private DaoIVinicius<BensModelVinicius> dao = new BensDaoVinicius();
    private BensModelVinicius model = new BensModelVinicius();
    private EditText etDescricao;
    private EditText etEspecificacao;
    private EditText etDepartamento;
    private EditText etValor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etDepartamento = (EditText)findViewById(R.id.etDepartamento);
        etDescricao = (EditText)findViewById(R.id.etDescricao);
        etEspecificacao = (EditText)findViewById(R.id.etEspecificacao);
        etValor = (EditText)findViewById(R.id.etValor);

        intent = getIntent();
        if(intent!=null){
            BensModelVinicius modelo = (BensModelVinicius)intent.getSerializableExtra("selecionado");
            if(modelo!=null){
                peencherFormulario(modelo);
            }
        }

    }

    @Override
    public void mensagem(String texto) {Toast.makeText(getBaseContext(), texto, Toast.LENGTH_LONG).show();}

    @Override
    public void carregarEditText(EditText... texts) {
        for(EditText t :texts){
            t.setText("");
        }

    }

    @Override
    public void limparCampos(View view) {
        carregarEditText(etValor,etDepartamento,etDescricao,etEspecificacao);
        model= new BensModelVinicius();
    }

    @Override
    public void preencherObjeto() {
        model.setDepartamento(etDepartamento.getText().toString());
        model.setDescricao(etDescricao.getText().toString());
        model.setEspecificacao(etEspecificacao.getText().toString());
        model.setValor(Double.parseDouble(etValor.getText().toString()));
    }

    @Override
    public void peencherFormulario(BensModelVinicius bensModel) {
            etDescricao.setText(bensModel.getDescricao());
            etEspecificacao.setText(bensModel.getEspecificacao());
            etDepartamento.setText(bensModel.getDepartamento());
            etValor.setText(String.valueOf(bensModel.getValor()));
            model.setId(bensModel.getId());
    }

    @Override
    public void listar(View view) {
        intent = new Intent(getBaseContext(),ListaActivity.class);
        startActivity(intent);
    }

    @Override
    public void salvar(View view) {
        preencherObjeto();
        if (model.getId() == null) {
            dao.salvar(model);
            mensagem("Salvo com sucesso");
        } else {
            dao.atualizar(model);
            mensagem("Dados Atualizado com sucesso");
        }
        limparCampos(view);

    }
}
