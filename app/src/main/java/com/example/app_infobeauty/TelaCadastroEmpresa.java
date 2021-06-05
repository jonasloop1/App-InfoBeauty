package com.example.app_infobeauty;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class TelaCadastroEmpresa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_empresa);

        Button btnSalvar_E = (Button)findViewById(R.id.proximoEmpresaCadastro);
        btnSalvar_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //carregando os campos
                EditText txtNome_E = (EditText)findViewById(R.id.nomeEmpresa);
                EditText txtEmail_E = (EditText)findViewById(R.id.emailEmpresa);
                EditText txtCnpj_E = (EditText)findViewById(R.id.cnpjEmpresa);
                EditText txtSenha_E = (EditText)findViewById(R.id.senhaEmpresa);
                EditText txtConfirmaSenha_E = (EditText)findViewById(R.id.confirmasenhaEmpresa);

                //pegando os valores
                String nome_E = txtNome_E.getText().toString();
                String email_E = txtEmail_E.getText().toString();
                String cnpj_E = txtCnpj_E.getText().toString();
                String senha_E = txtSenha_E.getText().toString();
                String confirmasenha_E = txtConfirmaSenha_E.getText().toString();

                //salvando os dados
                EmpresaDAO dao = new EmpresaDAO(getBaseContext());
                boolean sucesso_E = dao.salvar_E(nome_E, email_E, cnpj_E, senha_E, confirmasenha_E);
                if(sucesso_E) {
                    //limpa os campos
                    txtNome_E.setText("");
                    txtEmail_E.setText("");
                    txtCnpj_E.setText("");
                    txtSenha_E.setText("");
                    txtConfirmaSenha_E.setText("");


                    AlertDialog.Builder alerta = new AlertDialog.Builder(TelaCadastroEmpresa.this);
                    alerta.setTitle("Aviso");
                    alerta

                            .setIcon(R.drawable.ic_baseline_check_circle_24)
                            .setMessage("Cadastro feito com Sucesso!")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "OK escolhido", Toast.LENGTH_SHORT).show();
                                }
                            });
                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();


                }else{ }
            }
        });

    }

    public static class Empresa implements Serializable {

        private int id_E;
        private String nome_E;
        private String email_E;
        private String cnpj_E;
        private String senha_E;
        private String confirmasenha_E;

        public Empresa(int id_E, String nome_E, String email_E,String cnpj_E ,String senha_E, String confirmasenha_E){
            this.id_E = id_E;
            this.nome_E = nome_E;
            this.email_E = email_E;
            this.cnpj_E = cnpj_E;
            this.senha_E = senha_E;
            this.confirmasenha_E = confirmasenha_E;
        }

        public int getId_E(){ return this.id_E; }
        public String getNome_E(){ return this.nome_E; }
        public String getEmail_E(){ return this.email_E; }
        public String getCnpj_E(){ return this.cnpj_E; }
        public String getSenha_E(){ return this.senha_E; }
        public String getConfirmasenha_E(){ return this.confirmasenha_E; }

        @Override
        public boolean equals(Object o){
            return this.id_E == ((Empresa)o).id_E;
        }

        @Override
        public int hashCode(){
            return this.id_E;
        }
    }
}