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
    ListView lista;
    Intent intent;
    public static final int ACTIVITY_REQUEST_EMPRESA = 1;
    private EmpresaDAO dao ;
    private String[] empresa;
    private long[] idEmpresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_navegacao_empresa);

        lista = (ListView) findViewById(R.id.lista);
        setTitle("Banco de Dados com SQLite!");
        dao = new EmpresaDAO(this);
        dao.open();
        lista.setOnItemClickListener((AdapterView.OnItemClickListener) this); // Para o clique no item

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
        protected void onResume () {
            dao.open ();
            super.onResume ();
            List<com.example.app_infobeauty.empresa.Empresa> listaEmpresas = dao.getAll();
            empresa = new String[listaEmpresas.size()];
            idEmpresa = new long[listaEmpresas.size()];
            int i =0;
            Iterator<com.example.app_infobeauty.empresa.Empresa> iterator = listaEmpresas.iterator();
            while (iterator.hasNext()) {
                com.example.app_infobeauty.empresa.Empresa aux = new com.example.app_infobeauty.empresa.Empresa();
                aux = (com.example.app_infobeauty.empresa.Empresa) iterator.next();
                empresa[i] = aux.textoLista();  // relaciona os itens da lista
                idEmpresa[i] = aux.getId();   // com o id do item na tabela
                i++;
            }
            ArrayAdapter<String > adapter = new ArrayAdapter<String >( this ,  android.R.layout.simple_list_item_1 , empresa );
            lista.setAdapter( adapter );
        }
        @Override
        protected void onPause() {
            dao.close();
            super.onPause();
        }
        public void onItemClick(AdapterView<?> parent, View view, int position, long ident) {
            long id = idEmpresa[position];
            intent = new Intent(getApplicationContext(), ServicosEmpresas.class);
            intent.putExtra("acao", 0);// alteração ou exclusão
            intent.putExtra("id", id);// passa o id do registro para busca e preenchimento da tela
            startActivity(intent);
        }
        public void incluirDisciplina(View v) {
            intent = new Intent(getApplicationContext(), ServicosEmpresas.class);
            intent.putExtra("acao", -1);
            intent.putExtra("id", 0L);
            startActivity(intent);
        }
        public void sair(View v) {
            finish();
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