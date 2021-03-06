package com.example.om84.go.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.om84.go.activity.DetalleActivity;
import com.example.om84.go.R;
import com.example.om84.go.domain.Rutina;

import java.util.List;

/**
 * Created by dmolina on 09/10/2016.
 */

public class RutinaAdapter extends RecyclerView.Adapter<RutinaAdapter.RutinaViewHolder> {
    private List<Rutina> items;

    public static class RutinaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public View view;
        public ImageView imagen;
        public TextView nombre;
        public TextView detalle;

        public RutinaViewHolder(View v) {
            super(v);
            view = v;

            imagen = (ImageView) v.findViewById(R.id.imgEjercicio);
            nombre = (TextView) v.findViewById(R.id.tvNombreRutina);
            detalle = (TextView) v.findViewById(R.id.tvDetalleRutina);

            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetalleActivity.class);
                    intent.putExtra("nombreRutina", nombre.getText().toString());
                    intent.putExtra("detalleRutina", detalle.getText().toString());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    public RutinaAdapter(List<Rutina> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RutinaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rutina_card, viewGroup, false);
        return new RutinaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RutinaViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.detalle.setText("Ejercicios:"+String.valueOf(items.get(i).getDetalle()));
    }
}
