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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app_infobeauty.R;
import com.example.app_infobeauty.fragment_e.AdicionarServicosFragment_e;
import com.example.app_infobeauty.fragment_e.AgendamentosFragment_e;
import com.example.app_infobeauty.fragment_e.ConfiguracaoFragment_e;
import com.example.app_infobeauty.fragment_e.LocalizacaoFragment_e;
import com.example.app_infobeauty.fragment_e.MeuEstabelecimentoFragment_e;
import com.example.app_infobeauty.fragment_e.MeusServicosFragment_e;
import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import android.view.View;
import android.widget.AdapterView;


public class TelaNavegacaoEmpresa extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MeuEstabelecimentoFragment_e()).commit();
            break;
            case R.id.nav_meus_servicos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MeusServicosFragment_e()).commit();
                break;
            case R.id.nav_location:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new LocalizacaoFragment_e()).commit();
                break;
            case R.id.nav_agendamentos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AgendamentosFragment_e()).commit();
                break;
            case R.id.nav_adicionar_servicos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AdicionarServicosFragment_e()).commit();
                Intent intent = new Intent(this, ServicosEmpresas.class);
                startActivity(intent);
                break;
            case R.id.nav_configure:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ConfiguracaoFragment_e()).commit();
                break;
            case R.id.nav_help:
                Toast.makeText(this, "Ajuda", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_exit:
                finish();
                Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
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