package br.com.faculdade.vinicius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.faculdade.vinicius.adapter.EstoqueAdapterVinicius;
import br.com.faculdade.vinicius.dao.EstoqueDaoVinicius;
import br.com.faculdade.vinicius.interfaces.DaoIVinicius;
import br.com.faculdade.vinicius.model.EstoqueModelVinicius;

public class ListaActivity extends AppCompatActivity {

    private ListView listView;
    private Intent intent;
    private DaoIVinicius<EstoqueModelVinicius> dao = new EstoqueDaoVinicius();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listView = (ListView) findViewById(R.id.lvListaEstoque);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                EstoqueModelVinicius estoque = (EstoqueModelVinicius) adapterView.getItemAtPosition(position);
                intent = new Intent(getBaseContext(), PrincipalActivity.class);
                intent.putExtra("selecionado", estoque);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                EstoqueModelVinicius estoque = (EstoqueModelVinicius) adapterView.getItemAtPosition(position);
                dao.excluir(estoque);
                mensagem("Excluido com sucesso");
                carregarLista();
                return false;
            }
        });
    }

    public void carregarLista() {
        List<EstoqueModelVinicius> listaEstoque = dao.listar();
        EstoqueAdapterVinicius adapterVinicius = new EstoqueAdapterVinicius(listaEstoque, getBaseContext());
        listView.setAdapter(adapterVinicius);
    }


    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    public void mensagem(String texto){
        Toast.makeText(getBaseContext(),texto, Toast.LENGTH_LONG).show();
    }
}



