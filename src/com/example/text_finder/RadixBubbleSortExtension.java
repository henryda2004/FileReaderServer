package com.example.text_finder;

import static com.example.text_finder.Main.documentToSendArrayList;

/**
 * metodo de copia de lista radix a nodos con metodo bubble
 */
public class RadixBubbleSortExtension {
    /**
     * metodo bubble
     */
    void DateBubbleSort(){
        String palabras = "";
        for (int i = 0; i < documentToSendArrayList.size(); i++){
            palabras = palabras + documentToSendArrayList.get(i).getWordsAm() + " "  ;
        }
        String[] array = palabras.split(" ");


        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (Integer.parseInt(array[j]) > Integer.parseInt(array[j + 1])) {
                    // swap arr[j+1] and arr[j]
                    int temp = Integer.parseInt(array[j]);
                    array[j] = array[j + 1];
                    array[j + 1] = String.valueOf(temp);

                    DocumentToSend tempN = documentToSendArrayList.get(j);
                    documentToSendArrayList.set(j, documentToSendArrayList.get(j + 1));
                    documentToSendArrayList.set(j + 1, tempN);
                }
    }

}

