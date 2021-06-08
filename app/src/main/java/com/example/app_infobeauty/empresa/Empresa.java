package com.example.app_infobeauty.empresa;

public class Empresa {

    private long id_empresa;
    private String nome_empresa, email_empresa, cnpj_empresa, senha_empresa, confirmasenha_empresa;


    public long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        if (!nome_empresa.isEmpty()) {
            this.nome_empresa = nome_empresa;
        }
    }

    public String getEmail_empresa() {
        return email_empresa;
    }

    public void setEmail_empresa(String email_empresa) {
        if (!email_empresa.isEmpty()) {
            this.email_empresa = email_empresa;
        }
    }

    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(String cnpj_empresa) {
        if (!cnpj_empresa.isEmpty()) {
            this.cnpj_empresa = cnpj_empresa;
        }
    }

    public String getSenha_empresa() {
        return senha_empresa;
    }

    public void setSenha_empresa(String senha_empresa) {
        if (!senha_empresa.isEmpty()) {
            this.senha_empresa = senha_empresa;
        }
    }

    public String getConfirmasenha_empresa() {
        return confirmasenha_empresa;
    }

    public void setConfirmasenha_empresa(String confirmasenha_empresa) {
        if (!confirmasenha_empresa.isEmpty()) {
            this.confirmasenha_empresa = confirmasenha_empresa;
        }
    }

    // método construtor com definição dos valores padrão
    public Empresa() {
        nome_empresa = "Nome Empresa";
        email_empresa = "Email Empresa";
        cnpj_empresa = "Cnpj Empresa";
    }

    // método de formatação dos dados para exibição na lista
    public String textoLista() {
        String item;
        item = getNome_empresa();
        item = getEmail_empresa();
        item = getCnpj_empresa();
        return item;
    }
}
