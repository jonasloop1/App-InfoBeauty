package com.example.app_infobeauty.usuario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.app_infobeauty.R;

public class TelaCadastroUsuario extends AppCompatActivity {

    EditText nomeUsuario, emailUsuario, cpfUsuario, senhaUsuario,confirmasenhaUsuario;
    Button cadastroUsuario;

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

    }

    private void validaCampos(){

        boolean res = false;

        String nome_U = nomeUsuario.getText().toString();
        String email_U = emailUsuario.getText().toString();
        String cpf_U = cpfUsuario.getText().toString();
        String senha_U = senhaUsuario.getText().toString();
        String confirmasenha_U = confirmasenhaUsuario.getText().toString();

        if (res = isCampoVazio(nome_U)){
            nomeUsuario.requestFocus();
        }
        else
        if (res = isEmailValido(email_U)){
            emailUsuario.requestFocus();
        }
        else
        if (res = isCampoVazio(cpf_U)){
            cpfUsuario.requestFocus();
        }
        else
        if (res = isCampoVazio(senha_U)){
            senhaUsuario.requestFocus();
        }
        else
        if (res = isCampoVazio(confirmasenha_U)){
            confirmasenhaUsuario.requestFocus();
        }
        if (res){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Aviso");
            dlg.setMessage("Há campos inválidos ou em branco!");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }



    }

    private boolean isCampoVazio (String valor){

        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty() );
        return resultado;
    }

    private boolean isEmailValido (String email_U){

        boolean resultado = (isCampoVazio(email_U) && Patterns.EMAIL_ADDRESS.matcher(email_U).matches());
        return resultado;
    }


    public void Inserir_usuario (View v){
        validaCampos();
        String nome_usuario, email_usuario, cpf_usuario, senha_usuario, confirmasenha_usuario;
        nome_usuario = nomeUsuario.getText().toString();
        email_usuario = emailUsuario.getText().toString();
        cpf_usuario = cpfUsuario.getText().toString();
        senha_usuario = senhaUsuario.getText().toString();
        confirmasenha_usuario = confirmasenhaUsuario.getText().toString();
        UsuarioDAO dao = new UsuarioDAO(this);
        dao.open();
        dao.inserir_usuario(nome_usuario, email_usuario, cpf_usuario, senha_usuario, confirmasenha_usuario);
        //Intent intent = new Intent(getApplicationContext(), TelaNavegacaoCliente.class);
        //startActivity(intent);

    }

}