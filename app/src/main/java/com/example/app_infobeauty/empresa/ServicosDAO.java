package com.example.app_infobeauty.empresa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_infobeauty.InfoBeautySQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ServicosDAO {

    private SQLiteDatabase database;

    private String [] servicos = {
            InfoBeautySQLiteOpenHelper.COLUNA_ID_SERVICOS ,
            InfoBeautySQLiteOpenHelper.COLUNA_NOME_FUNCIONARIO ,
            InfoBeautySQLiteOpenHelper.COLUNA_NOME_SERVICOS ,
            InfoBeautySQLiteOpenHelper.COLUNA_HORARIO_SERVICOS ,

    };

    private InfoBeautySQLiteOpenHelper sqliteOpenHelper;

    public ServicosDAO(Context context) {
        sqliteOpenHelper = new InfoBeautySQLiteOpenHelper(context);
    }

    public void open() throws SQLException {
        database = sqliteOpenHelper.getWritableDatabase();
    }

    public void close() {
        sqliteOpenHelper.close();
    }

    public void inserir_servicos(String nome_funcionario, String nome_servicos, String horario_servicos) {
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME_FUNCIONARIO, nome_funcionario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME_SERVICOS, nome_servicos);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_HORARIO_SERVICOS, horario_servicos);
        long insertId_servicos = database.insert(InfoBeautySQLiteOpenHelper.TABELA_SERVICOS, null, values);
    }
    // alteração
    public void alterar(long id, String nome_funcionario, String nome_servicos, String horario_servicos) {
        // prepara os dados para a atualização
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME_FUNCIONARIO, nome_funcionario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME_SERVICOS, nome_servicos);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_HORARIO_SERVICOS, horario_servicos);
        database.update(InfoBeautySQLiteOpenHelper.TABELA_SERVICOS, values, InfoBeautySQLiteOpenHelper.COLUNA_ID_SERVICOS + "=" + id, null);
    }
    // exclusão
    public void apagar(long id) {
        database.delete(InfoBeautySQLiteOpenHelper.TABELA_SERVICOS, InfoBeautySQLiteOpenHelper.COLUNA_ID_SERVICOS + "=" + id, null);
    }
    // criação da lista de itens para a ListaView da tela principal
    public List<Servicos> getAll() {
        List<Servicos> servicosArrayList = new ArrayList<Servicos>();
        Cursor cursor = database.query(InfoBeautySQLiteOpenHelper.TABELA_SERVICOS, servicos, null, null, null, null, null);
        // confirma o ponteiro do arquivo na primeira posição da tabela
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {// pega cada elemento da tabela e insere na lista
            Servicos servicoss = new Servicos();
            servicoss.setId_servicos(cursor.getLong(0));
            servicoss.setNome_funcionario(cursor.getString(1));
            servicoss.setNome_servicos(cursor.getString(2));
            servicoss.setHorario_servicos(cursor.getString(3));
            servicosArrayList.add(servicoss);
            cursor.moveToNext();
        }
        // fecha o cursor
        cursor.close();
        // retorna a lista com as disciplinas
        return servicosArrayList;
    }
}
