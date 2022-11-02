package com.example.text_finder;

import java.util.ArrayList;

import static com.example.text_finder.Main.arbolBinario;

public class ArbolBinario {
    NodoBinario raiz;
    public ArbolBinario(){
        raiz = null;
    }
    //Metodo para insertar nodo
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
    public NodoBinario estaVacio(){
        return raiz = null;
    }
    //Metodo para recorrer el arbol Infijo
    static ArrayList<NodoBinario> list = new ArrayList<NodoBinario>();
    public void inOrden(NodoBinario r, String palabra, ArrayList<NodoBinario> lista){
        if ((r != null) && r.palabra.equalsIgnoreCase(palabra)){
            lista.add(r);
        }
        if(r != null){
            inOrden(r.hijoIzquierdo, palabra, lista);
            System.out.println(r.palabra);
            inOrden(r.hijoDerecho, palabra, lista);
        }
    }
    //Metodo para buscar un nodo en el arbol
    static int comparisonsBinary = 1;
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
