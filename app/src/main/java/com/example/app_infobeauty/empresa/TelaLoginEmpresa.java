package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_infobeauty.R;

public class TelaLoginEmpresa extends AppCompatActivity {
    EditText emailLogin, senhaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_empresa);

        emailLogin = (EditText) findViewById(R.id.edtEmailEmpresaLogin);
        senhaLogin = (EditText) findViewById(R.id.edtSenhaEmpresaLogin);
    }

    public void login_empresa(View v){
        String loginEmail, loginSenha;

        loginEmail = emailLogin.getText().toString();
        loginSenha = senhaLogin.getText().toString();

        if(loginEmail.equals("")){
            Toast.makeText(TelaLoginEmpresa.this, "Email não inserido, tente novamente", Toast.LENGTH_SHORT).show();
        }else if(loginSenha.equals("")){
            Toast.makeText(TelaLoginEmpresa.this, "Senha não inserido, tente novamente", Toast.LENGTH_SHORT).show();
        }else{

            EmpresaDAO dao = new EmpresaDAO(TelaLoginEmpresa.this);
            dao.open();
            String res = dao.login_empresa(loginEmail, loginSenha);

            if(res.equals("OK")){
                Toast.makeText(TelaLoginEmpresa.this, "Login efetuado com sucesso ✓", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TelaLoginEmpresa.this, TelaNavegacaoEmpresa.class);
                startActivity(intent);
            }else{
                Toast.makeText(TelaLoginEmpresa.this, "Usuário ou senha incorreta", Toast.LENGTH_SHORT).show();
            }
        }
    }
}