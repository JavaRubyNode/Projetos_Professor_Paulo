package br.com.faculdade.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.faculdade.model.VendasModelVinicius;
import br.com.faculdade.vinicius.R;

/**
 * Created by root on 16/05/16.
 */
public class VendasAdapterVinicius extends BaseAdapter {

    private List<VendasModelVinicius> listaVendas;
    private Context context;

    public VendasAdapterVinicius(List<VendasModelVinicius> listaVendas, Context context) {
        this.listaVendas = listaVendas;
        this.context = context;
    }


    @Override
    public int getCount() {
        return listaVendas.size();
    }

    @Override
    public Object getItem(int i) {
        return listaVendas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VendasModelVinicius modelVinicius = (VendasModelVinicius) getItem(position);

        View view = convertView.inflate(context, R.layout.item_lista_vendas,null);

        TextView tvId = (TextView)view.findViewById(R.id.tvId);
        tvId.setText("Id : "+modelVinicius.getId());
        TextView tvCliente = (TextView)view.findViewById(R.id.tvCliente);
        tvCliente.setText("Cliente : "+modelVinicius.getCliente());
        TextView tvProduto = (TextView)view.findViewById(R.id.tvProduto);
        tvProduto.setText("Produto : "+modelVinicius.getProduto());
        TextView tvValor = (TextView)view.findViewById(R.id.tvValor);
        tvProduto.setText("Valor : "+modelVinicius.getValor());



        return view;
    }
}
