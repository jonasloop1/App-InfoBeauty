package com.example.app_infobeauty.activities_substituintes_frag_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

import com.example.app_infobeauty.R;

public class MeuPerfil_c extends AppCompatActivity {

    EditText nomeUsuario, emailUsuario, cpfUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_perfil_c);

        nomeUsuario = (EditText) findViewById(R.id.edtNomeUsuario);
        emailUsuario = (EditText) findViewById(R.id.edtEmailUsuario);
        cpfUsuario = (EditText) findViewById(R.id.edtCpfUsuario);

        SharedPreferences prefsA = getApplicationContext().getSharedPreferences("MyPrefsUser", Context.MODE_PRIVATE);

        String nomeX = prefsA.getString("Nome", "");
        String EmailX = prefsA.getString("Email", "");
        String cpfx = prefsA.getString("cpf", "");

        nomeUsuario.setText(nomeX);
        emailUsuario.setText(EmailX);
        cpfUsuario.setText(cpfx);
    }
}