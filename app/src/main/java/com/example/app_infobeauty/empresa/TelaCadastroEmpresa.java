package com.example.app_infobeauty.empresa;

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

public class TelaCadastroEmpresa extends AppCompatActivity {

    EditText nomeEmpresa, emailEmpresa,enderecoEmpresa, cnpjEmpresa, senhaEmpresa,confirmasenhaEmpresa;
    Button proximoEmpresaCadastro;
    SharedPreferences prefsEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_empresa);


        proximoEmpresaCadastro = (Button) findViewById(R.id.ProximoEmpresaCadastrar);
        nomeEmpresa = (EditText) findViewById(R.id.nomeEmpresa);
        enderecoEmpresa = (EditText) findViewById(R.id.enderecoEmpresa);
        emailEmpresa = (EditText) findViewById(R.id.emailEmpresa);
        cnpjEmpresa = (EditText) findViewById(R.id.cnpjEmpresa);
        senhaEmpresa = (EditText) findViewById(R.id.senhaEmpresa);
        confirmasenhaEmpresa = (EditText) findViewById(R.id.confirmasenhaEmpresa);

        cnpjEmpresa.addTextChangedListener(MaskEditUtil.mask(cnpjEmpresa, MaskEditUtil.FORMAT_CNPJ));
        prefsEmpresa = getSharedPreferences("MyPrefsEmpresa", Context.MODE_PRIVATE);

        proximoEmpresaCadastro.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String nome_empresa, email_empresa, cnpj_empresa, senha_empresa,confirmasenha_empresa,endereco_empresa;
                nome_empresa = nomeEmpresa.getText().toString();
                email_empresa = emailEmpresa.getText().toString();
                endereco_empresa = enderecoEmpresa.getText().toString();
                cnpj_empresa = cnpjEmpresa.getText().toString();
                senha_empresa = senhaEmpresa.getText().toString();
                confirmasenha_empresa = confirmasenhaEmpresa.getText().toString();

                SharedPreferences.Editor editorE = prefsEmpresa.edit();

                editorE.putString("NomeEmpresa", nome_empresa);
                editorE.putString("EndereçoEmpresa", endereco_empresa);
                editorE.putString("EmailEmpresa", email_empresa);
                editorE.putString("Cnpj", cnpj_empresa);
                editorE.commit();



                if (nome_empresa.equals("")){
                    Toast.makeText(TelaCadastroEmpresa.this, "Preencha o Nome do Estabelecimento Por favor!", Toast.LENGTH_SHORT).show();
                }
                else if (endereco_empresa.equals("")){
                    Toast.makeText(TelaCadastroEmpresa.this, "Preencha o Endereço Por favor!", Toast.LENGTH_SHORT).show();
                }
                else if (email_empresa.equals("")){
                    Toast.makeText(TelaCadastroEmpresa.this, "Preencha o Email Por favor!", Toast.LENGTH_SHORT).show();
                }
                else if (cnpj_empresa.equals("")){
                    Toast.makeText(TelaCadastroEmpresa.this, "Preencha o Cnpj Por favor!", Toast.LENGTH_SHORT).show();
                }
                else if (senha_empresa.equals("") || confirmasenha_empresa.equals("")){
                    Toast.makeText(TelaCadastroEmpresa.this, "Por Favor Preencha a senha corretamente!", Toast.LENGTH_SHORT).show();
                }
                else if (!senha_empresa.equals(confirmasenha_empresa)){
                    Toast.makeText(TelaCadastroEmpresa.this, "As senhas não correspondem!", Toast.LENGTH_SHORT).show();
                }else {

                    EmpresaDAO dao = new EmpresaDAO(TelaCadastroEmpresa.this);
                    dao.open();
                    dao.inserir_empresa(nome_empresa,endereco_empresa, email_empresa, cnpj_empresa, senha_empresa);
                    Intent intent1 = new Intent(getApplicationContext(), ServicosEmpresas.class);
                    startActivity(intent1);
                }
            }
        });
    }
}