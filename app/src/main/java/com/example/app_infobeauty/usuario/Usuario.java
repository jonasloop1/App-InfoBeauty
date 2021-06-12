package com.example.app_infobeauty.usuario;

public class Usuario {

    private long id_usuario;
    private String nome_usuario, email_usuario, cpf_usuario, senha_usuario, confirmasenha_usuario;


    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        if (!nome_usuario.isEmpty()) {
            this.nome_usuario = nome_usuario;
        }
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        if (!email_usuario.isEmpty()) {
            this.email_usuario = email_usuario;
        }
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        if (!cpf_usuario.isEmpty()) {
            this.cpf_usuario = cpf_usuario;
        }
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        if (!senha_usuario.isEmpty()) {
            this.senha_usuario = senha_usuario;
        }
    }

    public String getConfirmasenha_usuario() {
        return confirmasenha_usuario;
    }

    public void setConfirmasenha_usuario(String confirmasenha_usuario) {
        if (!confirmasenha_usuario.isEmpty()) {
            this.confirmasenha_usuario = confirmasenha_usuario;
        }
    }

    // método construtor com definição dos valores padrão
    public Usuario() {
        nome_usuario = "";
        email_usuario = "";
        cpf_usuario = "";
    }

    // método de formatação dos dados para exibição na lista
    public String textoLista() {
        String item;
        item = "Nome do Usuario: "+getNome_usuario();
        item += "\nEmail: " + getEmail_usuario();
        return item;
    }
}
