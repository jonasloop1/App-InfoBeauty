package com.example.app_infobeauty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.text.MessageFormat;

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
                break;
            case R.id.nav_configure:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ConfiguracaoFragment_e()).commit();
                break;
            case R.id.nav_help:
                Toast.makeText(this, "Ajuda", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_exit:
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