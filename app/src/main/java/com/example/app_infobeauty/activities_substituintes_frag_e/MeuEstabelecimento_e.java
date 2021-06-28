package com.example.app_infobeauty.activities_substituintes_frag_e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import com.example.app_infobeauty.R;

public class MeuEstabelecimento_e extends AppCompatActivity /*implements  AdapterView.OnItemClickListener*/{

    EditText nomeEstab, enderecoEstab, emailEstab, cnpjEstab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_estabelecimento_e);


        nomeEstab = (EditText) findViewById(R.id.edtNomeEstabelecimento);
        enderecoEstab = (EditText) findViewById(R.id.edtEnderecoEstabelecimento);
        emailEstab = (EditText) findViewById(R.id.edtEmailEstabelecimento);
        cnpjEstab = (EditText) findViewById(R.id.edtCnpjEstabelecimento);

        SharedPreferences prefsE = getApplicationContext().getSharedPreferences("MyPrefsEmpresa", Context.MODE_PRIVATE);


        String nomeEmpresaX = prefsE.getString("NomeEmpresa", "");
        String enderecoEmpresaX = prefsE.getString("EndereçoEmpresa", "");
        String EmailEmpresaX = prefsE.getString("EmailEmpresa", "");
        String cnpjX = prefsE.getString("Cnpj", "");

        nomeEstab.setText(nomeEmpresaX);
        enderecoEstab.setText(enderecoEmpresaX);
        emailEstab.setText(EmailEmpresaX);
        cnpjEstab.setText(cnpjX);

    }
}