package com.example.app_infobeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServicosEmpresas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos_empresas);
    }
    public void chamarTelaNavegacaoEmpresa(View v){
    Intent intent = new Intent(this, TelaNavegacaoEmpresa.class);
    startActivity(intent);
    }
}