package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.app_infobeauty.R;

import java.util.ArrayList;

public class DadosServicos extends AppCompatActivity {

    Spinner spServicos, spHorarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_servicos);

        spServicos = (Spinner) findViewById(R.id.spinnerServicos);
        spHorarios = (Spinner) findViewById(R.id.spinnerHorarios);

        ArrayList<String> listServ = new ArrayList<>();
        listServ.add("Serviços disponiveis");
        listServ.add("Cortes de cabelos");
        listServ.add("Depilação");
        listServ.add("Manicure");
        listServ.add("Enxerto de dedo");

        spServicos.setAdapter(new ArrayAdapter<>(DadosServicos.this,
                android.R.layout.simple_spinner_dropdown_item, listServ));

        ArrayList<String> listHora = new ArrayList<>();
        listHora.add("Horários disponiveis");
        listHora.add("13:00 até 14:00");
        listHora.add("15:00 até 16:00");
        listHora.add("16:00 até 17:00");
        listHora.add("17:00 até 18:00");

        spHorarios.setAdapter(new ArrayAdapter<>(DadosServicos.this,
                android.R.layout.simple_spinner_dropdown_item, listHora));
    }
}