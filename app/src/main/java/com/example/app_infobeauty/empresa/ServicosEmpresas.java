package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_infobeauty.MaskEditUtil;
import com.example.app_infobeauty.R;

public class ServicosEmpresas extends AppCompatActivity {

    EditText nomeFuncionario, nomeServicos, horarioServicos;
    Button proxTelaNavEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos_empresas);

        nomeFuncionario = (EditText) findViewById(R.id.nomeFuncionario);
        nomeServicos = (EditText) findViewById(R.id.nomeServicos);
        horarioServicos = (EditText) findViewById(R.id.horarioServicos);
        proxTelaNavEmpresa = (Button) findViewById(R.id.buttonProximoTelaNavEmpresa);

        horarioServicos.addTextChangedListener(MaskEditUtil.mask(horarioServicos, MaskEditUtil.FORMAT_HOUR));

    }

    public void Inserir_servicos(View v) {
        String nomeFuncionarioo, nomeServicoss, horarioServicoss;
        nomeFuncionarioo = nomeFuncionario.getText().toString();
        nomeServicoss = nomeServicos.getText().toString();
        horarioServicoss =horarioServicos.getText().toString();

        if (nomeFuncionarioo.equals("")){
            Toast.makeText(ServicosEmpresas.this, "Preencha o Nome do Estabelecimento Por favor!", Toast.LENGTH_SHORT).show();
        }
        else if (nomeServicoss.equals("")){
            Toast.makeText(ServicosEmpresas.this, "Preencha o Serviço Por favor!", Toast.LENGTH_SHORT).show();
        }
        else if (horarioServicoss.equals("")){
            Toast.makeText(ServicosEmpresas.this, "Preencha o Horario Por favor!", Toast.LENGTH_SHORT).show();
        }else {

            ServicosDAO dao = new ServicosDAO(this);
            dao.open();
            dao.inserir_servicos(nomeFuncionarioo, nomeServicoss, horarioServicoss);
            Intent intent = new Intent(this, TelaNavegacaoEmpresa.class);
            startActivity(intent);
        }

    }
}