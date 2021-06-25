package com.example.app_infobeauty.agendamento;

public class Agendamento {

    private long id_agendamento;
    private String servicos_spinner, data_calendario, horario_agendamento;


    public long getId_agendamento() {
        return id_agendamento;
    }

    public void setId_agendamento(long id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public String getServicos_spinner() {
        return servicos_spinner;
    }

    public void setServicos_spinner(String servicos_spinner) {
        if (!servicos_spinner.isEmpty()) {
            this.servicos_spinner = servicos_spinner;
        }
    }

    public String getData_calendario() {
        return data_calendario;
    }

    public void setData_calendario(String data_calendario) {
        if (!data_calendario.isEmpty()) {
            this.data_calendario = data_calendario;
        }
    }

    public String getHorario_agendamento() {
        return horario_agendamento;
    }

    public void setHorario_agendamento(String horario_agendamento) {
        if (!horario_agendamento.isEmpty()) {
            this.horario_agendamento = horario_agendamento;
        }
    }

    // método de formatação dos dados para exibição na lista
    public String textoLista() {
        String item;
        item = "Agendamento feito por: ";
        item += "\nHorário: " + getHorario_agendamento();
        item += "\nServiços: " + getServicos_spinner();
        return item;
    }
}