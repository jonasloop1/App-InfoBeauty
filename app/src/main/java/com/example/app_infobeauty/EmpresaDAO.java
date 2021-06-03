package com.example.app_infobeauty;

import android.content.ContentValues;
import android.content.Context;

public class EmpresaDAO {

    private final String TABLE_EMPRESA = "Empresa";
    private DbGateway gw;

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
}
