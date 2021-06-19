package com.example.app_infobeauty.agendamento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.app_infobeauty.InfoBeautySQLiteOpenHelper;
import com.example.app_infobeauty.empresa.Empresa;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    private SQLiteDatabase database;
    //colunas da tabela
    private String [] columns = {
            InfoBeautySQLiteOpenHelper.COLUNA_ID_AGENDAMENTO ,
            InfoBeautySQLiteOpenHelper.COLUNA_SERVICOS_SPINNER ,
            InfoBeautySQLiteOpenHelper.COLUNA_DATA_CALENDARIO ,
            InfoBeautySQLiteOpenHelper.COLUNA_HORARIO_AGENDAMENTO ,
    };

    private InfoBeautySQLiteOpenHelper sqliteOpenHelper;

    public AgendamentoDAO(Context context) {
        sqliteOpenHelper = new InfoBeautySQLiteOpenHelper(context);
    }

    public void open() throws SQLException {
        database = sqliteOpenHelper.getWritableDatabase();
    }

    public void close() {
        sqliteOpenHelper.close();
    }
    // inclusão
    public void inserir_agendamento( String servicos_spinner, String data_calendario,String horario_agendamento) {
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_SERVICOS_SPINNER, servicos_spinner);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_DATA_CALENDARIO, data_calendario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_HORARIO_AGENDAMENTO, horario_agendamento);
        long insertId_agendamento = database.insert(InfoBeautySQLiteOpenHelper.TABELA_AGENDAMENTO, null, values);
    }

    // alteração
    public void alterar_agendamento(long id, String servicos_spinner, String data_calendario,String horario_agendamento) {
        // prepara os dados para a atualização
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_SERVICOS_SPINNER, servicos_spinner);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_DATA_CALENDARIO, data_calendario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_HORARIO_AGENDAMENTO, horario_agendamento);
        database.update(InfoBeautySQLiteOpenHelper.TABELA_AGENDAMENTO, values, InfoBeautySQLiteOpenHelper.COLUNA_ID_AGENDAMENTO + "=" + id, null);
    }
    // exclusão
    public void apagar_agendamento(long id) {
        database.delete(InfoBeautySQLiteOpenHelper.TABELA_AGENDAMENTO, InfoBeautySQLiteOpenHelper.COLUNA_ID_AGENDAMENTO + "=" + id, null);
    }
    //busca
    public Agendamento buscar_agendamento(long id) {
        Cursor cursor = database.query(InfoBeautySQLiteOpenHelper.TABELA_AGENDAMENTO,
                columns, InfoBeautySQLiteOpenHelper.COLUNA_ID_AGENDAMENTO + " = " + id, null,null, null, null);
        cursor.moveToFirst();
        Agendamento agendamento = new Agendamento();
        agendamento.setId_agendamento(cursor.getLong(0));
        agendamento.setServicos_spinner(cursor.getString(1));
        agendamento.setData_calendario(cursor.getString(2));
        agendamento.setHorario_agendamento(cursor.getString(3));
        cursor.close();
        return agendamento;
    }
    // criação da lista de itens para a ListaView da tela principal
    public List<Agendamento> getAll() {
        List<Agendamento> agendamentos = new ArrayList<Agendamento>();
        Cursor cursor = database.query(InfoBeautySQLiteOpenHelper.TABELA_AGENDAMENTO, columns, null, null, null, null, null);
        // confirma o ponteiro do arquivo na primeira posição da tabela
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {// pega cada elemento da tabela e insere na lista
            Agendamento agendamento = new Agendamento();
            agendamento.setId_agendamento(cursor.getLong(0));
            agendamento.setServicos_spinner(cursor.getString(1));
            agendamento.setData_calendario(cursor.getString(2));
            agendamento.setHorario_agendamento(cursor.getString(3));
            agendamentos.add(agendamento);
            cursor.moveToNext();
        }
        // fecha o cursor
        cursor.close();
        // retorna a lista com as disciplinas
        return agendamentos;
    }
}