public class NodoBinario {
    String palabra;
    String archivo;
    int posicion;

    NodoBinario hijoIzquierdo, hijoDerecho;

    public NodoBinario(String palabra, String archivo, int posicion) {
        this.palabra = palabra;
        this.archivo = archivo;
        this.posicion = posicion;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public String toString (){
        return palabra + "su archivo es" + archivo + "y su posicion es" + posicion;
    }

}
