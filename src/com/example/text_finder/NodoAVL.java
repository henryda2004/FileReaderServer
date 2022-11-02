package com.example.text_finder;

/**
 * Contiene nodo avl
 */
public class NodoAVL {
    String palabra;
    String archivo;
    int posicion, fe;

    /**
     * obtiene comparaciones avl
     * @return
     */
    public int getComparisonsAvl() {
        return comparisonsAvl;
    }

    /**
     * setcomparisons
     * @param comparisonsAvl
     */
    public void setComparisonsAvl(int comparisonsAvl) {
        this.comparisonsAvl = comparisonsAvl;
    }

    int comparisonsAvl;

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
     * get Fe
     * @return
     */
    public int getFe() {
        return fe;
    }

    /**
     * SetFe
     * @param fe
     */
    public void setFe(int fe) {
        this.fe = fe;
    }

    /**
     * gethijo izquierdo
     * @return
     */

    public NodoAVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    /**
     * sethijo derecho
     * @param hijoIzquierdo
     */
    public void setHijoIzquierdo(NodoAVL hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    /**
     * gethijoderecho
     * @return
     */
    public NodoAVL getHijoDerecho() {
        return hijoDerecho;
    }

    /**
     * sethijoderecho
     * @param hijoDerecho
     */
    public void setHijoDerecho(NodoAVL hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    NodoAVL hijoIzquierdo, hijoDerecho;

    /**
     * constructor
     * @param palabra
     * @param archivo
     * @param posicion
     * @param comparisonsAvl
     */
    public NodoAVL(String palabra, String archivo, int posicion, int comparisonsAvl){
        this.palabra = palabra;
        this.archivo = archivo;
        this.posicion = posicion;
        this.comparisonsAvl = comparisonsAvl;
        this.fe = 0;

        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    /**
     * devuelve el valor de nodo
     * @return
     */
    public String toString (){
        return "Su palabra es " + palabra + "su archivo es " + archivo + "y su posicion es " + posicion + "y el numero de comparaciones avl es: " + comparisonsAvl;
    }
}
