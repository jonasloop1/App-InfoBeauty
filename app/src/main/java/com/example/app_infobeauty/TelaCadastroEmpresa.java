package com.example.app_infobeauty;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

        Button btnSalvar_E = (Button)findViewById(R.id.cadastrarEmpresa);
        btnSalvar_E.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //carregando os campos
                EditText txtNome_E = (EditText)findViewById(R.id.nomeEmpresa);
                EditText txtEmail_E = (EditText)findViewById(R.id.emailEmpresa);
                EditText txtSenha_E = (EditText)findViewById(R.id.senhaEmpresa);

                //pegando os valores
                String nome_E = txtNome_E.getText().toString();
                String email_E = txtEmail_E.getText().toString();
                String senha_E = txtSenha_E.getText().toString();

                //if (email.equals("") || senha.equals("")|| nome.equals("")){
                //  Toast.makeText(getApplicationContext(), "Fields are Empty", Toast.LENGTH_SHORT).show();
                // }
                // else{
                //   if (senha.equals(nome)){
                //Boolean chkemail = db.chkemail(email);
                //if (chkemail==)
                //}
                //}

                //salvando os dados
                EmpresaDAO dao = new EmpresaDAO(getBaseContext());
                boolean sucesso_E = dao.salvar_E(nome_E, email_E, senha_E);
                if(sucesso_E) {
                    //limpa os campos
                    txtNome_E.setText("");
                    txtEmail_E.setText("");
                    txtSenha_E.setText("");

                    AlertDialog.Builder alerta = new AlertDialog.Builder(TelaCadastroEmpresa.this);
                    alerta.setTitle("Aviso");
                    alerta

                            .setIcon(R.drawable.ic_baseline_check_circle_24)
                            .setMessage("Cadastro feito com Sucesso!")
                            .setPositiveButton ("OK", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    Toast.makeText(getApplicationContext(), "OK escolhido", Toast.LENGTH_SHORT).show();

                                }
                            });
                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();


                }else{

                    AlertDialog.Builder alerta = new AlertDialog.Builder(TelaCadastroEmpresa.this);
                    alerta.setTitle("Aviso");
                    alerta

                            .setIcon(R.drawable.ic_baseline_error_24)
                            .setMessage("Cadastro feito com Sucesso!")
                            .setCancelable(true)
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    Toast.makeText(getApplicationContext(), "Cancelar escolhido", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setPositiveButton ("OK", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    Toast.makeText(getApplicationContext(), "OK escolhido", Toast.LENGTH_SHORT).show();
                                }
                            });
                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();
                }
            }
        });

    }
    public static class Empresa implements Serializable {

        private int id_E;
        private String nome_E;
        private String email_E;
        private String senha_E;

        public Empresa(int id_E, String nome_E, String email_E, String senha_E){
            this.id_E = id_E;
            this.nome_E= nome_E;
            this.email_E = email_E;
            this.senha_E = senha_E;
        }

        public int getId(){ return this.id_E; }
        public String getNome_E(){ return this.nome_E; }
        public String getEmail_E(){ return this.email_E; }
        public String getSenha_E(){ return this.senha_E; }

        @Override
        public boolean equals(Object o){
            return this.id_E == ((TelaCadastroEmpresa.Empresa)o).id_E;
        }

        @Override
        public int hashCode(){
            return this.id_E;
        }
    }
}