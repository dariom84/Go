package com.example.om84.go.domain;

import java.io.Serializable;

/**
 * Created by dmolina on 09/10/2016.
 */

public class Ejercicio implements Serializable {
    private int imagen;
    private String nombre;
    private String duracion;
    private String repeticion;
    private String intervalo;

    public Ejercicio(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public Ejercicio(int imagen, String nombre, String duracion, String repeticion, String intervalo) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.duracion = duracion;
        this.repeticion = repeticion;
        this.intervalo = intervalo;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(String repeticion) {
        this.repeticion = repeticion;
    }

    public String getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(String intervalo) {
        this.intervalo = intervalo;
    }
}
