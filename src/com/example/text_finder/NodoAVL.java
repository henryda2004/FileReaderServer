package com.example.text_finder;

public class NodoAVL {
    String palabra;
    String archivo;
    int posicion, fe;

    public int getComparisonsAvl() {
        return comparisonsAvl;
    }

    public void setComparisonsAvl(int comparisonsAvl) {
        this.comparisonsAvl = comparisonsAvl;
    }

    int comparisonsAvl;

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }


    public NodoAVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoAVL hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoAVL getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoAVL hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    NodoAVL hijoIzquierdo, hijoDerecho;

    public NodoAVL(String palabra, String archivo, int posicion, int comparisonsAvl){
        this.palabra = palabra;
        this.archivo = archivo;
        this.posicion = posicion;
        this.comparisonsAvl = comparisonsAvl;
        this.fe = 0;

        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public String toString (){
        return "Su palabra es " + palabra + "su archivo es " + archivo + "y su posicion es " + posicion + "y el numero de comparaciones avl es: " + comparisonsAvl;
    }
}
