package br.com.faculdade.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.faculdade.model.AlunoModelVinicius;
import br.com.faculdade.vinicius.R;

/**
 * Created by root on 19/05/16.
 */
public class AlunoAdapterVinicius  extends BaseAdapter{

    private List<AlunoModelVinicius> listaModelAluno;
    private Context context;

    public AlunoAdapterVinicius(List<AlunoModelVinicius> listaModelAluno, Context context) {
        this.listaModelAluno = listaModelAluno;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaModelAluno.size();
    }

    @Override
    public Object getItem(int position) {
        return listaModelAluno.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AlunoModelVinicius aluno = (AlunoModelVinicius)getItem(position);
        View view = convertView.inflate(context, R.layout.item_lista_aluno,null);

        TextView tvId = (TextView)view.findViewById(R.id.tvId);
        tvId.setText("Id : "+aluno.getId());

        TextView tvNome = (TextView)view.findViewById(R.id.tvNome);
        tvNome.setText("Nome : "+aluno.getNome());


        TextView tvGrauInstrucao = (TextView)view.findViewById(R.id.tvGrauAcademico);
        tvGrauInstrucao.setText("Grau de Instrução : "+aluno.getGrauInstrução());

        TextView tvDataNascimento = (TextView)view.findViewById(R.id.tvDataNascimento);
        tvDataNascimento.setText("Data de Nascimento : "+formatacaoData(aluno.getDataNascimento()));

        TextView tvIdade = (TextView)view.findViewById(R.id.tvIdade);
        tvIdade.setText("Idade : "+aluno.getIdade());



        return view;
    }


    public String formatacaoData(Date date){
        SimpleDateFormat formator = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formator.format(date);
        return dataFormatada;
    }
}
