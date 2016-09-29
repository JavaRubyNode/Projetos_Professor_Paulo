package br.com.faculdade.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.faculdade.model.BensModelVinicius;
import br.com.faculdade.vinicius.R;

/**
 * Created by root on 30/05/16.
 */
public class BensAdapterVinicius extends BaseAdapter {

    private List<BensModelVinicius> listaAdapterModel;
    private Context context;

    public BensAdapterVinicius(List<BensModelVinicius> listaAdapterModel, Context context) {
        this.listaAdapterModel = listaAdapterModel;
        this.context = context;
    }

    @Override
    public int getCount() {return listaAdapterModel.size();}

    @Override
    public Object getItem(int position) {return listaAdapterModel.get(position);}

    @Override
    public long getItemId(int position) {return position;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       BensModelVinicius bens = (BensModelVinicius)getItem(position);
        View view = convertView.inflate(context, R.layout.item_lista_model,null);

        TextView tvId = (TextView)view.findViewById(R.id.tvId);
        tvId.setText("Id : "+bens.getId());

        TextView tvDescricao = (TextView)view.findViewById(R.id.tvDescricao);
        tvDescricao.setText("Descrição : "+bens.getDescricao());

        TextView tvEspecificacao = (TextView)view.findViewById(R.id.tvEspecificacao);
        tvEspecificacao.setText("Especificação : "+bens.getEspecificacao());

        TextView tvDepartamento = (TextView)view.findViewById(R.id.tvDepartemento);
        tvDepartamento.setText("Departamento : "+bens.getDepartamento());

        TextView tvValor = (TextView)view.findViewById(R.id.tvValor);
        tvValor.setText("Valor : "+bens.getValor());



        return view;
    }


}
