package com.example.app_infobeauty.empresa;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_infobeauty.R;

public class TelaCadastroEmpresa extends AppCompatActivity {

    EditText nomeEmpresa, emailEmpresa, cnpjEmpresa, senhaEmpresa,confirmasenhaEmpresa;
    Button proximoEmpresaCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_empresa);

        proximoEmpresaCadastro = (Button) findViewById(R.id.proximoEmpresaCadastro);
        nomeEmpresa = (EditText) findViewById(R.id.nomeEmpresa);
        emailEmpresa = (EditText) findViewById(R.id.emailEmpresa);
        cnpjEmpresa = (EditText) findViewById(R.id.cnpjEmpresa);
        senhaEmpresa = (EditText) findViewById(R.id.senhaEmpresa);
        confirmasenhaEmpresa = (EditText) findViewById(R.id.confirmasenhaEmpresa);

    }
        public void Inserir (View v){
            String nome, email, cnpj, senha, confirmasenha;
            nome = nomeEmpresa.getText().toString();
            email = emailEmpresa.getText().toString();
            cnpj = cnpjEmpresa.getText().toString();
            senha = senhaEmpresa.getText().toString();
            confirmasenha = confirmasenhaEmpresa.getText().toString();
            EmpresaDAO dao = new EmpresaDAO(this);
            dao.open();
            dao.inserir(nome, email, cnpj, senha, confirmasenha);
            //dao.close();
            Intent intent = new Intent(getApplicationContext(), ServicosEmpresas.class);
            startActivity(intent);
            //finish();

        }
    }
