package com.example.text_finder;

import java.util.ArrayList;

/**
 * Contiene arbol avl
 */
public class ArbolAVL {

    private NodoAVL raiz;

    /**
     * incializa arbol
     */
    public ArbolAVL(){
        raiz = null;
    }

    //Buscar
    static ArrayList<NodoAVL> listAVL = new ArrayList<NodoAVL>();

    /**
     * busca en avl
     * @param aux
     * @param palabra
     * @param lista
     */
    public void buscar(NodoAVL aux, String palabra, ArrayList<NodoAVL> lista){

        if (aux != null) {

            if (aux.palabra.equalsIgnoreCase(palabra)){
                lista.add(aux);
                aux = aux.hijoDerecho;
                buscar(aux, palabra, lista);
            } else {
                if(palabra.compareTo(aux.palabra) <= 0){
                    aux = aux.hijoIzquierdo;
                } else {
                    aux = aux.hijoDerecho;
                }
                buscar(aux, palabra, lista);
            }


        }
    }

    //Obtener Factor de equilibrio

    /**
     * obtiene factor de equilibrio
     * @param x
     * @return
     */
    public int obtenerFE(NodoAVL x){
        if (x == null){
            return -1;
        }else{
            return x.fe;
        }
    }
    //Rotacion Simple Izquierda

    /**
     * rotacion simple izquierda
     * @param c
     * @return
     */
    public NodoAVL rotacionIzquierda(NodoAVL c){
        NodoAVL auxiliar = c.hijoIzquierdo;
        c.hijoIzquierdo = auxiliar.hijoDerecho;
        auxiliar.hijoDerecho = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }
    //Rotacion Simple Derecha

    /**
     * rotacion simple derecha
     * @param c
     * @return
     */
    public NodoAVL rotacionDerecha(NodoAVL c){
        NodoAVL auxiliar = c.hijoDerecho;
        c.hijoDerecho = auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo = c;
        c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho)) + 1;
        return auxiliar;
    }
    //Rotacion Doble a la Izquierda

    /**
     * rotacion doble izquierda
     * @param z
     * @return
     */
    public NodoAVL rotacionDobleIzquierda(NodoAVL z){
        NodoAVL auxiliar;
        z.hijoIzquierdo = rotacionDerecha(z.hijoIzquierdo);
        auxiliar = rotacionIzquierda(z);
        return auxiliar;
    }
    //Rotacion Doble a la Derecha

    /**
     * rotacion doble derecha
     * @param z
     * @return
     */
    public NodoAVL rotacionDobleDerecha(NodoAVL z){
        NodoAVL auxiliar;
        z.hijoDerecho = rotacionIzquierda(z.hijoDerecho);
        auxiliar = rotacionDerecha(z);
        return auxiliar;
    }
    //Metodo para insertar un nodo

    /**
     * insertar nodo
     * @param nuevo
     * @param subAr
     * @return
     */
    public NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subAr){
        NodoAVL nuevoPadre = subAr;
        if(nuevo.palabra.compareTo(subAr.palabra) <= 0){
            if(subAr.hijoIzquierdo == null){
                subAr.hijoIzquierdo = nuevo;
            } else {
                subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
                if ((obtenerFE(subAr.hijoIzquierdo) - obtenerFE(subAr.hijoDerecho)) == 2){
                    if(nuevo.palabra.compareTo(subAr.hijoIzquierdo.palabra) <= 0){
                        nuevoPadre = rotacionIzquierda(subAr);
                    }else {
                        nuevoPadre = rotacionDobleIzquierda(subAr);
                    }
                }
            }
        } else if (nuevo.palabra.compareTo(subAr.palabra) > 0){
            if(subAr.hijoDerecho == null){
                subAr.hijoDerecho = nuevo;
            }else {
                subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
                if((obtenerFE(subAr.hijoDerecho) - obtenerFE(subAr.hijoIzquierdo) == 2)) {
                    if (nuevo.palabra.compareTo(subAr.hijoDerecho.palabra) > 0){
                        nuevoPadre = rotacionDerecha(subAr);
                    }else{
                        nuevoPadre = rotacionDobleDerecha(subAr);
                    }
                }
            }
        }
        //Actualizando altura
        if((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null)){
            subAr.fe = subAr.hijoDerecho.fe + 1;
        } else if (subAr.hijoDerecho == null && subAr.hijoIzquierdo != null){
            subAr.fe = subAr.hijoIzquierdo.fe + 1;
        } else {
            subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho)) + 1;
        }
        return  nuevoPadre;
    }
    //Metodo para insertar

    /**
     * insertar archivo
     * @param palabra
     * @param archivo
     * @param posicion
     */
    public void insertar(String palabra, String archivo, int posicion){
        NodoAVL nuevo = new NodoAVL(palabra, archivo, posicion, 0);
        if (raiz == null){
            raiz = nuevo;
        }else {
            raiz = insertarAVL(nuevo, raiz);
        }
    }
    //Recorrido
    static int comparisonsAvl = 0;

    /**
     * recorrido in orden
     * @param r
     * @param palabra
     * @param lista
     */
    public void inOrden(NodoAVL r, String palabra, ArrayList<NodoAVL> lista){
        comparisonsAvl++;
        if ((r != null) && r.palabra.equalsIgnoreCase(palabra)){
            r.comparisonsAvl = comparisonsAvl;
            lista.add(r);
            comparisonsAvl = 0;
        }
        if(r != null){
            inOrden(r.hijoIzquierdo, palabra, lista);
            System.out.println(r.palabra);
            inOrden(r.hijoDerecho, palabra, lista);
        }
    }

    /**
     * obtiene raiz
     * @return
     */
    //Obtener raiz
    public NodoAVL obtenerRaiz(){
        return raiz;
    }
}
