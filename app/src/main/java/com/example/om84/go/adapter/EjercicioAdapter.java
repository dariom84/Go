package com.example.om84.go.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.om84.go.R;
import com.example.om84.go.activity.DetalleActivity;
import com.example.om84.go.domain.Ejercicio;

import java.util.List;

/**
 * Created by dmolina on 09/10/2016.
 */

public class EjercicioAdapter extends RecyclerView.Adapter<EjercicioAdapter.EjercicioViewHolder> {
    private List<Ejercicio> items;

    public static class EjercicioViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public View view;
        public ImageView imagen;
        public TextView nombre;

        public EjercicioViewHolder(View v) {
            super(v);
            view = v;

            imagen = (ImageView) v.findViewById(R.id.imgEjercicio);
            nombre = (TextView) v.findViewById(R.id.tvNombreEjercicio);

            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetalleActivity.class);
                    intent.putExtra("nombreEjercicio", nombre.getText().toString());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public EjercicioAdapter(List<Ejercicio> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public EjercicioViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ejercicio_card, viewGroup, false);
        return new EjercicioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EjercicioViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
    }
}
