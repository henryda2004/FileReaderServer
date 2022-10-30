package com.example.text_finder;

public class NodoAVL {
    String palabra;
    String archivo;
    int posicion, fe;
    NodoAVL hijoIzquierdo, hijoDerecho;

    public NodoAVL(String palabra, String archivo, int posicion){
        this.palabra = palabra;
        this.archivo = archivo;
        this.posicion = posicion;
        this.fe = 0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }


}
