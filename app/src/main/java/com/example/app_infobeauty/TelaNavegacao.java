package com.example.app_infobeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class TelaNavegacao extends AppCompatActivity {

    private final int ID_Home = 1;
    private final int ID_Search = 2;
    private final int ID_Calendar = 3;
    private final int ID_Profile = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_navegacao);

        TextView selected_page = findViewById(R.id.selected_pagina);
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
                selected_page.setText(getString(R.string.navegacao_page_selected, name));
            }
        });

        bottomNavigation.setCount(ID_Profile, "+");
        bottomNavigation.show(ID_Home, true);
    }
}