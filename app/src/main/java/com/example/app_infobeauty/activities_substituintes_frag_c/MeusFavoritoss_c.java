package com.example.app_infobeauty.activities_substituintes_frag_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.app_infobeauty.R;
import com.example.app_infobeauty.agendamento.Agendamento;
import com.example.app_infobeauty.agendamento.AgendamentoDAO;

import java.util.Iterator;
import java.util.List;

public class MeusFavoritoss_c extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView listaAgenda;
    private AgendamentoDAO dao;
    private String[] agendamentos;
    private  long[] idAgendamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_favoritoss_c);

        listaAgenda = (ListView) findViewById(R.id.listViewFavoritos_c);
        dao = new AgendamentoDAO(this);
        dao.open();
        listaAgenda.setOnItemClickListener(this);
    }

    @Override
    protected void onResume(){
        dao.open();
        super.onResume();
        List<Agendamento> listaServicos = dao.getAll();
        agendamentos = new String[listaServicos.size()];
        idAgendamentos = new long[listaServicos.size()];
        int i = 0;

        Iterator<Agendamento> iterator = listaServicos.iterator();
        while (iterator.hasNext()){
            Agendamento aux = new Agendamento();
            aux = (Agendamento) iterator.next();
            agendamentos[i] = aux.textoListaFavoritos();
            idAgendamentos[i] = aux.getId_agendamento();
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, agendamentos);
        listaAgenda.setAdapter(adapter);
    }

    @Override
    protected void onPause(){
        dao.close();
        super.onPause();
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long ident){
        long id = idAgendamentos[position];
        Intent intent = new Intent(getApplicationContext(), MeusFavoritoss_c.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}