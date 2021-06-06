package com.example.app_infobeauty.empresa;

import java.util.ArrayList ;
import java.util.List ;
import android.content.ContentValues ;
import android.content.Context ;
import android.database.Cursor ;
import android.database.SQLException ;
import android.database.sqlite.SQLiteDatabase ;

import com.example.app_infobeauty.InfoBeautySQLiteOpenHelper;

public class EmpresaDAO {


    // banco
    private SQLiteDatabase database;
    //colunas da tabela
    private String [] columns = {
            InfoBeautySQLiteOpenHelper.COLUNA_ID ,
            InfoBeautySQLiteOpenHelper.COLUNA_NOME ,
            InfoBeautySQLiteOpenHelper.COLUNA_EMAIL ,
            InfoBeautySQLiteOpenHelper.COLUNA_CNPJ ,
            InfoBeautySQLiteOpenHelper.COLUNA_SENHA,
            InfoBeautySQLiteOpenHelper.COLUNA_CONFIRMASENHA,

    };
    private InfoBeautySQLiteOpenHelper sqliteOpenHelper;
    // construtor
    public EmpresaDAO(Context context) {
        sqliteOpenHelper = new InfoBeautySQLiteOpenHelper(context);
    }
    // abrir conexão
    public void open() throws SQLException {
        database = sqliteOpenHelper.getWritableDatabase();
    }
    // fechar conexão
    public void close() {
        sqliteOpenHelper.close();
    }
    // inclusão
    public void inserir(String nome, String email, String cnpj, String senha, String confirmasenha) {
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME, nome);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_EMAIL, email);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_CNPJ, cnpj);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_SENHA, senha);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_CONFIRMASENHA, confirmasenha);
        long insertId = database.insert(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA, null, values);
    }
    // alteração
    public void alterar(long id, String nome, String email, String cnpj, String senha, String confirmasenha) {
        // prepara os dados para a atualização
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME, nome);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_EMAIL, email);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_CNPJ, cnpj);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_SENHA, senha);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_CONFIRMASENHA, confirmasenha);
        database.update(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA, values, InfoBeautySQLiteOpenHelper.COLUNA_ID + "=" + id, null);
    }
    // exclusão
    public void apagar(long id) {
        database.delete(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA, InfoBeautySQLiteOpenHelper.COLUNA_ID + "=" + id, null);
    }
    //busca
    public Empresa buscar(long id) {
        Cursor cursor = database.query(InfoBeautySQLiteOpenHelper.TABELA_EMPRESA,
                columns, InfoBeautySQLiteOpenHelper.COLUNA_ID + " = " + id, null,null, null, null);
        cursor.moveToFirst();
        Empresa empresa = new Empresa();
        empresa.setId(cursor.getLong(0));
        empresa.setNome(cursor.getString(1));
        empresa.setEmail(cursor.getString(2));
        empresa.setCnpj(cursor.getString(3));
        empresa.setSenha(cursor.getString(4));
        empresa.setConfirmasenha(cursor.getString(5));
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
            empresa.setId(cursor.getLong(0));
            empresa.setNome(cursor.getString(1));
            empresa.setEmail(cursor.getString(2));
            empresa.setCnpj(cursor.getString(3));
            empresa.setSenha(cursor.getString(4));
            empresa.setConfirmasenha(cursor.getString(5));
            empresas.add(empresa);
            cursor.moveToNext();
        }
        // fecha o cursor
        cursor.close();
        // retorna a lista com as disciplinas
        return empresas;
    }

}