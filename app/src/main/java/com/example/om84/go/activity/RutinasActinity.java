package com.example.om84.go.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.om84.go.R;
import com.example.om84.go.adapter.RutinaAdapter;
import com.example.om84.go.domain.Rutina;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class RutinasActinity extends AppCompatActivity {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private static final String TAG = "Debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);

        actualizarRutinas();

        //Boton nueva rutina
        FloatingActionButton nuevaRutina = (FloatingActionButton) findViewById(R.id.fabAgregarRutina);
        nuevaRutina.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                agregarRutina();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        actualizarRutinas();
    }

    public void actualizarRutinas(){
        List<Rutina> items = new ArrayList<>();

        try {
            SharedPreferences datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
            String rutinas = datos.getString("rutinas", "");

            JSONObject object = new JSONObject(rutinas);
            JSONArray arrayJson = object.getJSONArray("rutinas");

            String rutina_nombre;
            String rutina_cantEjercicios;

            for (int i = 0; i < arrayJson.length(); i++)
            {
                JSONObject jasonobject  = arrayJson.getJSONObject(i);
                rutina_nombre = jasonobject.getString("nombre");
                rutina_cantEjercicios = jasonobject.getString("cant_ejercicios");

                items.add(new Rutina(R.drawable.pesas, rutina_nombre, Integer.parseInt(rutina_cantEjercicios)));
            }

        } catch (Exception e) {
            Log.d(TAG, "Error: " + e.getMessage());
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.rvRutina);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new RutinaAdapter(items);
        recycler.setAdapter(adapter);
    }

    public void agregarRutina(){
        Intent aRutina = new Intent(RutinasActinity.this,NuevaActivity.class);
        startActivity(aRutina);
    }
}
