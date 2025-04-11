package com.example.pantallas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int DURACION_SPLASH = 1500; // 1.5 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            SharedPreferences prefs = getSharedPreferences("datos_usuario", MODE_PRIVATE);
            String categoria = prefs.getString("categoria", "");

            Intent intent;
            switch (categoria) {
                case "Deportes":
                    intent = new Intent(this, DeportesActivity.class);
                    break;
                case "Música":
                    intent = new Intent(this, MusicaActivity.class);
                    break;
                case "Cine":
                    intent = new Intent(this, CineActivity.class);
                    break;
                default:
                    intent = new Intent(this, MainActivity.class);
                    break;
            }

            startActivity(intent);
            finish();
        }, DURACION_SPLASH);
    }
}
