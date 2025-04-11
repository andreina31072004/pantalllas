package com.example.pantallas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edt_usuario;
    Button btn_iniciar;
public static final String dataUserCache = "dataUser";
    private static final int  mode_Private = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_usuario = findViewById(R.id.edt_usuario);
        btn_iniciar = findViewById(R.id.btn_iniciar);

        sharedPreferences = getSharedPreferences(dataUserCache,mode_Private);
        editor = sharedPreferences.edit();

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();

            }
        });

        private void validar(){
            String usuario;

            usuario =edt_usuario.getText().toString();

        }




        };
    }
