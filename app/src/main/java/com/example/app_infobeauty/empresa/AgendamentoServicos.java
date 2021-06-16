package com.example.app_infobeauty.empresa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.app_infobeauty.R;

import java.util.ArrayList;

public class AgendamentoServicos extends AppCompatActivity {

    Spinner spServicos, spHorarios;
    Button confirmarAgenda;
    private AlertDialog alertaDeAgendamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento_servicos);

        confirmarAgenda = (Button) findViewById(R.id.buttonConfirmAgenda);
        spServicos = (Spinner) findViewById(R.id.spinnerServicos);
        //spHorarios = (Spinner) findViewById(R.id.spinnerHorarios);

        ArrayList<String> listServ = new ArrayList<>();
        listServ.add("Serviços disponiveis");
        listServ.add("Cortes de cabelos 20$");
        listServ.add("Depilação 30$");
        listServ.add("Manicure 15$");

        spServicos.setAdapter(new ArrayAdapter<>(AgendamentoServicos.this,
                android.R.layout.simple_spinner_dropdown_item, listServ));


        /*ArrayList<String> listHora = new ArrayList<>();
        listHora.add("Horários disponiveis");
        listHora.add("13:00 até 14:00");
        listHora.add("15:00 até 16:00");
        listHora.add("16:00 até 17:00");
        listHora.add("17:00 até 18:00");

        spHorarios.setAdapter(new ArrayAdapter<>(AgendamentoServicos.this,
                android.R.layout.simple_spinner_dropdown_item, listHora));
    }*/
    }

    public void alertaDeAgendamento(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Agendamento realizado com sucesso!");
        builder.setMessage("Compareça no local na data e hora escolhida por você!");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(AgendamentoServicos.this, "✓", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertaDeAgendamento = builder.create();
        alertaDeAgendamento.show();
    }

    public void bt1(View v){
        Toast.makeText(AgendamentoServicos.this, "11:00 da manhã!", Toast.LENGTH_SHORT).show();
    }
    public void bt2(View v){
        Toast.makeText(AgendamentoServicos.this, "13:00 da tarde!", Toast.LENGTH_SHORT).show();
    }
    public void bt3(View v){
        Toast.makeText(AgendamentoServicos.this, "15:00 da tarde!", Toast.LENGTH_SHORT).show();
    }
    public void bt4(View v){
        Toast.makeText(AgendamentoServicos.this, "17:00 da tarde!", Toast.LENGTH_SHORT).show();
    }
}