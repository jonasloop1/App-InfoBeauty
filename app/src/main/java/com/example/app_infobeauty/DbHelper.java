package com.example.app_infobeauty;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Infobeaty.db";
    private static final int DATABASE_VERSION = 2;
    private final String CREATE_TABLE = "CREATE TABLE Usuario (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nome TEXT NOT NULL, Email TEXT NOT NULL, Senha TEXT NOT NULL);";
    private final String CREATE_TABLE1 = "CREATE TABLE Empresa (ID_E INTEGER PRIMARY KEY AUTOINCREMENT, Nome_E TEXT NOT NULL, Email_E TEXT NOT NULL, Cnpj_E TEXT NOT NULL, Senha_E TEXT NOT NULL, ConfirmaSenha_E);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //Verificação se o email existe
    //public  Boolean chkemail (String email){
    //    SQLiteDatabase db = this.getReadableDatabase();
     //   Cursor cursor = db.rawQuery("Select * from usuario where email=?",new String[]{email});
      //  if(cursor.getCount()>0) return false;
        //else return true;
}
//}