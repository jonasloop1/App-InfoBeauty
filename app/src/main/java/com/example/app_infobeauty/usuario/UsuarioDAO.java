package com.example.app_infobeauty.usuario;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_infobeauty.InfoBeautySQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // banco
    private SQLiteDatabase database;
    private SQLiteDatabase database1;
    //colunas da tabela
    private String [] columns = {
            InfoBeautySQLiteOpenHelper.COLUNA_ID_USUARIO ,
            InfoBeautySQLiteOpenHelper.COLUNA_NOME_USUARIO ,
            InfoBeautySQLiteOpenHelper.COLUNA_EMAIL_USUARIO ,
            InfoBeautySQLiteOpenHelper.COLUNA_CPF_USUARIO ,
            InfoBeautySQLiteOpenHelper.COLUNA_SENHA_USUARIO,

    };

    private InfoBeautySQLiteOpenHelper sqliteOpenHelper;

    public UsuarioDAO(Context context) {
        sqliteOpenHelper = new InfoBeautySQLiteOpenHelper(context);
    }

    public void open() throws SQLException {
        database = sqliteOpenHelper.getWritableDatabase();
        database1 = sqliteOpenHelper.getReadableDatabase();

    }

    public void close() {
        sqliteOpenHelper.close();
    }
    // inclusão
    public void inserir_usuario(String nome_usuario, String email_usuario, String cpf_usuario, String senha_usuario) {
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME_USUARIO, nome_usuario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_EMAIL_USUARIO, email_usuario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_CPF_USUARIO, cpf_usuario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_SENHA_USUARIO, senha_usuario);
        long insertId_usuario = database.insert(InfoBeautySQLiteOpenHelper.TABELA_USUARIO, null, values);

    }

    // alteração
    public void alterar_usuario(long id, String nome_usuario, String email_usuario, String cpf_usuario, String senha_usuario) {
        // prepara os dados para a atualização
        ContentValues values = new ContentValues();
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_NOME_USUARIO, nome_usuario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_EMAIL_USUARIO, email_usuario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_CPF_USUARIO, cpf_usuario);
        values.put(InfoBeautySQLiteOpenHelper.COLUNA_SENHA_USUARIO, senha_usuario);
        database.update(InfoBeautySQLiteOpenHelper.TABELA_USUARIO, values, InfoBeautySQLiteOpenHelper.COLUNA_ID_USUARIO + "=" + id, null);
    }
    // exclusão
    public void apagar_usuario(long id) {
        database.delete(InfoBeautySQLiteOpenHelper.TABELA_USUARIO, InfoBeautySQLiteOpenHelper.COLUNA_ID_USUARIO + "=" + id, null);
    }

    public String login_usuario(String email_usuario, String senha_usuario){
        database = sqliteOpenHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM Usuario WHERE email_usuario=? AND senha_usuario=?", new String[]{email_usuario, senha_usuario});
        if(cursor.getCount()>0){
            return "OK";
        }
        return "ERRO";
    }
    //busca
    public Usuario buscar_usuario(long id) {
        Cursor cursor = database.query(InfoBeautySQLiteOpenHelper.TABELA_USUARIO,
                columns, InfoBeautySQLiteOpenHelper.COLUNA_ID_USUARIO + " = " + id, null,null, null, null);
        cursor.moveToFirst();
        Usuario usuario = new Usuario();
        usuario.setId_usuario(cursor.getLong(0));
        usuario.setNome_usuario(cursor.getString(1));
        usuario.setEmail_usuario(cursor.getString(2));
        usuario.setCpf_usuario(cursor.getString(3));
        usuario.setSenha_usuario(cursor.getString(4));
        cursor.close();
        return usuario;
    }
    // criação da lista de itens para a ListaView da tela principal
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Cursor cursor = database.query(InfoBeautySQLiteOpenHelper.TABELA_USUARIO, columns, null, null, null, null, null);
        // confirma o ponteiro do arquivo na primeira posição da tabela
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {// pega cada elemento da tabela e insere na lista
            Usuario usuario = new Usuario();
            usuario.setId_usuario(cursor.getLong(0));
            usuario.setNome_usuario(cursor.getString(1));
            usuario.setEmail_usuario(cursor.getString(2));
            usuario.setCpf_usuario(cursor.getString(3));
            usuario.setSenha_usuario(cursor.getString(4));
            usuarios.add(usuario);
            cursor.moveToNext();
        }
        // fecha o cursor
        cursor.close();
        // retorna a lista com as disciplinas
        return usuarios;
    }

        public String ValidarLogin(String email_usuario, String senha_usuario){
            Cursor cursor = database1.rawQuery("SELECT * FROM TABELA_USUARIO WHERE COLUNA_EMAIL_USUARIO=? AND COLUNA_SENHA_USUARIO=?", new String[]{email_usuario,senha_usuario});

            if (cursor.getCount()>0){
                return "OK";
            }
            return "ERRO";
        }
}