package com.example.app_infobeauty.activities_substituintes_frag_c;

import androidx.appcompat.app.AppCompatActivity;

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

        nomeUsuario.setText("Jonas silva");
        emailUsuario.setText("jonas@gmail.com");
        cpfUsuario.setText("181.164.007-39");
    }
}