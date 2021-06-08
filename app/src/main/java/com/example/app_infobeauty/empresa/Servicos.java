package com.example.app_infobeauty.empresa;

public class Servicos {

    private long id_servicos;
    private String nome_funcionario, nome_servicos, horario_servicos;


    public long getId_servicos(){
        return id_servicos;
    }

    public void setId_servicos(long id_servicos){
        this.id_servicos = id_servicos;
    }

    public String getNome_funcionario(){
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        if (!nome_funcionario.isEmpty()) {
            this.nome_funcionario = nome_funcionario;
        }
    }

    public String getNome_servicos(){
        return nome_servicos;
    }

    public void setNome_servicos(String nome_servicos) {
        if (!nome_servicos.isEmpty()) {
            this.nome_servicos = nome_servicos;
        }
    }

    public String getHorario_servicos(){
        return horario_servicos;
    }

    public void setHorario_servicos(String horario_servicos) {
        if (!horario_servicos.isEmpty()) {
            this.horario_servicos = horario_servicos;
        }
    }

    // método construtor com definição dos valores padrão
    public Servicos() {
        nome_funcionario = "";
        nome_servicos = "";
        horario_servicos = "";
    }

    // método de formatação dos dados para exibição na lista
    public String textoLista() {
        String item;
        item = "Funcionários: " +getNome_funcionario();
        item += "\nServiços: " +getNome_servicos();
        item += "\nHorários: " +getHorario_servicos();
        return item;
    }

}
