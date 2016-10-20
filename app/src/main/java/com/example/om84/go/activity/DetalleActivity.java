package com.example.om84.go.activity;

import android.icu.util.Calendar;
import android.net.sip.SipAudioCall;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


import com.example.om84.go.R;

public class DetalleActivity extends AppCompatActivity {
    Chronometer focus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_rutina);

        TextView tvNombreRutina = (TextView) findViewById(R.id.tvNombreRutina);
        TextView tvDetalleRutina = (TextView) findViewById(R.id.tvDetalleRutina);

        Bundle parametros = getIntent().getExtras();

        tvNombreRutina.setText(parametros.getString("nombreRutina"));
        tvDetalleRutina.setText(parametros.getString("detalleRutina"));

        final Button start = (Button) findViewById(R.id.startRutina);
        focus = new Chronometer (DetalleActivity.this);
        final TextView chronometer = (TextView) findViewById(R.id.displayChronometer);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                focus.start();
                chronometer.setText(focus.getText());


            }
        });
    }

}
