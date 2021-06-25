package com.example.app_infobeauty.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_infobeauty.MaskEditUtil;
import com.example.app_infobeauty.R;

public class TelaCadastroUsuario extends AppCompatActivity {

    EditText nomeUsuario, emailUsuario, cpfUsuario, senhaUsuario, confirmasenhaUsuario;
    Button cadastroUsuario;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_usuario);

        cadastroUsuario = (Button) findViewById(R.id.CadastroUsuario);
        nomeUsuario = (EditText) findViewById(R.id.nomeUsuario);
        emailUsuario = (EditText) findViewById(R.id.emailUsuario);
        cpfUsuario = (EditText) findViewById(R.id.cpfUsuario);
        senhaUsuario = (EditText) findViewById(R.id.senhaUsuario);
        confirmasenhaUsuario = (EditText) findViewById(R.id.confirmasenhaUsuario);

        cpfUsuario.addTextChangedListener(MaskEditUtil.mask(cpfUsuario, MaskEditUtil.FORMAT_CPF));
        prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        cadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome_usuario, email_usuario, cpf_usuario, senha_usuario, confirmasenha_usuario;
                nome_usuario = nomeUsuario.getText().toString();
                email_usuario = emailUsuario.getText().toString();
                cpf_usuario = cpfUsuario.getText().toString();
                senha_usuario = senhaUsuario.getText().toString();
                confirmasenha_usuario = confirmasenhaUsuario.getText().toString();

                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("Nome", nome_usuario);
                editor.putString("Email", email_usuario);
                editor.commit();


                if (nome_usuario.equals("")){
                    Toast.makeText(TelaCadastroUsuario.this, "Preencha o Nome Por favor!", Toast.LENGTH_SHORT).show();
                }
                else if (email_usuario.equals("")){
                    Toast.makeText(TelaCadastroUsuario.this, "Preencha o Email Por favor!", Toast.LENGTH_SHORT).show();
                }
                else if (cpf_usuario.equals("")){
                    Toast.makeText(TelaCadastroUsuario.this, "Preencha o Cpf Por favor!", Toast.LENGTH_SHORT).show();
                }
                else if (senha_usuario.equals("") || confirmasenha_usuario.equals("")){
                    Toast.makeText(TelaCadastroUsuario.this, "Por Favor Preencha a senha corretamente!", Toast.LENGTH_SHORT).show();
                }
                else if (!senha_usuario.equals(confirmasenha_usuario)){
                    Toast.makeText(TelaCadastroUsuario.this, "As senhas não correspondem!", Toast.LENGTH_SHORT).show();
                }else {

                    UsuarioDAO dao = new UsuarioDAO(TelaCadastroUsuario.this);
                    dao.open();
                    dao.inserir_usuario(nome_usuario, email_usuario, cpf_usuario, senha_usuario);
                    Intent intent = new Intent(getApplicationContext(), TelaNavegacaoCliente.class);
                    startActivity(intent);
                }
            }
        });

    }


}