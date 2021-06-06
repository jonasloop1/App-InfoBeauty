package com.example.app_infobeauty.usuario;
import android.content.ContentValues;
import android.content.Context;

public class UsuarioDAO {

    /*private final String TABLE_USUARIO = "Usuario";
    private DbGateway gw;

    public UsuarioDAO(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }

    public boolean salvar(String nome, String email, String senha) {
        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Email", email);
        cv.put("Senha", senha);
        return gw.getDatabase().insert(TABLE_USUARIO, null, cv) > 0;
    }*/



    //public List<TelaCadastroUsuario.Usuario> retornarTodos(){
      //  List<TelaCadastroUsuario.Usuario> usuario = new ArrayList<>();
       // Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM Usuario", null);
        //while(cursor.moveToNext()){
          //  int id = cursor.getInt(cursor.getColumnIndex("ID"));
            //String nome = cursor.getString(cursor.getColumnIndex("Nome"));
            //String email = cursor.getString(cursor.getColumnIndex("Email"));
            //String senha = cursor.getString(cursor.getColumnIndex("Senha"));
            //usuario.add(new TelaCadastroUsuario.Usuario(id, nome, email, senha));
        //}
        //cursor.close();
        //return usuario;
    //}
}