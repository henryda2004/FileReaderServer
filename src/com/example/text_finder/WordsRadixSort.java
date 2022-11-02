package com.example.text_finder;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.text_finder.Main.documentToSendArrayList;

public class WordsRadixSort {
    // A utility function to get maximum value in arr[]
    static int getMax(String[] arr, int n)
    {
        int mx = Integer.parseInt(arr[0]);
        for (int i = 1; i < n; i++)
            if (Integer.parseInt(arr[i]) > mx)
                mx = Integer.parseInt(arr[i]);
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(String[] arr, int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(Integer.parseInt(arr[i]) / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];


        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(Integer.parseInt(arr[i]) / exp) % 10] - 1] = Integer.parseInt(arr[i]);
            count[(Integer.parseInt(arr[i]) / exp) % 10]--;

        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = String.valueOf(output[i]);


    }

    // The main function to that sorts arr[] of
    // size n using Radix Sort
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
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        RadixBubbleSortExtension nr = new RadixBubbleSortExtension();
    }


}
