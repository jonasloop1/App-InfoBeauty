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
import com.example.app_infobeauty.empresa.EmpresaDAO;
import com.example.app_infobeauty.empresa.TelaLoginEmpresa;
import com.example.app_infobeauty.empresa.TelaNavegacaoEmpresa;


public class TelaLoginUsuario extends AppCompatActivity {

    EditText emailLogin, senhaLogin;
    Button btnLoginUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_usuario);


        emailLogin = (EditText) findViewById(R.id.editTextEmailUsuario);
        senhaLogin = (EditText) findViewById(R.id.editTextSenhaUsuario);


    }

    public void login_usuario(View v){
        String loginEmail, loginSenha;

        loginEmail = emailLogin.getText().toString();
        loginSenha = senhaLogin.getText().toString();

        if(loginEmail.equals("")){
            Toast.makeText(TelaLoginUsuario.this, "Email não inserido, tente novamente", Toast.LENGTH_SHORT).show();
        }else if(loginSenha.equals("")){
            Toast.makeText(TelaLoginUsuario.this, "Senha não inserido, tente novamente", Toast.LENGTH_SHORT).show();
        }else{

            UsuarioDAO dao = new UsuarioDAO(TelaLoginUsuario.this);
            dao.open();
            String res = dao.login_usuario(loginEmail, loginSenha);

            if(res.equals("OK")){
                Toast.makeText(TelaLoginUsuario.this, "Login efetuado com sucesso ✓", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TelaLoginUsuario.this, TelaNavegacaoCliente.class);
                startActivity(intent);
            }else{
                Toast.makeText(TelaLoginUsuario.this, "Usuário ou senha incorreta", Toast.LENGTH_SHORT).show();
            }
        }
    }

}