package com.example.pantallas;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    // 1. Verifica que el nombre del paquete sea correcto
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.pantallas", appContext.getPackageName());
    }

    // 2. Verifica que los SharedPreferences se guardan correctamente
    @Test
    public void testSharedPreferencesGuardado() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        SharedPreferences prefs = context.getSharedPreferences("datos_usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("nombre", "Carlos");
        editor.putString("edad", "25");
        editor.putString("categoria", "Música");
        editor.apply();

        assertEquals("Carlos", prefs.getString("nombre", null));
        assertEquals("25", prefs.getString("edad", null));
        assertEquals("Música", prefs.getString("categoria", null));
    }

    // 3. Verifica que los campos no estén vacíos (simulado)
    @Test
    public void testCamposRequeridosNoVacios() {
        String nombre = "Ana";
        String edad = "30";

        assertNotNull(nombre);
        assertFalse(nombre.trim().isEmpty());

        assertNotNull(edad);
        assertFalse(edad.trim().isEmpty());
    }

    // 4. Verifica que la categoría seleccionada sea válida
    @Test
    public void testCategoriaValida() {
        String categoriaSeleccionada = "Cine";
        String[] categoriasValidas = {"Deportes", "Música", "Cine"};

        boolean esValida = false;
        for (String c : categoriasValidas) {
            if (c.equalsIgnoreCase(categoriaSeleccionada)) {
                esValida = true;
                break;
            }
        }

        assertTrue(esValida);
    }
}
