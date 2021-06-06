package com.example.app_infobeauty.empresa;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_infobeauty.InfoBeautySQLiteOpenHelper;

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
        long insertId = database.insert(InfoBeautySQLiteOpenHelper.TABELA_SERVICOS, null, values);
    }
}
