package com.example.app_infobeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaEscolhaUsuario extends AppCompatActivity {
    Button button_tela_login_usuario, button_tela_cadastro_usuario;

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