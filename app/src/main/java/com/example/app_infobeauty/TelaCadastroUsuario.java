package com.example.app_infobeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

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

                //salvando os dados
                UsuarioDAO dao = new UsuarioDAO(getBaseContext());
                boolean sucesso = dao.salvar(nome, email, senha);
                if(sucesso) {
                    //limpa os campos
                    txtNome.setText("");
                    txtEmail.setText("");
                    txtSenha.setText("");

                    Snackbar.make(view, "Salvou!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Snackbar.make(view, "Erro ao salvar, consulte os logs!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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