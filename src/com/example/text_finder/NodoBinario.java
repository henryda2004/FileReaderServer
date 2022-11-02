package com.example.text_finder;

/**
 * Contiene nodo binario
 */
public class NodoBinario {
    String palabra;
    String archivo;
    int posicion;

    /**
     * getbinarycomparisons
     * @return
     */
    public int getBinaryComparisons() {
        return binaryComparisons;
    }

    /**
     * setbinarycomparisons
     * @param binaryComparisons
     */
    public void setBinaryComparisons(int binaryComparisons) {
        this.binaryComparisons = binaryComparisons;
    }

    /**
     * getavlcomparisons
     * @return
     */
    public int getAvlComparisons() {
        return avlComparisons;
    }

    /**
     * setavlcomparisons
     * @param avlComparisons
     */
    public void setAvlComparisons(int avlComparisons) {
        this.avlComparisons = avlComparisons;
    }

    int binaryComparisons;
    int avlComparisons;

    /**
     * getpalabra
     * @return
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * setpalabra
     * @param palabra
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * getarchivo
     * @return
     */
    public String getArchivo() {
        return archivo;
    }

    /**
     * setarchivo
     * @param archivo
     */
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    /**
     * getposicion
     * @return
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * setposicion
     * @param posicion
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * gethijoizquierdo
     * @return
     */
    public NodoBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    /**
     * sethijoizquierdo
     * @param hijoIzquierdo
     */
    public void setHijoIzquierdo(NodoBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    /**
     * gethijoderecho
     * @return
     */
    public NodoBinario getHijoDerecho() {
        return hijoDerecho;
    }

    /**
     * sethijoderecho
     * @param hijoDerecho
     */
    public void setHijoDerecho(NodoBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    NodoBinario hijoIzquierdo, hijoDerecho;

    /**
     * constructor
     * @param palabra
     * @param archivo
     * @param posicion
     * @param binaryComparisons
     * @param avlComparisons
     */
    public NodoBinario(String palabra, String archivo, int posicion, int binaryComparisons, int avlComparisons) {
        this.palabra = palabra;
        this.archivo = archivo;
        this.posicion = posicion;
        this.binaryComparisons = binaryComparisons;
        this.avlComparisons = avlComparisons;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    /**
     * retorna calor de nodo
     * @return
     */
    public String toString (){
        return "Su palabra es " + palabra + "su archivo es " + archivo + "y su posicion es " + posicion + "Binary: " + binaryComparisons  + "AVL: " + avlComparisons;
    }

}
