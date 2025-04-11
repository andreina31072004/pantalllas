package com.example.pantallas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText nombreEditText, edadEditText;
    Spinner categoriaSpinner;
    Button guardarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreEditText = findViewById(R.id.editNombre);
        edadEditText = findViewById(R.id.editEdad);
        categoriaSpinner = findViewById(R.id.spinnerCategoria);
        guardarBtn = findViewById(R.id.btnGuardar);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorias_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categoriaSpinner.setAdapter(adapter);

        guardarBtn.setOnClickListener(v -> {
            String nombre = nombreEditText.getText().toString();
            String edad = edadEditText.getText().toString();
            String categoria = categoriaSpinner.getSelectedItem().toString();

            SharedPreferences prefs = getSharedPreferences("datos_usuario", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("nombre", nombre);
            editor.putString("edad", edad);
            editor.putString("categoria", categoria);
            editor.apply();

            Intent intent = new Intent(MainActivity.this, SplashScreen.class);
            startActivity(intent);
            finish();
        });
    }
}
