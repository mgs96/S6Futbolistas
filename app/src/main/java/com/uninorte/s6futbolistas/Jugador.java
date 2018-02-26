package com.uninorte.s6futbolistas;

import java.io.Serializable;

/**
 * Created by Visitante on 26/02/2018.
 */

public class Jugador implements Serializable {
    private String nombre;
    private String apellido;
    private String posicion;
    private boolean comvocado;
    private int edad;

    public Jugador(String nombre, String apellido, String posicion, boolean comvocado, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.comvocado = comvocado;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isComvocado() {
        return comvocado;
    }

    public void setComvocado(boolean comvocado) {
        this.comvocado = comvocado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
