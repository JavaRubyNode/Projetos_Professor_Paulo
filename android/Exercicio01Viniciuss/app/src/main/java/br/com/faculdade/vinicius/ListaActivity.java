package br.com.faculdade.vinicius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.faculdade.adapter.BensAdapterVinicius;
import br.com.faculdade.dao.BensDaoVinicius;
import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.BensModelVinicius;

public class ListaActivity extends AppCompatActivity {

    private ListView lvLista;
    private BensModelVinicius modeloSelecionado;
    private DaoIVinicius<BensModelVinicius> dao = new BensDaoVinicius();
    private BensAdapterVinicius adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvLista = (ListView)findViewById(R.id.lvListarModel);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                modeloSelecionado = (BensModelVinicius)parent.getItemAtPosition(position);
                intent = new Intent(getBaseContext(),PrincipalActivity.class);
                intent.putExtra("selecionado",modeloSelecionado);
                startActivity(intent);

            }
        });


        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                modeloSelecionado = (BensModelVinicius)parent.getItemAtPosition(position);
                dao.excluir(modeloSelecionado);
                carregarLista();
                mensagem("Excluido com sucesso");

                return false;
            }
        });
    }

    public void carregarLista(){
        List<BensModelVinicius> lista = dao.listar();
        adapter = new BensAdapterVinicius(lista,getBaseContext());
        lvLista.setAdapter(adapter);
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
