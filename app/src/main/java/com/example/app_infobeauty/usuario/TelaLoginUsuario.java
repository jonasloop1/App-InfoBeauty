package com.example.app_infobeauty.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_infobeauty.R;

public class TelaLoginUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_usuario);
    }

    public void telaLoginUsuarioNavegacao(View view){

        Intent intent = new Intent(this, TelaNavegacaoCliente.class);
        startActivity(intent);
    }
}