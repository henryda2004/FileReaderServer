package com.example.text_finder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.text_finder.ArbolAVL.listAVL;
import static com.example.text_finder.ArbolBinario.list;

/**
 * ejecuta el servidor
 */
public class Main {
    static ArbolBinario arbolBinario = new ArbolBinario();
    static ArbolAVL arbolAVL = new ArbolAVL();

    /**
     * inserta el contenido de todos los documentos en arboles
     * @param ci
     */
    public static void insertarEnArboles (ClientInformation ci){
        ArrayList<Document> listDocuments = ci.getLisDocuments();
        for (int i = 0; i < listDocuments.size(); i++){
            String[] content = listDocuments.get(i).getContent();
            for (int c = 0; c < content.length; c++){
                arbolBinario.agregarNodoBinario(content[c], listDocuments.get(i).getName(), c);
                arbolAVL.insertar(content[c], listDocuments.get(i).getName(), c);
            }
        }
        System.out.println("Nodos insertados correctamente");
    }

    /**
     * busca en los arboles las palabras solicitadas
     * @param toSearch
     */
    public static void buscarEnArboles (String[] toSearch){
        for (int i = 0; i < toSearch.length; i++){
            arbolBinario.buscarNodo(arbolBinario.raiz, toSearch[i], list);
            arbolAVL.inOrden(arbolAVL.obtenerRaiz(), toSearch[i], listAVL);

        }
        System.out.println("La lista de nodos binarios es:" + list);
        System.out.println("La lista de nodos AVL es:" + listAVL);
        for (int i = 0; i < list.size(); i++){
            for (int x = 0; x < listAVL.size(); x++){
                if(listAVL.get(x).posicion == list.get(i).posicion){
                    list.get(i).avlComparisons = listAVL.get(x).comparisonsAvl;
                }
            }
        }
        System.out.println("La lista de nodos binarios NUEVA es:" + list);
        System.out.println("Termino busqueda");
    }
    static ArrayList<DocumentToSend> documentToSendArrayList= new ArrayList<DocumentToSend>();

    /**
     * parsea los documentos normales a un tipo enviable al cliente
     * @param ci
     */
    private static void parsearEnDocumentosEnviables(ClientInformation ci) {
        ArrayList<Document> listDocuments = ci.getLisDocuments();
        for (int i = 0; i < listDocuments.size(); i++){
            String[] content = listDocuments.get(i).getContent();
            for (int c = 0; c < list.size(); c++){
                if (list.get(c).archivo == listDocuments.get(i).getName()){
                    documentToSendArrayList.add(new DocumentToSend(list.get(c).palabra, getLine(list.get(c).posicion, content), posicionNueva, getDate(listDocuments.get(i).getDate()), listDocuments.get(i).getDateInt(), listDocuments.get(i).getWords(), listDocuments.get(i).getName(), list.get(c).getBinaryComparisons(), list.get(c).getAvlComparisons()));
                }
            }
        }
        System.out.println(documentToSendArrayList);
    }

    /**
     * obtiene la fecha
     * @param date
     * @return
     */
    private static String getDate(long date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formatedDate = simpleDateFormat.format(date);
        return formatedDate;
    }

    static int posicionNueva = 0;

    /**
     * obtiene la linea en base a las ocurrencias
     * @param posicion
     * @param content
     * @return
     */
    private static String getLine(int posicion, String[] content) {
        String line;
        if (content.length < 10){
            posicionNueva = posicion;
            line = String.valueOf(content);
            return line;
        } else {
            if (posicion == 0){
                posicionNueva = posicion;
                line = content[0] + " " + content[1] + " " + content[2] + " " + content[3] + " " + content[4];
            }
            else if (posicion == 1){
                posicionNueva = posicion;
                line = content[0] + " " + content[1] + " " + content[2] + " " + content[3] + " " + content[4];
            }
            else if (posicion == (content.length - 1)){
                posicionNueva = 4;
                line = content[(content.length - 5)] + " " + content[(content.length - 4)] + " " + content[(content.length - 3)] + " " + content[(content.length - 2)] + " " + content[(content.length - 1)];
            }
            else if(posicion == (content.length - 2)){
                posicionNueva = 3;
                line = content[(content.length - 5)] + " " + content[(content.length - 4)] + " " + content[(content.length - 3)] + " " + content[(content.length - 2)] + " " + content[(content.length - 1)];
            } else{
                posicionNueva = 2;
                line = content[(content.length - 2)] + " " + content[(posicion - 1)] + " " + content[posicion] + " " + content[(content.length + 1)] + " " + content[(content.length + 2)];
            }
            return line;
        }
    }

    /**
     * ordena los documentos que se envian segun el metodo solicitado
     * @param ci
     */
    private static void ordenarDocumentosEnviables(ClientInformation ci) {
        if (ci.getSort().equalsIgnoreCase("Name")){
            StringQuickSort sorter = new StringQuickSort();
            sorter.sort();
        } else if (ci.getSort().equalsIgnoreCase("Date")){
            DateBubbleSort ob = new DateBubbleSort();

        } else {
            WordsRadixSort radixSort = new WordsRadixSort();
            radixSort.radixsort();
        }
        System.out.println("Lista ordenada" + documentToSendArrayList);

    }

    /**
     * ejecuta el socketserver
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        ObjectInputStream in;
        //ObjectOutputStream out;
        final int PORT = 5000;
        //Server
        try{
            serverSocket = new ServerSocket(PORT);
            System.out.println("server is on");


            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            in = new ObjectInputStream(clientSocket.getInputStream());
            //out = new ObjectOutputStream(clientSocket.getOutputStream());


            Object message = in.readObject();
            ClientInformation ci = (ClientInformation) message; //Informacion que me llega del servidor

            insertarEnArboles(ci); //Opero con la informacion que me llega del servidor y se genera un ArrayList con los documentos ordenados
            buscarEnArboles(ci.getToSearch());
            parsearEnDocumentosEnviables(ci);
            ordenarDocumentosEnviables(ci);


            System.out.println(ci);

            //out.writeObject(documentToSendArrayList); //Envio el arraylist

            clientSocket.close();
            System.out.println("Client disconnected");

        } catch (IOException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e);
        }



    }




}
