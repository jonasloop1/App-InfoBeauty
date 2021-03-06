package com.example.app_infobeauty.agendamento;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.app_infobeauty.R;
import com.example.app_infobeauty.usuario.TelaNavegacaoCliente;
import java.util.ArrayList;

public class AgendamentoServicos extends AppCompatActivity {

    Spinner spServicos;
    EditText nomeEmpresaAgenda;
    RadioButton rbHora1, rbHora2, rbHora3, rbHora4;
    Button confirmarAgenda;
    ImageView buttonMaisInformacoes;
    CalendarView canlendarioData;
    private AlertDialog alertaDeAgendamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento_servicos);

        confirmarAgenda = (Button) findViewById(R.id.buttonConfirmAgenda);
        buttonMaisInformacoes = (ImageView) findViewById(R.id.buttonMaisInfon);
        rbHora1 = (RadioButton) findViewById(R.id.rbHora1);
        rbHora2 = (RadioButton) findViewById(R.id.rbHora2);
        rbHora3 = (RadioButton) findViewById(R.id.rbHora3);
        rbHora4 = (RadioButton) findViewById(R.id.rbHora4);
        nomeEmpresaAgenda = (EditText) findViewById(R.id.edtNomeEstabelecimentoAgenda);

        SharedPreferences prefsE = getApplicationContext().getSharedPreferences("MyPrefsEmpresa", Context.MODE_PRIVATE);

        String nomeEmpresaX = prefsE.getString("NomeEmpresa", "");

        nomeEmpresaAgenda.setText(nomeEmpresaX);

        spServicos = (Spinner) findViewById(R.id.spinnerServicos);
        canlendarioData = (CalendarView) findViewById(R.id.calendario);

        ArrayList<String> listServ = new ArrayList<>();
        listServ.add("Servi??os disponiveis");
        listServ.add("Cortes de cabelos 20$");
        listServ.add("Depila????o 30$");
        listServ.add("Manicure 15$");

        spServicos.setAdapter(new ArrayAdapter<>(AgendamentoServicos.this,
                android.R.layout.simple_spinner_dropdown_item, listServ));

    }

    public void alertaDeAgendamento(View v){
        String nomeServicoAgendado, dataServicoAgendado, horaServicoAgendado;

        if (spServicos.getSelectedItem().toString().trim().equals("Cortes de cabelos 20$")) {
            nomeServicoAgendado = spServicos.getSelectedItem().toString();
        }else if(spServicos.getSelectedItem().toString().trim().equals("Depila????o 30$")){
            nomeServicoAgendado = spServicos.getSelectedItem().toString();
        }else{
            nomeServicoAgendado = spServicos.getSelectedItem().toString();
        }

        dataServicoAgendado = canlendarioData.toString();
        Log.d("TAG", "DATA" + dataServicoAgendado);

        if(rbHora1.isChecked()){
            horaServicoAgendado = rbHora1.getText().toString();
        }else if(rbHora2.isChecked()){
            horaServicoAgendado = rbHora2.getText().toString();
        }else  if(rbHora3.isChecked()){
            horaServicoAgendado = rbHora3.getText().toString();
        }else{
            horaServicoAgendado = rbHora4.getText().toString();
        }

        AgendamentoDAO dao = new AgendamentoDAO(this);
        dao.open();
        dao.inserir_agendamento(nomeServicoAgendado, dataServicoAgendado, horaServicoAgendado);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Agendamento realizado com sucesso!");
        builder.setMessage("Compare??a no local na data e hora escolhida por voc??!");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
               Toast.makeText(AgendamentoServicos.this, "???", Toast.LENGTH_SHORT).show();
            }
        });
        alertaDeAgendamento = builder.create();
        alertaDeAgendamento.show();

        Intent intent = new Intent(AgendamentoServicos.this, TelaNavegacaoCliente.class);
        startActivity(intent);
    }

    public void maaisInfo(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Informa????es do estabelecimento!");
        builder.setMessage("Endere??o:" +
                "\nFuncion??rio:" +
                "\nE-mail:");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(AgendamentoServicos.this, "???", Toast.LENGTH_SHORT).show();
            }
        });
        alertaDeAgendamento = builder.create();
        alertaDeAgendamento.show();
    }
}