package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.app_infobeauty.R;

public class TelaEscolhaEmpresa extends AppCompatActivity {

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