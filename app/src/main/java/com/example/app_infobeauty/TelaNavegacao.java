package com.example.app_infobeauty;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;
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
    private final int ID_Search = 2;
    private final int ID_Calendar = 3;
    private final int ID_Profile = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTelaNavegacaoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarTelaNavegacao.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_profile, R.id.nav_dicas, R.id.nav_configure, R.id.nav_help)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tela_navegacao);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottonNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Home, R.drawable.ic_nav_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Search, R.drawable.ic_nav_search));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Calendar, R.drawable.ic_nav_calendar));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Profile, R.drawable.ic_nav_profile));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(TelaNavegacao.this, "clicked item: " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                String name;
                switch (item.getId()){
                    case ID_Home: name = "Home";
                        break;

                    case ID_Search: name = "Search";
                        break;

                    case ID_Calendar: name = "Calendar";
                        break;

                    case ID_Profile: name = "Profile";
                        break;

                    default: name = "";
                }
                //selected_page.setText(getString(R.string.navegacao_page_selected, name));
            }
        });

        bottomNavigation.setCount(ID_Profile, "+");
        bottomNavigation.show(ID_Home, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_navegacao, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_tela_navegacao);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}