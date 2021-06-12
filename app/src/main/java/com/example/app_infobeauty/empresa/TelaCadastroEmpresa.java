package com.example.app_infobeauty.empresa;


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

import java.util.regex.Pattern;

public class TelaCadastroEmpresa extends AppCompatActivity {

    EditText nomeEmpresa, emailEmpresa, cnpjEmpresa, senhaEmpresa,confirmasenhaEmpresa;
    Button proximoEmpresaCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_empresa);

        proximoEmpresaCadastro = (Button) findViewById(R.id.proximoEmpresaCadastro);
        nomeEmpresa = (EditText) findViewById(R.id.nomeEmpresa);
        emailEmpresa = (EditText) findViewById(R.id.emailEmpresa);
        cnpjEmpresa = (EditText) findViewById(R.id.cnpjEmpresa);
        senhaEmpresa = (EditText) findViewById(R.id.senhaEmpresa);
        confirmasenhaEmpresa = (EditText) findViewById(R.id.confirmasenhaEmpresa);

    }
    private void validaCampos(){

        boolean res = false;

        String nome_E = nomeEmpresa.getText().toString();
        String email_E = emailEmpresa.getText().toString();
        String cnpj_E = cnpjEmpresa.getText().toString();
        String senha_E = senhaEmpresa.getText().toString();
        String confirmasenha_E = confirmasenhaEmpresa.getText().toString();

        if (res = isCampoVazio(nome_E)){
            nomeEmpresa.requestFocus();
        }
        else
            if (res = isEmailValido(email_E)){
                emailEmpresa.requestFocus();
            }
            else
                if (res = isCampoVazio(cnpj_E)){
                cnpjEmpresa.requestFocus();
                }
                else
                    if (res = isCampoVazio(senha_E)){
                    senhaEmpresa.requestFocus();
                    }
                    else
                        if (res = isCampoVazio(confirmasenha_E)){
                        confirmasenhaEmpresa.requestFocus();
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

    private boolean isEmailValido (String email_E){

        boolean resultado = (isCampoVazio(email_E) && Patterns.EMAIL_ADDRESS.matcher(email_E).matches());
        return resultado;
    }


        public void Inserir_empresa (View v){
            validaCampos();
            String nome_empresa, email_empresa, cnpj_empresa, senha_empresa, confirmasenha_empresa;
            nome_empresa = nomeEmpresa.getText().toString();
            email_empresa = emailEmpresa.getText().toString();
            cnpj_empresa = cnpjEmpresa.getText().toString();
            senha_empresa = senhaEmpresa.getText().toString();
            confirmasenha_empresa = confirmasenhaEmpresa.getText().toString();
            EmpresaDAO dao = new EmpresaDAO(this);
            dao.open();
            dao.inserir_empresa(nome_empresa, email_empresa, cnpj_empresa, senha_empresa, confirmasenha_empresa);
            Intent intent = new Intent(getApplicationContext(), ServicosEmpresas.class);
            startActivity(intent);

        }
    }
