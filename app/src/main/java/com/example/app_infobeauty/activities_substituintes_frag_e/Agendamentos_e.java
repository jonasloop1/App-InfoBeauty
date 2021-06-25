package com.example.app_infobeauty.activities_substituintes_frag_e;

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
import com.example.app_infobeauty.agendamento.AgendamentoServicos;
import com.example.app_infobeauty.empresa.Empresa;
import com.example.app_infobeauty.empresa.EmpresaDAO;
import com.example.app_infobeauty.empresa.VerAgendamentos_e;
import com.example.app_infobeauty.usuario.Usuario;
import com.example.app_infobeauty.usuario.UsuarioDAO;

import java.util.Iterator;
import java.util.List;

public class Agendamentos_e extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private AgendamentoDAO dao;
    private UsuarioDAO daoUser;
    private String[] agendamento;
    private  long[] idAgendamento;
    private String[] UsuarioDados_c;
    private long[] idUsuarioDados_c;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos_e);

        lista = (ListView) findViewById(R.id.listViewAgenda);
        dao = new AgendamentoDAO(this);
        dao.open();
        lista.setOnItemClickListener(this);
    }

    @Override
    protected void onResume(){
        dao.open();
        super.onResume();
        List<Agendamento> listaDeAgendamentos = dao.getAll();
       // List<Usuario> listadadosUsuario = daoUser.getAll();
       // UsuarioDados_c = new String[listadadosUsuario.size()];
        agendamento = new String[listaDeAgendamentos.size()];
       //ç idUsuarioDados_c = new long[listadadosUsuario.size()];
        idAgendamento = new long[listaDeAgendamentos.size()];
        int i = 0;

        /*Iterator<Usuario> iterator_c = listadadosUsuario.iterator();
        while (iterator_c.hasNext()){
            Usuario user = new Usuario();
            user = (Usuario) iterator_c.next();
            UsuarioDados_c[i] = user.textoListaUsuario();
            idUsuarioDados_c[i] = user.getId_usuario();
            i++;
        }*/

        Iterator<Agendamento> iterator = listaDeAgendamentos.iterator();
        while (iterator.hasNext()){
            Agendamento grr = new Agendamento();
            grr = (Agendamento) iterator.next();
            agendamento[i] = grr.textoLista();
            idAgendamento[i] = grr.getId_agendamento();
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, agendamento);
        lista.setAdapter(adapter);

    }

    @Override
    protected void onPause(){
        dao.close();
        super.onPause();
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long ident){
        long id = idAgendamento[position];
        Intent intent = new Intent(getApplicationContext(), VerAgendamentos_e.class);
        intent.putExtra("acao", 0);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}