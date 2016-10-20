package com.example.om84.go.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.om84.go.R;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_rutina);

        TextView tvNombreRutina = (TextView) findViewById(R.id.tvNombreRutina);
        TextView tvDetalleRutina = (TextView) findViewById(R.id.tvDetalleRutina);

        Bundle parametros = getIntent().getExtras();

        tvNombreRutina.setText(parametros.getString("nombreRutina"));
        tvDetalleRutina.setText(parametros.getString("detalleRutina"));
    }
}
