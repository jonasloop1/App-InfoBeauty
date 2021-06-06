package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_infobeauty.R;

public class ServicosEmpresas extends AppCompatActivity {

    EditText nomeFuncionario, nomeServicos, horarioServicos;
    Button proxTelaNavEmpresa;
    private int acao;
    private long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos_empresas);

        nomeFuncionario = (EditText) findViewById(R.id.nomeFuncionario);
        nomeServicos = (EditText) findViewById(R.id.nomeServicos);
        horarioServicos = (EditText) findViewById(R.id.horarioServicos);
        proxTelaNavEmpresa = (Button) findViewById(R.id.buttonProximoTelaNavEmpresa);
        acao = getIntent().getExtras().getInt("acao");
        id = getIntent().getExtras().getLong("id");
        if (acao == -1) {
            // inclusão
            setTitle("");
            nomeFuncionario.setText("");
            nomeServicos.setText("");
            horarioServicos.setText("");

        }
    }

    public void Inserir_servicos(View v) {
        String nomeFuncionarioo, nomeServicoss, horarioServicoss;
        nomeFuncionarioo = nomeFuncionario.getText().toString();
        nomeServicoss = nomeServicos.getText().toString();
        horarioServicoss =horarioServicos.getText().toString();
        ServicosDAO dao = new ServicosDAO(this);
        dao.open();
        if (acao == -1) {
            dao.inserir_servicos(nomeFuncionarioo, nomeServicoss, horarioServicoss);
            //dao.close();
            //finish();
        }
    }

    public void chamarTelaNavegacaoEmpresa(View v){
    Intent intent = new Intent(this, TelaNavegacaoEmpresa.class);
    startActivity(intent);
    }
}