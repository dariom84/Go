package com.example.om84.go.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

import com.example.om84.go.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class NuevaActivity extends AppCompatActivity {

    private static final String TAG = "Debug";

    private Button nuevaRutina;
    private EditText txtNombre, txtCantEjercicios;
	
	private static final String strJson = "{" +
		"\"rutinas\": [" +
				"{\"nombre\": \"Dia 1\",\"cant_ejercicios\": \"9\"}," +
				"{\"nombre\": \"Dia 2\",\"cant_ejercicios\": \"8\"}," +
				"{\"nombre\": \"Dia 3\",\"cant_ejercicios\": \"10\"}" +
			"]" +
		"}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_rutina);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCantEjercicios = (EditText) findViewById(R.id.txtCantEjercicios);

        nuevaRutina = (Button) findViewById(R.id.btnNuevaRutina);
        nuevaRutina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rutinaNueva();
            }
        });

    }

    public void rutinaNueva(){
        try {
            SharedPreferences datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
            String rutinas = datos.getString("rutinas", "{\"rutinas\": []}");

            JSONObject object = new JSONObject(rutinas);
            JSONArray arrayJson = object.getJSONArray("rutinas");

            object.put("nombre", txtNombre.getText().toString());
            object.put("cant_ejercicios", txtCantEjercicios.getText().toString());

            arrayJson.put(object);

            //String s = arrayJson.toString();

            String rutina_nombre;
            String rutina_cantEjercicios;
            String strJsonRutinas = "{\"rutinas\": [";

            for (int i = 0; i < arrayJson.length(); i++) {
                JSONObject jasonobject = arrayJson.getJSONObject(i);
                rutina_nombre = jasonobject.getString("nombre");
                rutina_cantEjercicios = jasonobject.getString("cant_ejercicios");

                if (i != arrayJson.length()-1) {
                    strJsonRutinas = strJsonRutinas + "{\"nombre\": \"" + rutina_nombre + "\",\"cant_ejercicios\": \"" + rutina_cantEjercicios + "\"},";
                } else {
                    strJsonRutinas = strJsonRutinas + "{\"nombre\": \"" + rutina_nombre + "\",\"cant_ejercicios\": \"" + rutina_cantEjercicios + "\"}";
                }
            }

            strJsonRutinas = strJsonRutinas + "]}";

            SharedPreferences.Editor editor = datos.edit();
            editor.putString("rutinas", strJsonRutinas);
            editor.commit();

            Intent aRutina = new Intent(NuevaActivity. this,RutinasActinity.class);
            startActivity(aRutina);

        } catch (Exception e) {
            Log.d(TAG, "Error: " + e.getMessage());
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }

}
