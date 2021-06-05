package com.example.app_infobeauty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {

    private final String TABLE_EMPRESA = "Empresa";
    private DbGateway gw;
    private SQLiteDatabase database;

    public EmpresaDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean salvar_E (String nome_E, String email_E, String cnpj_E, String senha_E, String confirmasenha_E) {
        ContentValues cv = new ContentValues();
        cv.put("Nome_E", nome_E);
        cv.put("Email_E", email_E);
        cv.put("Cnpj_E", cnpj_E);
        cv.put("Senha_E", senha_E);
        cv.put("ConfirmaSenha_E", confirmasenha_E);
        return gw.getDatabase().insert(TABLE_EMPRESA, null, cv) > 0;
    }

    public void alterar_E(int id_E, String nome_E, String email_E, String cnpj_E, String senha_E, String confirmasenha_E) {
        ContentValues cv = new ContentValues();
        cv.put("Nome_E", nome_E);
        cv.put("Email_E", email_E);
        cv.put("Cnpj_E", cnpj_E);
        cv.put("Senha_E", senha_E);
        cv.put("ConfirmaSenha_E", confirmasenha_E);
        gw.getDatabase().update(TABLE_EMPRESA, cv, id_E +"="+ id_E,null);
    }

    public List<TelaNavegacaoEmpresa.Empresa> getAll(){
        List<TelaNavegacaoEmpresa.Empresa> empresa = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Empresa", null);
        while(cursor.moveToNext()){
            int id_E = cursor.getInt(cursor.getColumnIndex("ID_E"));
            String nome_E = cursor.getString(cursor.getColumnIndex("Nome_E"));
            String cnpj_E = cursor.getString(cursor.getColumnIndex("Cnpj_E"));
            String senha_E = cursor.getString(cursor.getColumnIndex("Senha_E"));
            String confirmasenha_E = cursor.getString(cursor.getColumnIndex("ConfirmaSenha_E"));

            //empresa.add(id_E, nome_E, cnpj_E, senha_E, confirmasenha_E);
            cursor.moveToNext();
        }
        cursor.close();
        return empresa;
    }
}