package com.example.app_infobeauty.agendamento;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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

    Spinner spServicos, spHorarios;
    EditText nomeEmpresaAgenda;
    RadioButton rbHora1, rbHora2, rbHora3, rbHora4;
    Button confirmarAgenda, bt1_h, bt2_h, bt3_h, bt4_h;
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
        nomeEmpresaAgenda.setText("Barber Max");

       /* bt1_h = (Button) findViewById(R.id.bt1);
        bt2_h = (Button) findViewById(R.id.bt2);
        bt3_h = (Button) findViewById(R.id.bt3);
        bt4_h = (Button) findViewById(R.id.bt4);*/
        spServicos = (Spinner) findViewById(R.id.spinnerServicos);
        canlendarioData = (CalendarView) findViewById(R.id.calendario);
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
        String nomeServicoAgendado, dataServicoAgendado, horaServicoAgendado;

        if (spServicos.getSelectedItem().toString().trim().equals("Cortes de cabelos 20$")) {
            nomeServicoAgendado = spServicos.getSelectedItem().toString();
        }else if(spServicos.getSelectedItem().toString().trim().equals("Depilação 30$")){
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
        builder.setMessage("Compareça no local na data e hora escolhida por você!");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
               Toast.makeText(AgendamentoServicos.this, "✓", Toast.LENGTH_SHORT).show();
            }
        });
        alertaDeAgendamento = builder.create();
        alertaDeAgendamento.show();

        Intent intent = new Intent(AgendamentoServicos.this, TelaNavegacaoCliente.class);
        startActivity(intent);
    }

    public void maaisInfo(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Informações do estabelecimento!");
        builder.setMessage("Endereço:" +
                "\nFuncionário:" +
                "\nE-mail:");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(AgendamentoServicos.this, "✓", Toast.LENGTH_SHORT).show();
            }
        });
        alertaDeAgendamento = builder.create();
        alertaDeAgendamento.show();
    }
}