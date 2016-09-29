package br.com.faculdade.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.faculdade.model.BibliotecaModelVinicius;
import br.com.faculdade.vinicius.R;

/**
 * Created by root on 18/05/16.
 */
public class BibliotecaAdapterVinicius  extends BaseAdapter{

    private List<BibliotecaModelVinicius> listaLivros;
    private Context context;

    public BibliotecaAdapterVinicius(List<BibliotecaModelVinicius> listaLivros, Context context) {
        this.listaLivros = listaLivros;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaLivros.size();
    }

    @Override
    public Object getItem(int position) {
        return listaLivros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BibliotecaModelVinicius livros = (BibliotecaModelVinicius)getItem(position);
        View view = convertView.inflate(context, R.layout.item_lista_model,null);

        TextView tvId = (TextView)view.findViewById(R.id.tvId);
        tvId.setText("Id : "+livros.getId());

        TextView tvNome = (TextView)view.findViewById(R.id.tvNome);
        tvNome.setText("Nome do livro : "+livros.getNome());

        TextView tvEditora = (TextView)view.findViewById(R.id.tvEditora);
        tvEditora.setText("Editora : "+livros.getEditora());

        TextView tvValor = (TextView)view.findViewById(R.id.tvValor);
        tvValor.setText("Valor : "+livros.getValor());





        return view;
    }
}
