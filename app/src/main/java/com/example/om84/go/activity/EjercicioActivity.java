package com.example.om84.go.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.om84.go.R;
import com.example.om84.go.domain.Ejercicio;

import java.util.HashSet;
import java.util.Set;

public class EjercicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio);

        final EditText title = (EditText) findViewById(R.id.title_exercise);
        final EditText duration = (EditText) findViewById(R.id.title_duration);
        final EditText repeat = (EditText) findViewById(R.id.title_repeat);
        final EditText interval = (EditText) findViewById(R.id.title_interval);

        Button createExercise = (Button) findViewById(R.id.create_excercise);
        createExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ejercioCreado = new String(title.getText().toString()+"<->"+duration.getText().toString()+"<->"+ repeat.getText().toString()+"<->"+ interval.getText().toString());
                Intent returnIntent = new Intent();
                returnIntent.putExtra("ejercicio",ejercioCreado);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });


    }
}
