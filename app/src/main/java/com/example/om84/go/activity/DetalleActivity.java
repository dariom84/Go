package com.example.om84.go.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.om84.go.R;
import com.example.om84.go.adapter.EjercicioAdapter;
import com.example.om84.go.adapter.RutinaAdapter;
import com.example.om84.go.domain.Ejercicio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetalleActivity extends AppCompatActivity {

    public static final String MY_PREFERENCES = "GO_PREFERENCE" ;
    public static final int CREAR_EJERCICIO = 1;
    private RecyclerView recycler;
    private EjercicioAdapter adapter;
    private RecyclerView.LayoutManager lManager;

    private Context context;
    private List<Ejercicio> ejerciciosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_rutina);

        context = this;

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.tvDetalleEjercicio);
        recycler.setHasFixedSize(true);
        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        SharedPreferences sharedpreferences = getSharedPreferences(DetalleActivity.MY_PREFERENCES, Context.MODE_PRIVATE);
        Set<String> ejercicios =  sharedpreferences.getStringSet("exerciseLists", new HashSet<String>());
        ejerciciosList = new ArrayList<Ejercicio>();


        for(String s: ejercicios){
            String fields[] = s.split("<->");
            ejerciciosList.add(new Ejercicio(0, fields[0], fields[1], fields[2], fields[3]));
        }

        // Crear un nuevo adaptador
        adapter = new EjercicioAdapter(ejerciciosList);
        recycler.setAdapter(adapter);

        TextView tvNombreRutina = (TextView) findViewById(R.id.tvNombreRutina);
        TextView tvDetalleRutina = (TextView) findViewById(R.id.tvDetalleRutina);

        Bundle parametros = getIntent().getExtras();


        FloatingActionButton addJokeButton = (FloatingActionButton) findViewById(R.id.fabAgregarEjercicio);
        assert addJokeButton != null;
        addJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ejercicioIntent = new Intent(context, EjercicioActivity.class);
                startActivityForResult(ejercicioIntent, CREAR_EJERCICIO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREAR_EJERCICIO) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String ejercicio = data.getStringExtra("ejercicio");
                String fields[] = ejercicio.split("<->");
                ejerciciosList.add(new Ejercicio(0, fields[0], fields[1], fields[2], fields[3]));
            }
        }
    }
}
