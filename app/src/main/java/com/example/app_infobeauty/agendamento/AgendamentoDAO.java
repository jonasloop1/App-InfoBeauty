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
    public void inserir_empresa( String nome_empresa, String endereco_empresa,String email_empresa, String cnpj_empresa, String senha_empresa) {
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME_EMPRESA, nome_empresa);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_ENDERECO_EMPRESA, endereco_empresa);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_EMAIL_EMPRESA, email_empresa);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_CNPJ_EMPRESA, cnpj_empresa);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_SENHA_EMPRESA, senha_empresa);
        long insertId_empresa = database.insert(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA, null, values);
    }

    // alteração
    public void alterar_empresa(long id, String nome,String endereco_empresa ,String email, String cnpj, String senha) {
        // prepara os dados para a atualização
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME_EMPRESA, nome);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_ENDERECO_EMPRESA, endereco_empresa);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_EMAIL_EMPRESA, email);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_CNPJ_EMPRESA, cnpj);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_SENHA_EMPRESA, senha);
        database.update(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA, values, InfoBeautySQLiteOpenHelper.COLUNA_ID_EMPRESA + "=" + id, null);
    }
    // exclusão
    public void apagar_empresa(long id) {
        database.delete(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA, InfoBeautySQLiteOpenHelper.COLUNA_ID_EMPRESA + "=" + id, null);
    }
    //busca
    public Empresa buscar_empresa(long id) {
        Cursor cursor = database.query(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA,
                columns, InfoBeautySQLiteOpenHelper.COLUNA_ID_EMPRESA + " = " + id, null,null, null, null);
        cursor.moveToFirst();
        Empresa empresa = new Empresa();
        empresa.setId_empresa(cursor.getLong(0));
        empresa.setNome_empresa(cursor.getString(1));
        empresa.setEndereco_empresa(cursor.getString(2));
        empresa.setEmail_empresa(cursor.getString(3));
        empresa.setCnpj_empresa(cursor.getString(4));
        empresa.setSenha_empresa(cursor.getString(5));
        cursor.close();
        return empresa;
    }
    // criação da lista de itens para a ListaView da tela principal
    public List<Empresa> getAll() {
        List<Empresa> empresas = new ArrayList<Empresa>();
        Cursor cursor = database.query(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA, columns, null, null, null, null, null);
        // confirma o ponteiro do arquivo na primeira posição da tabela
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {// pega cada elemento da tabela e insere na lista
            Empresa empresa = new Empresa();
            empresa.setId_empresa(cursor.getLong(0));
            empresa.setNome_empresa(cursor.getString(1));
            empresa.setEndereco_empresa(cursor.getString(2));
            empresa.setEmail_empresa(cursor.getString(3));
            empresa.setCnpj_empresa(cursor.getString(4));
            empresa.setSenha_empresa(cursor.getString(5));
            empresas.add(empresa);
            cursor.moveToNext();
        }
        // fecha o cursor
        cursor.close();
        // retorna a lista com as disciplinas
        return empresas;
    }
}