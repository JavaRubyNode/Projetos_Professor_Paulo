package br.com.faculdade.vinicius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.com.faculdade.dao.AlunoDaoVinicius;
import br.com.faculdade.interfaces.DaoIVinicius;
import br.com.faculdade.interfaces.MetodosIVinicius;
import br.com.faculdade.model.AlunoModelVinicius;

public class PrincipalActivity extends AppCompatActivity implements MetodosIVinicius<AlunoModelVinicius> {

    private DaoIVinicius<AlunoModelVinicius> dao = new AlunoDaoVinicius();
    private AlunoModelVinicius aluno = new AlunoModelVinicius();
    private Intent intent;
    private EditText etNome;
    private EditText etIdade;
    private EditText etDataNascimento;
    private EditText etGrauInstrucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        etNome = (EditText)findViewById(R.id.etNome);
        etIdade = (EditText)findViewById(R.id.etIdade);
        etGrauInstrucao = (EditText)findViewById(R.id.etGrauInstrucao);
        etDataNascimento = (EditText)findViewById(R.id.etDataNascimento);





        intent= getIntent();
        if(intent!=null){

            AlunoModelVinicius alunoSelecionado = (AlunoModelVinicius)intent.getSerializableExtra("selecionado");
            if(alunoSelecionado!=null){
                preencherFormulario(alunoSelecionado);
            }
        }

    }

    @Override
    public void salvar(View view) {


        preencherObjeto();

        if(validar(aluno)==true) {

            if (aluno.getId() == null) {
                dao.salvar(aluno);
                mensagem("Salvo com sucesso");
                LimparCampos(view);
            } else {
                dao.alterar(aluno);
                mensagem("Dados Atualizado com sucesso");
            }



        }else{
            mensagem("Informe dados validos");
        }
    }


    @Override
    public void listar(View view) {
        intent = new Intent(getBaseContext(), ListaActivity.class);
        startActivity(intent);

    }

    @Override
    public void LimparCampos(View view) {
        carregarEditText(etNome, etDataNascimento, etGrauInstrucao, etIdade);
        aluno = new AlunoModelVinicius();

    }

    @Override
    public void carregarEditText(EditText... texts) {
        for (EditText t : texts) {
            t.setText("");
        }

    }

    @Override
    public void mensagem(String texto) {
        Toast.makeText(getBaseContext(), texto, Toast.LENGTH_LONG).show();
    }

    @Override
    public void preencherObjeto() {

        aluno.setNome(etNome.getText().toString());
        aluno.setIdade(Integer.parseInt(etIdade.getText().toString()));
        aluno.setDataNascimento(dataConvertida(etDataNascimento,"Erro na Data, invalida !!"));
        aluno.setGrauInstrução(etGrauInstrucao.getText().toString());
    }

    @Override
    public void preencherFormulario(AlunoModelVinicius vinicius) {

        verificarCampos();
        etNome.setText(vinicius.getNome());
        etDataNascimento.setText(formatarData());
        etIdade.setText(String.valueOf(vinicius.getId()));
        etGrauInstrucao.setText(vinicius.getGrauInstrução());

    }

    @Override
    public String formatarData() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatador.format(aluno.getDataNascimento());
        return dataFormatada;
    }

    @Override
    public boolean validar(AlunoModelVinicius model) {

        boolean validar = false;
        if(checarCampo(aluno.getNome())==true){
            validar = true;
        }if(checarCampo(aluno.getGrauInstrução())==true){
            validar = true;
        }if(aluno.getIdade()==0){
            validar = true;
        }if(checarCampo(String.valueOf(aluno.getDataNascimento()))==true){
            validar = true;
        }


        return validar;
    }

    public boolean checarCampo(String texto){
        boolean validar = texto.trim()=="" ? true: false;
        return validar;
    }

    public void verificarCampos(){
        if(pegarCampoVazio(etNome)==""){
            aluno.setNome("Vazio");
        }if(pegarCampoVazio(etGrauInstrucao)==""){
            aluno.setGrauInstrução("Vazio");
        }if(pegarCampoVazio(etDataNascimento)==""){
            aluno.setDataNascimento(new Date());
        }if(pegarCampoVazio(etIdade)==""){
            aluno.setIdade(0);
        }
    }

    @Override
    public Date dataConvertida(EditText text, String texto) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date dataTemp = null;
        try {
            dataTemp = formatador.parse(text.getText().toString());
        } catch (ParseException e) {
           mensagem(texto);
        }


        return dataTemp;
    }




    public String pegarCampoVazio(EditText text){
        return text.getText().toString().trim();
    }



    public Date data(EditText text) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        Date dataTemp = null;
        try {
            dataTemp = formatador.parse(text.getText().toString());
        } catch (ParseException e) {

        }


        return dataTemp;
    }







}
