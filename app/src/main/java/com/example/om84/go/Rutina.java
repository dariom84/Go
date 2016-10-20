package com.example.om84.go;

/**
 * Created by dmolina on 09/10/2016.
 */

public class Rutina {
    private int imagen;
    private String nombre;
    private int detalle;

    public Rutina(int imagen, String nombre, int detalle) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDetalle() {
        return detalle;
    }

    public int getImagen() {
        return imagen;
    }
}
