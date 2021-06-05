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

import java.io.Serializable;
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

    public static class Empresa implements Serializable {

        private int id_E;
        private String nome_E;
        private String email_E;
        private String cnpj_E;
        private String senha_E;
        private String confirmasenha_E;

        public Empresa(int id_E, String nome_E, String email_E,String cnpj_E ,String senha_E, String confirmasenha_E){
            this.id_E = id_E;
            this.nome_E = nome_E;
            this.email_E = email_E;
            this.cnpj_E = cnpj_E;
            this.senha_E = senha_E;
            this.confirmasenha_E = confirmasenha_E;
        }

        public int getId_E(){ return this.id_E; }

        public String getNome_E(){
            return this.nome_E;
        }

        public void setNome_E(String nome_E) {
            if (!nome_E.isEmpty()) {
                this.nome_E = nome_E;
            }
        }

        public String getEmail_E(){
            return this.email_E;
        }

        public void setEmail_E(String email_E) {
            if (!email_E.isEmpty()) {
                this.email_E = email_E;
            }
        }

        public String getCnpj_E(){
            return this.cnpj_E;
        }

        public void setCnpj_E(String cnpj_E) {
            if (!cnpj_E.isEmpty()) {
                this.cnpj_E = cnpj_E;
            }
        }

        public String getSenha_E(){
            return this.senha_E;
        }

        public void setSenha_E(String senha_E) {
            if (!senha_E.isEmpty()) {
                this.senha_E = senha_E;
            }
        }

        public String getConfirmasenha_E(){
            return this.confirmasenha_E;
        }

        public void setConfirmasenha_E(String confirmasenha_E) {
            if (!confirmasenha_E.isEmpty()) {
                this.confirmasenha_E = confirmasenha_E;
            }
        }

        @Override
        public int hashCode(){
            return this.id_E;
        }
    }
}