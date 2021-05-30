package com.example.app_infobeauty;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_infobeauty.databinding.ActivityTelaNavegacaoBinding;

public class TelaNavegacao extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityTelaNavegacaoBinding binding;
    private final int ID_Home = 1;
    private final int ID_Location = 2;
    private final int ID_Calendar = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTelaNavegacaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarTelaNavegacao.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_profile, R.id.nav_minha_agenda, R.id.nav_dicas, R.id.nav_configure, R.id.nav_help, R.id.nav_exit)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tela_navegacao);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottonNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Home, R.drawable.ic_nav_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Location, R.drawable.ic_nav_location));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Calendar, R.drawable.ic_nav_calendario));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentHome()).commit();

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(getApplicationContext(), "clicked item: " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                Fragment seleciona_fragment = null;
                String name;
                switch (item.getId()) {
                    case ID_Home:
                        name = "Home";
                        seleciona_fragment = new FragmentHome();
                        break;

                    case ID_Location:
                        name = "location";
                        seleciona_fragment = new FragmentLocation();
                        break;

                    case ID_Calendar:
                        name = "Calendar";
                        seleciona_fragment = new FragmentCalendar();
                        break;

                    default:
                        name = "";
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, seleciona_fragment).commit();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tela_navegacao);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.nav_profile){

        }else if(id == R.id.nav_minha_agenda){

        }else if(id == R.id.nav_dicas){

        }else if(id == R.id.nav_configure){

        }else if(id == R.id.nav_help){

        }else if(id == R.id.nav_exit){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}