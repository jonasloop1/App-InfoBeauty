package com.example.app_infobeauty.empresa;

public class Empresa {

        private long id;
        private String nome,email,cnpj,senha,confirmasenha;


        public long getId(){
            return id;
        }

        public void setId(long id){
            this.id = id;
        }

        public String getNome(){
            return nome;
        }

        public void setNome(String nome) {
            if (!nome.isEmpty()) {
                this.nome = nome;
            }
        }

        public String getEmail(){
            return email;
        }

        public void setEmail(String email) {
            if (!email.isEmpty()) {
                this.email = email;
            }
        }

        public String getCnpj(){
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            if (!cnpj.isEmpty()) {
                this.cnpj = cnpj;
            }
        }

        public String getSenha(){
            return senha;
        }

        public void setSenha(String senha) {
            if (!senha.isEmpty()) {
                this.senha = senha;
            }
        }

        public String getConfirmasenha(){
            return confirmasenha;
        }

        public void setConfirmasenha(String confirmasenha) {
            if (!confirmasenha.isEmpty()) {
                this.confirmasenha = confirmasenha;
            }
        }

        // método construtor com definição dos valores padrão
        public Empresa() {
            nome = "Nome Empresa";
            email = "Email Empresa";
            cnpj = "Cnpj Empresa";
        }

        // método de formatação dos dados para exibição na lista
        public String textoLista() {
            String item;
            item = getNome();
            item = getEmail();
            item = getCnpj();
            return item;
        }
    }
