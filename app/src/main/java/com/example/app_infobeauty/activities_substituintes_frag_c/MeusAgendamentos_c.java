package com.example.app_infobeauty.activities_substituintes_frag_c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.app_infobeauty.R;

public class MeusAgendamentos_c extends AppCompatActivity {

    EditText nomeServico, dataServico, horaServico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_agendamentos_c);

        nomeServico = (EditText) findViewById(R.id.edtNomeServico);
        dataServico = (EditText) findViewById(R.id.edtDataServico);
        horaServico = (EditText) findViewById(R.id.edtHoraServico);

        nomeServico.setText("Depilação R$ 20");
        dataServico.setText("01/09/2021");
        horaServico.setText("10:00h");
    }
}