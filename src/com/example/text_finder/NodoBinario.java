package com.example.text_finder;

public class NodoBinario {
    String palabra;
    String archivo;
    int posicion;

    boolean visitado;
    boolean confirmarExistencia;

    NodoBinario hijoIzquierdo, hijoDerecho;

    public NodoBinario(String palabra, String archivo, int posicion, boolean visitado, boolean confirmarExistencia) {
        this.palabra = palabra;
        this.archivo = archivo;
        this.posicion = posicion;
        this.visitado = false;
        this.confirmarExistencia = false;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public String toString (){
        return palabra + "su archivo es" + archivo + "y su posicion es" + posicion;
    }

}
