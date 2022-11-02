package com.example.text_finder;

import java.util.ArrayList;

import static com.example.text_finder.Main.arbolBinario;

/**
 * contiene arbol binario y metodos
 */
public class ArbolBinario {
    NodoBinario raiz;

    /**
     * inicializa arbol
     */
    public ArbolBinario(){
        raiz = null;
    }
    //Metodo para insertar nodo

    /**
     * agrega nodo binario
     * @param palabra
     * @param archivo
     * @param posicion
     */
    public void agregarNodoBinario(String palabra, String archivo, int posicion){
        NodoBinario nuevo = new NodoBinario(palabra, archivo, posicion, 0, 0);
        if(raiz == null){
            raiz = nuevo;
        } else {
            NodoBinario auxiliar = raiz;
            NodoBinario padre;
            while (true){
                padre = auxiliar;
                if (palabra.compareTo(auxiliar.palabra) <= 0){
                    auxiliar = auxiliar.hijoIzquierdo;
                    if(auxiliar == null){
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }

                }else {
                    auxiliar = auxiliar.hijoDerecho;
                    if(auxiliar == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    //Metodo para saber si el arbol esta vacio


    static ArrayList<NodoBinario> list = new ArrayList<NodoBinario>();
    //Metodo para buscar un nodo en el arbol
    static int comparisonsBinary = 1;

    /**
     * busca nodo
     * @param aux
     * @param palabra
     * @param lista
     */
    public void buscarNodo(NodoBinario aux, String palabra, ArrayList<NodoBinario> lista){

        if (aux != null) {

            if (aux.palabra.equalsIgnoreCase(palabra)){
                aux.binaryComparisons = comparisonsBinary;
                lista.add(aux);
                aux = aux.hijoIzquierdo;
                comparisonsBinary = 1;
                buscarNodo(aux, palabra, lista);
            } else {
                if(palabra.compareTo(aux.palabra) <= 0){
                    aux = aux.hijoIzquierdo;
                } else {
                    aux = aux.hijoDerecho;
                }
                comparisonsBinary++;
                buscarNodo(aux, palabra, lista);
            }
        }
    }


}
