package com.example.app_infobeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TelaLoginEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_empresa);
    }

    public void telaLoginEmpresaNavegacao(View view){

        Intent intent = new Intent(this, TelaNavegacao.class);
        startActivity(intent);
    }
}