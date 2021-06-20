package com.example.app_infobeauty.activities_substituintes_frag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.app_infobeauty.R;
import com.example.app_infobeauty.agendamento.AgendamentoServicos;
import com.example.app_infobeauty.empresa.Empresa;
import com.example.app_infobeauty.empresa.EmpresaDAO;

import java.util.Iterator;
import java.util.List;

public class MeuEstabelecimento_e extends AppCompatActivity implements  AdapterView.OnItemClickListener{

    EditText nomeEstab, enderecoEstab, emailEstab, cnpjEstab;
    ListView lista;
    private EmpresaDAO dao;
    private String[] dados;
    private  long[] idDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_estabelecimento_e);

        lista = (ListView) findViewById(R.id.listViewDadosEmpresa);
        dao = new EmpresaDAO(this);
        dao.open();
        lista.setOnItemClickListener(this);

        /*nomeEstab = (EditText) findViewById(R.id.edtNomeEstabelecimento);
        enderecoEstab = (EditText) findViewById(R.id.edtEnderecoEstabelecimento);
        emailEstab = (EditText) findViewById(R.id.edtEmailEstabelecimento);
        cnpjEstab = (EditText) findViewById(R.id.edtCnpjEstabelecimento);

        nomeEstab.setText(getIntent().getExtras().getString("nomeEstabelecimento"));
        enderecoEstab.setText(getIntent().getExtras().getString("enderecoEstabelecimento"));
        emailEstab.setText(getIntent().getExtras().getString("emailEstabelecimento"));
        cnpjEstab.setText(getIntent().getExtras().getString("cnpjEstabelecimento"));*/
    }

    @Override
    protected void onResume(){
        dao.open();
        super.onResume();
        List<Empresa> listaDeDados = dao.getAll();
        dados = new String[listaDeDados.size()];
        idDados = new long[listaDeDados.size()];
        int i = 0;

        Iterator<Empresa> iterator = listaDeDados.iterator();
        while (iterator.hasNext()){
            Empresa aux = new Empresa();
            aux = (Empresa) iterator.next();
            dados[i] = aux.textoLista2();
            idDados[i] = aux.getId_empresa();
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        lista.setAdapter(adapter);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long ident){
        long id = idDados[position];
        Intent intent = new Intent(getApplicationContext(), AgendamentoServicos.class);
        intent.putExtra("acao", 0);
        intent.putExtra("id", id);
    }
}