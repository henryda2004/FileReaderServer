package com.example.text_finder;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.text_finder.Main.documentToSendArrayList;

/**
 * ordena mediante radix la cantidad de palabras
 */
public class WordsRadixSort {
    /**
     * obtiene el mayor valor de la lista
     * @param arr
     * @param n
     * @return
     */
    static int getMax(String[] arr, int n)
    {
        int mx = Integer.parseInt(arr[0]);
        for (int i = 1; i < n; i++)
            if (Integer.parseInt(arr[i]) > mx)
                mx = Integer.parseInt(arr[i]);
        return mx;
    }

    /**
     * cuenta el digito que se va arreglando
     * @param arr
     * @param n
     * @param exp
     */
    static void countSort(String[] arr, int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);


        for (i = 0; i < n; i++)
            count[(Integer.parseInt(arr[i]) / exp) % 10]++;


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];



        for (i = n - 1; i >= 0; i--) {
            output[count[(Integer.parseInt(arr[i]) / exp) % 10] - 1] = Integer.parseInt(arr[i]);
            count[(Integer.parseInt(arr[i]) / exp) % 10]--;

        }

        for (i = 0; i < n; i++)
            arr[i] = String.valueOf(output[i]);


    }

    /**
     * ejecuta radix principal
     */
    static void radixsort()
    {
        String palabras = "";
        for (int i = 0; i < documentToSendArrayList.size(); i++){
            palabras = palabras + documentToSendArrayList.get(i).getWordsAm() + " "  ;
        }
        String[] arr = palabras.split(" ");
        String[] nodos = palabras.split(" ");
        for(int i = 0; i < arr.length; i++){
            System.out.println("word["+i+"] = " +arr[i]);
        }
        int n = arr.length;

        int m = getMax(arr, n);


        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        RadixBubbleSortExtension nr = new RadixBubbleSortExtension();
        nr.DateBubbleSort();
    }


}
