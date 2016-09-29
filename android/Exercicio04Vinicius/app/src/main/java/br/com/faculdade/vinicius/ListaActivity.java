package br.com.faculdade.vinicius;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.faculdade.adapter.BibliotecaAdapterVinicius;
import br.com.faculdade.dao.BibliotecaDaoVinicius;
import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.model.BibliotecaModelVinicius;

public class ListaActivity extends AppCompatActivity {

    private ListView lvListaLivros;
    private BibliotecaModelVinicius livros;
    private DaoIVinicius<BibliotecaModelVinicius> dao = new BibliotecaDaoVinicius();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lvListaLivros = (ListView)findViewById(R.id.lvListaModel);

        lvListaLivros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                livros = (BibliotecaModelVinicius)parent.getItemAtPosition(position);
                intent = new Intent(getBaseContext(),PrincipalActivity.class);
                intent.putExtra("selecionado",livros);
                startActivity(intent);

                return false;
            }
        });


        lvListaLivros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                livros = (BibliotecaModelVinicius)parent.getItemAtPosition(position);
                dao.excluir(livros);
                mensagem("Excluido com sucesso "+livros.getNome());
                carregarLista();

                return false;
            }
        });


    }

    public void carregarLista(){
        List<BibliotecaModelVinicius> listaTemp = dao.listar();
        BibliotecaAdapterVinicius adapter = new BibliotecaAdapterVinicius(listaTemp,getBaseContext());
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
