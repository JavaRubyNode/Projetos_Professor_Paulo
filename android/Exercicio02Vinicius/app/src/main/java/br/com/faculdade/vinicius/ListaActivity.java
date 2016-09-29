package br.com.faculdade.vinicius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.faculdade.adapter.VendasAdapterVinicius;
import br.com.faculdade.dao.VendasDaoVinicius;
import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.VendasModelVinicius;

public class ListaActivity extends AppCompatActivity {

    private ListView lvlistaModelVendas;
    private DaoIVinicius<VendasModelVinicius> dao = new VendasDaoVinicius();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvlistaModelVendas = (ListView)findViewById(R.id.lvListaVendas);

        lvlistaModelVendas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                VendasModelVinicius vinicius = (VendasModelVinicius)parent.getItemAtPosition(position);
                Intent intent = new Intent(getBaseContext(),PrincipalActivity.class);
                intent.putExtra("selecionado",vinicius);
                startActivity(intent);

            }
        });


        lvlistaModelVendas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                VendasModelVinicius vinicius = (VendasModelVinicius)parent.getItemAtPosition(position);

                dao.excluir(vinicius);
                carregarLista();





                return false;
            }
        });
    }


    public void carregarLista(){
        List<VendasModelVinicius> listVenda = dao.listar();
        VendasAdapterVinicius adapter = new VendasAdapterVinicius(listVenda,getBaseContext());
        lvlistaModelVendas.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }
}
