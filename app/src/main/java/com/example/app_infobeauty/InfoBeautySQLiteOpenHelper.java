package com.example.app_infobeauty;

import android.content.Context ;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InfoBeautySQLiteOpenHelper extends SQLiteOpenHelper{
    // definição dos atributos

    public static final String TABELA_EMPRESA = " Empresa ";
    public static final String COLUNA_ID_EMPRESA = " id_empresa ";
    public static final String COLUNA_NOME_EMPRESA = " nome_empresa ";
    public static final String COLUNA_EMAIL_EMPRESA = " email_empresa ";
    public static final String COLUNA_CNPJ_EMPRESA = " cnpj_empresa ";
    public static final String COLUNA_SENHA_EMPRESA = " senha_empresa ";
    public static final String COLUNA_CONFIRMASENHA_EMPRESA = " confirmasenha_empresa ";

    public static final String TABELA_USUARIO = " Usuario ";
    public static final String COLUNA_ID_USUARIO = " id_usuario ";
    public static final String COLUNA_NOME_USUARIO = " nome_usuario ";
    public static final String COLUNA_EMAIL_USUARIO = " email_usuario ";
    public static final String COLUNA_CPF_USUARIO = " cpf_usuario ";
    public static final String COLUNA_SENHA_USUARIO = " senha_usuario ";
    public static final String COLUNA_CONFIRMASENHA_USUARIO = " confirmasenha_usuario ";

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
    private static final String CRIAR_BANCO_EMPRESA = " create table "
            + TABELA_EMPRESA + "("
            + COLUNA_ID_EMPRESA + " integer primary key autoincrement , "
            + COLUNA_NOME_EMPRESA + " text not null , "
            + COLUNA_EMAIL_EMPRESA + " text not null , "
            + COLUNA_CNPJ_EMPRESA + " text not null , "
            + COLUNA_SENHA_EMPRESA + " text not null , "
            + COLUNA_CONFIRMASENHA_EMPRESA + " text not null ) ;";

    private static final String CRIAR_BANCO_USUARIO = " create table "
            + TABELA_USUARIO + "("
            + COLUNA_ID_USUARIO + " integer primary key autoincrement , "
            + COLUNA_NOME_USUARIO + " text not null , "
            + COLUNA_EMAIL_USUARIO + " text not null , "
            + COLUNA_CPF_USUARIO + " text not null , "
            + COLUNA_SENHA_USUARIO + " text not null , "
            + COLUNA_CONFIRMASENHA_USUARIO + " text not null ) ;";

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
        database.execSQL ( CRIAR_BANCO_EMPRESA );
        database.execSQL ( CRIAR_BANCO_USUARIO );
        database.execSQL ( CRIAR_BANCO_SERVICOS );

    }
    // atualização do banco
    @Override
    public void onUpgrade ( SQLiteDatabase db , int oldVersion , int newVersion ) {
        db.execSQL (" DROP TABLE IF EXISTS " + TABELA_EMPRESA );
        db.execSQL (" DROP TABLE IF EXISTS " + TABELA_USUARIO );
        db.execSQL (" DROP TABLE IF EXISTS " + TABELA_SERVICOS );
        onCreate (db);
    }
}
