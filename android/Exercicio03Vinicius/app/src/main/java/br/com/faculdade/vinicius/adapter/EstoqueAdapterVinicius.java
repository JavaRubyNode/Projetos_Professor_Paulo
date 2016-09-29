package br.com.faculdade.vinicius.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.faculdade.vinicius.R;
import br.com.faculdade.vinicius.model.EstoqueModelVinicius;

/**
 * Created by root on 17/05/16.
 */
public class EstoqueAdapterVinicius extends BaseAdapter {
    private List<EstoqueModelVinicius> listaAdapter;
    private Context context;

    public EstoqueAdapterVinicius(List<EstoqueModelVinicius> listaAdapter, Context context) {
        this.listaAdapter = listaAdapter;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaAdapter.size();
    }

    @Override
    public Object getItem(int posistion) {
        return listaAdapter.get(posistion);
    }

    @Override
    public long getItemId(int posistion) {
        return posistion;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EstoqueModelVinicius estoque = (EstoqueModelVinicius)getItem(position);
        View view = convertView.inflate(context, R.layout.item_lista_model,null);

        TextView tvId = (TextView)view.findViewById(R.id.tvId);
        tvId.setText("Id : "+estoque.getId());

        TextView tvProduto = (TextView)view.findViewById(R.id.tvProduto);
        tvProduto.setText("Produto : "+estoque.getProduto());

        TextView tvFornecedor = (TextView)view.findViewById(R.id.tvFornecedor);
        tvFornecedor.setText("Fornecedor : "+estoque.getFornecedor());

        TextView tvValor = (TextView)view.findViewById(R.id.tvValor);
        tvValor.setText("Valor : "+estoque.getValor());


        return view;
    }
}
