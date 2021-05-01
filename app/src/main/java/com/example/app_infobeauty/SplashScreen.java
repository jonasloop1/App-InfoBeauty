package com.example.app_infobeauty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarTelaInicial();
            }
        }, 200);
    }

    private void mostrarTelaInicial() {
        Intent intent = new Intent(
                SplashScreen.this,TelaInicial.class);
        startActivity(intent);
        finish();
    }
}