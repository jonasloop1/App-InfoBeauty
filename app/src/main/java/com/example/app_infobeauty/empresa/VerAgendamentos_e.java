package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.app_infobeauty.R;

public class VerAgendamentos_e extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_agendamentos_e);
    }

    public void voltar(View v){
        finish();
    }
}