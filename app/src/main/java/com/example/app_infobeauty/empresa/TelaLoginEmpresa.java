package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_infobeauty.R;

public class TelaLoginEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_empresa);
    }

    public void telaLoginEmpresaNavegacao(View view){

        Intent intent = new Intent(this, TelaNavegacaoEmpresa.class);
        startActivity(intent);
    }
}