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

public class TelaCadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_usuario);

        Button btnSalvar = (Button)findViewById(R.id.cadastrarUsuario);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //carregando os campos
                EditText txtNome = (EditText)findViewById(R.id.nomeUsuario);
                EditText txtEmail = (EditText)findViewById(R.id.emailUsuario);
                EditText txtSenha = (EditText)findViewById(R.id.senhaUsuario);

                //pegando os valores
                String nome = txtNome.getText().toString();
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

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
                UsuarioDAO dao = new UsuarioDAO(getBaseContext());
                boolean sucesso = dao.salvar(nome, email, senha);
                if(sucesso) {
                    //limpa os campos
                    txtNome.setText("");
                    txtEmail.setText("");
                    txtSenha.setText("");

                    AlertDialog.Builder alerta = new AlertDialog.Builder(TelaCadastroUsuario.this);
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

                    AlertDialog.Builder alerta = new AlertDialog.Builder(TelaCadastroUsuario.this);
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
    public static class Usuario implements Serializable {

        private int id;
        private String nome;
        private String email;
        private String senha;

        public Usuario(int id, String nome, String email, String senha){
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.senha = senha;
        }

        public int getId(){ return this.id; }
        public String getNome(){ return this.nome; }
        public String getEmail(){ return this.email; }
        public String getSenha(){ return this.senha; }

        @Override
        public boolean equals(Object o){
            return this.id == ((Usuario)o).id;
        }

        @Override
        public int hashCode(){
            return this.id;
        }
    }
}