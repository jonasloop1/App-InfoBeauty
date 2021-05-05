package com.example.app_infobeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaEscolhaEmpresa extends AppCompatActivity {
    Button button_tela_login_empresa, button_tela_cadastro_empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_escolha_empresa);
    }
    public void telaLoginEmpresa(View view){

        Intent intent = new Intent(this, TelaLoginEmpresa.class);
        startActivity(intent);
    }
    public void telaCadastrarEmpresa(View view){

        Intent intent = new Intent(this, TelaCadastroEmpresa.class);
        startActivity(intent);
    }
}