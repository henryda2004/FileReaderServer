public class ArbolBinario {
    NodoBinario raiz;
    public ArbolBinario(){
        raiz = null;
    }
    //Metodo para insertar nodo
    public void agregarNodoBinario(String palabra, String archivo, int posicion){
        NodoBinario nuevo = new NodoBinario(palabra, archivo, posicion);
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
    public void inOrden(NodoBinario r){
        if(r != null){
            inOrden(r.hijoIzquierdo);
            System.out.println(r.palabra);
            inOrden(r.hijoDerecho);
        }
    }
    //Metodo para buscar un nodo en el arbol
    public NodoBinario buscarNodo(String palabra){
        NodoBinario aux = raiz;
        while (aux.palabra != palabra){
            if(palabra.compareTo(aux.palabra) <= 0){
                aux = aux.hijoIzquierdo;
            } else {
                aux = aux.hijoDerecho;
            }
            if(aux == null){
                return null;
            }
        }
        return aux;
    }

}
