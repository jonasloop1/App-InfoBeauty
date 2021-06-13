package com.example.app_infobeauty.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.app_infobeauty.InfoBeautySQLiteOpenHelper;
import com.example.app_infobeauty.R;


public class TelaLoginUsuario extends AppCompatActivity {

    EditText editTextEmailUsuario, editTextSenhaUsuario;
    Button btnLoginUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_usuario);


        editTextEmailUsuario = (EditText) findViewById(R.id.editTextEmailUsuario);
        editTextSenhaUsuario = (EditText) findViewById(R.id.editTextSenhaUsuario);
        btnLoginUsuario = (Button) findViewById(R.id.btnLoginUsuario);

        /*btnLoginUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailUsuario = editTextEmailUsuario.getText().toString();
                String senhaUsuario = editTextSenhaUsuario.getText().toString();

                if (emailUsuario.equals("")){
                    Toast.makeText(TelaLoginUsuario.this, "Preencha o Email Por favor!", Toast.LENGTH_SHORT).show();
                }
                else if (senhaUsuario.equals("")){
                    Toast.makeText(TelaLoginUsuario.this, "Preencha a Senha Por favor!", Toast.LENGTH_SHORT).show();
                }else {


                    }

                }

        });*/

    }





        public void telaLoginUsuarioNavegacao(View view){

        Intent intent = new Intent(this, TelaNavegacaoCliente.class);
        startActivity(intent);
    }
}