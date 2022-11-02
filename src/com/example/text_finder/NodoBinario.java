package com.example.text_finder;

public class NodoBinario {
    String palabra;
    String archivo;
    int posicion;

    public int getBinaryComparisons() {
        return binaryComparisons;
    }

    public void setBinaryComparisons(int binaryComparisons) {
        this.binaryComparisons = binaryComparisons;
    }

    public int getAvlComparisons() {
        return avlComparisons;
    }

    public void setAvlComparisons(int avlComparisons) {
        this.avlComparisons = avlComparisons;
    }

    int binaryComparisons;
    int avlComparisons;

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


    public NodoBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoBinario getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    NodoBinario hijoIzquierdo, hijoDerecho;

    public NodoBinario(String palabra, String archivo, int posicion, int binaryComparisons, int avlComparisons) {
        this.palabra = palabra;
        this.archivo = archivo;
        this.posicion = posicion;
        this.binaryComparisons = binaryComparisons;
        this.avlComparisons = avlComparisons;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public String toString (){
        return "Su palabra es " + palabra + "su archivo es " + archivo + "y su posicion es " + posicion + "Binary: " + binaryComparisons  + "AVL: " + avlComparisons;
    }

}
