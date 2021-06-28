package com.example.app_infobeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app_infobeauty.empresa.TelaEscolhaEmpresa;
import com.example.app_infobeauty.usuario.TelaEscolhaUsuario;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
    }

    public void telaEscolhaUsuario(View view){

        Intent intent = new Intent(this, TelaEscolhaUsuario.class);
        startActivity(intent);
    }

    public void telaEscolhaEmpresa(View view){

        Intent intent = new Intent(this, TelaEscolhaEmpresa.class);
        startActivity(intent);
    }
}