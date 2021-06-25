package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.app_infobeauty.R;

public class VerAgendamentos_e extends AppCompatActivity {

    TextView nomeUser, emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_agendamentos_e);

        nomeUser = (TextView) findViewById(R.id.textNomeU);
        emailUser = (TextView) findViewById(R.id.textEmailU);

        SharedPreferences prefsA = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String nomeX = prefsA.getString("Nome", "");
        String EmailX = prefsA.getString("Email", "");

        nomeUser.setText(nomeX);
        emailUser.setText(EmailX);

    }

    public void voltar(View v){
        finish();
    }
}