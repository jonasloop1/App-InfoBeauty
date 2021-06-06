package com.example.app_infobeauty;

import android.content.Context ;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InfoBeautySQLiteOpenHelper extends SQLiteOpenHelper{
    // definição dos atributos
    public static final String TABELA_EMPRESA = " Empresa ";
    public static final String COLUNA_ID = " id ";
    public static final String COLUNA_NOME = " nome ";
    public static final String COLUNA_EMAIL = " email ";
    public static final String COLUNA_CNPJ = " cnpj ";
    public static final String COLUNA_SENHA = " senha ";
    public static final String COLUNA_CONFIRMASENHA = " confirmasenha ";

    public static final String TABELA_SERVICOS = " Servicos ";
    public static final String COLUNA_ID_SERVICOS = " id_servicos ";
    public static final String COLUNA_NOME_FUNCIONARIO = " nome_funcionario ";
    public static final String COLUNA_NOME_SERVICOS = " nome_servicos ";
    public static final String COLUNA_HORARIO_SERVICOS = " horario_servicos ";

    // nomeia o banco de dados
    private static final String DATABASE_NAME = "infobeauty.db";
    // determina a versão do banco
    private static final int DATABASE_VERSION = 1;
    // prepara a criação da tabela se não existir
    private static final String CRIAR_BANCO = " create table "
            + TABELA_EMPRESA + "("
            + COLUNA_ID + " integer primary key autoincrement , "
            + COLUNA_NOME + " text not null , "
            + COLUNA_EMAIL + " text not null , "
            + COLUNA_CNPJ + " text not null , "
            + COLUNA_SENHA + " text not null , "
            + COLUNA_CONFIRMASENHA + " text not null ) ;";


    private static final String CRIAR_BANCO_SERVICOS = " create table "
            + TABELA_SERVICOS + "("
            + COLUNA_ID_SERVICOS + " integer primary key autoincrement , "
            + COLUNA_NOME_FUNCIONARIO + " text not null , "
            + COLUNA_NOME_SERVICOS + " text not null , "
            + COLUNA_HORARIO_SERVICOS + " text not null ) ;";

    // construtor
    public InfoBeautySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // criação do banco
    @Override
    public void onCreate ( SQLiteDatabase database )
    {
        database.execSQL ( CRIAR_BANCO );
        database.execSQL ( CRIAR_BANCO_SERVICOS );
    }
    // atualização do banco
    @Override
    public void onUpgrade ( SQLiteDatabase db , int oldVersion , int newVersion ) {
        db.execSQL (" DROP TABLE IF EXISTS " + TABELA_EMPRESA );
        db.execSQL (" DROP TABLE IF EXISTS " + TABELA_SERVICOS );
        onCreate (db);
    }
}
