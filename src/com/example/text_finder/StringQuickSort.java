package com.example.text_finder;

import java.util.ArrayList;

import static com.example.text_finder.Main.documentToSendArrayList;

/**
 * ordena por nombre en quicksort
 */
public class StringQuickSort {

    String names[];
    int length;

    /**
     * ejecuta ordenamiento principal
     */
    void sort() {
        String palabras = "";
        for (int i = 0; i < documentToSendArrayList.size(); i++){
            palabras = palabras + documentToSendArrayList.get(i).getName() + " "  ;
        }
        String[] array = palabras.split(" ");
        for(int i = 0; i < array.length; i++){
            System.out.println("word["+i+"] = " +array[i]);
        }
        if (array == null || array.length == 0) {
            return;
        }
        this.names = array;
        this.length = array.length;
        quickSort(0, length - 1);
    }

    /**
     * hace iteraciones de metodo
     * @param lowerIndex
     * @param higherIndex
     */
    void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.names[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (this.names[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.names[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }
        //call quickSort recursively
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    }

    /**
     * intercambia nodos
     * @param i
     * @param j
     */
    void exchangeNames(int i, int j) {
        String temp = this.names[i];
        this.names[i] = this.names[j];
        this.names[j] = temp;

        DocumentToSend tempD = documentToSendArrayList.get(i);
        documentToSendArrayList.set(i, documentToSendArrayList.get(j));
        documentToSendArrayList.set(j, tempD);
    }
}