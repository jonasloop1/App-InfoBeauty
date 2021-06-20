package com.example.app_infobeauty.empresa;

public class Empresa {

    private long id_empresa;
    private String nome_empresa,endereco_empresa, email_empresa, cnpj_empresa, senha_empresa;


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

    public String getEndereco_empresa() {
        return endereco_empresa;
    }

    public void setEndereco_empresa(String endereco_empresa) {
        if (!endereco_empresa.isEmpty()) {
            this.endereco_empresa = endereco_empresa;
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

    // método construtor com definição dos valores padrão
    public Empresa() {
        nome_empresa = "";
        email_empresa = "";
        cnpj_empresa = "";
    }

    // método de formatação dos dados para exibição na lista
    public String textoLista() {
        String item;
        item = "Nome do estabelecimento: "+getNome_empresa();
        item += "\nEndereço: " +getEndereco_empresa();
        return item;
    }
}
