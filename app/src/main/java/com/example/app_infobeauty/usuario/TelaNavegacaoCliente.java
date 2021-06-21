package com.example.app_infobeauty.usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app_infobeauty.InfoMaps;
import com.example.app_infobeauty.TelaInicial;
import com.example.app_infobeauty.activities_substituintes_frag_c.MeuPerfil_c;
import com.example.app_infobeauty.activities_substituintes_frag_c.MeusAgendamentos_c;
import com.example.app_infobeauty.agendamento.AgendamentoServicos;
import com.example.app_infobeauty.R;
import com.example.app_infobeauty.empresa.Empresa;
import com.example.app_infobeauty.empresa.EmpresaDAO;
import com.example.app_infobeauty.fragment_c.AjudaFragment_c;
import com.example.app_infobeauty.fragment_c.LocalizacaoFragment_c;
import com.example.app_infobeauty.fragment_c.MeuPerfilFragment_c;
import com.example.app_infobeauty.fragment_c.MeusAgendamentosFragment_c;
import com.example.app_infobeauty.fragment_c.MeusFavoritos_c;
import com.example.app_infobeauty.fragment_e.AdicionarServicosFragment_e;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Iterator;
import java.util.List;

public class TelaNavegacaoCliente extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener {

    private DrawerLayout drawer;
    ListView lista;
    private EmpresaDAO dao;
    private String[] servicos;
    private  long[] idServicos;
    private int imgs[] = {R.drawable.barber};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_navegacao_cliente);

        Toolbar toolbar = findViewById(R.id.toolbar);

        lista = (ListView) findViewById(R.id.listView);
        dao = new EmpresaDAO(this);
        dao.open();
        lista.setOnItemClickListener(this);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected void onResume(){
        dao.open();
        super.onResume();
        List<Empresa> listaServicos = dao.getAll();
        servicos = new String[listaServicos.size()];
        idServicos = new long[listaServicos.size()];
        int i = 0;

        Iterator<Empresa> iterator = listaServicos.iterator();
        while (iterator.hasNext()){
            Empresa aux = new Empresa();
            aux = (Empresa) iterator.next();
            servicos[i] = aux.textoLista();
            idServicos[i] = aux.getId_empresa();
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, servicos);
        lista.setAdapter(adapter);
    }

    @Override
    protected void onPause(){
        dao.close();
        super.onPause();
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long ident){
        long id = idServicos[position];
        Intent intent = new Intent(getApplicationContext(), AgendamentoServicos.class);
        intent.putExtra("acao", 0);
        intent.putExtra("id", id);
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case R.id.nav_perfil_c:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        //new MeuPerfilFragment_c()).commit();
                Intent intentu = new Intent(this, MeuPerfil_c.class);
                startActivity(intentu);
                break;
            case R.id.nav_location_c:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LocalizacaoFragment_c()).commit();
                break;
            case R.id.nav_agendamentos_c:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        //new MeusAgendamentosFragment_c()).commit();
                Intent intent = new Intent(this, MeusAgendamentos_c.class);
                startActivity(intent);
                break;
            case R.id.nav_favoritos_c:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MeusFavoritos_c()).commit();
                break;
            case R.id.nav_configure_c:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AdicionarServicosFragment_e()).commit();
                break;

            case R.id.nav_help_c:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AjudaFragment_c()).commit();
                break;
            case R.id.nav_exit_c:
                intent = new Intent(getApplicationContext(), TelaInicial.class);
                startActivity(intent);
                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void meus_agendamentos(View v){
        Intent intent = new Intent(TelaNavegacaoCliente.this, MeusAgendamentos_c.class);
        startActivity(intent);
    }

    public void chamar_maps(View v){
        Intent intent = new Intent(TelaNavegacaoCliente.this, InfoMaps.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}