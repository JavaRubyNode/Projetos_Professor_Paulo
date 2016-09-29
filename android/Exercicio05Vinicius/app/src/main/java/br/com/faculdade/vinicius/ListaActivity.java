package br.com.faculdade.vinicius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.faculdade.adapter.AlunoAdapterVinicius;
import br.com.faculdade.dao.AlunoDaoVinicius;
import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.AlunoModelVinicius;

public class ListaActivity extends AppCompatActivity {

    private ListView lvListaAlunoModel;
    private AlunoAdapterVinicius adapter;
    private AlunoModelVinicius alunoSelecionado;
    private DaoIVinicius<AlunoModelVinicius> dao = new AlunoDaoVinicius();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvListaAlunoModel = (ListView)findViewById(R.id.lvListaModelAluno);

        lvListaAlunoModel.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                alunoSelecionado = (AlunoModelVinicius)parent.getItemAtPosition(position);
                intent = new Intent(getBaseContext(),PrincipalActivity.class);
                intent.putExtra("selecionado",alunoSelecionado);
                startActivity(intent);

                return false;
            }
        });


        lvListaAlunoModel.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                alunoSelecionado = (AlunoModelVinicius)parent.getItemAtPosition(position);
                dao.excluir(alunoSelecionado);
                mensagem("Excluido com sucesso");

                return false;
            }
        });

    }

    public void carregarLista(){
        List<AlunoModelVinicius> lista = dao.listar();
        adapter = new AlunoAdapterVinicius(lista,getBaseContext());
        lvListaAlunoModel.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    public void mensagem(String texto) {
        Toast.makeText(getBaseContext(), texto, Toast.LENGTH_LONG).show();
    }
}
