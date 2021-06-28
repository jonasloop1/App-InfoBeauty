package com.example.app_infobeauty.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app_infobeauty.R;

public class TelaEscolhaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_escolha_usuario);
    }
    public void telaLoginUsuario(View view){

        Intent intent = new Intent(this, TelaLoginUsuario.class);
        startActivity(intent);
    }
    public void telaCadastrarUsuario(View view){

        Intent intent = new Intent(this, TelaCadastroUsuario.class);
        startActivity(intent);
    }
}