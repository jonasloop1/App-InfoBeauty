package com.example.app_infobeauty.empresa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.app_infobeauty.InfoMaps;
import com.example.app_infobeauty.R;
import com.example.app_infobeauty.TelaInicial;
import com.example.app_infobeauty.activities_substituintes_frag_e.Agendamentos_e;
import com.example.app_infobeauty.activities_substituintes_frag_e.Configuracao_e;
import com.example.app_infobeauty.activities_substituintes_frag_e.MeuEstabelecimento_e;
import com.example.app_infobeauty.activities_substituintes_frag_e.MeusServicos_e;
import com.google.android.material.navigation.NavigationView;


public class TelaNavegacaoEmpresa extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_navegacao_empresa);

        Toolbar toolbar = findViewById(R.id.toolbar);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case R.id.nav_estabelecimento:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                 //       new MeuEstabelecimentoFragment_e()).commit();
                intent = new Intent(TelaNavegacaoEmpresa.this, MeuEstabelecimento_e.class);
                startActivity(intent);
            break;
            case R.id.nav_meus_servicos:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        //new MeusServicosFragment_e()).commit();
                Intent intentS = new Intent(TelaNavegacaoEmpresa.this, MeusServicos_e.class);
                startActivity(intentS);
                break;
            case R.id.nav_location:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        //new LocalizacaoFragment_e()).commit();
                Intent intentL = new Intent(TelaNavegacaoEmpresa.this, InfoMaps.class);
                startActivity(intentL);
                break;
            case R.id.nav_agendamentos:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        //new AgendamentosFragment_e()).commit();
                Intent intentA = new Intent(TelaNavegacaoEmpresa.this, Agendamentos_e.class);
                startActivity(intentA);
                break;
            case R.id.nav_adicionar_servicos:
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                     //   new AdicionarServicosFragment_e()).commit();
                Intent intent = new Intent(this, ServicosEmpresas.class);
                startActivity(intent);
                break;
            case R.id.nav_configure:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        //new ConfiguracaoFragment_e()).commit();
                Intent intentC = new Intent(this, Configuracao_e.class);
                startActivity(intentC);
                break;
            case R.id.nav_help:
                Toast.makeText(this, "Ajuda", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_exit:
                intent = new Intent(getApplicationContext(), TelaInicial.class);
                startActivity(intent);
                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void meuEstabelecimento(View v){
        intent = new Intent(TelaNavegacaoEmpresa.this, MeuEstabelecimento_e.class);
        startActivity(intent);
    }

    public void addServicos(View v){
        Intent intent = new Intent(TelaNavegacaoEmpresa.this, ServicosEmpresas.class);
        startActivity(intent);
    }

    public void meusServicos(View v){
        Intent intent = new Intent(TelaNavegacaoEmpresa.this, MeusServicos_e.class);
        startActivity(intent);
    }

    public void agendamentosss(View v){
        Intent intent = new Intent(TelaNavegacaoEmpresa.this, Agendamentos_e.class);
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