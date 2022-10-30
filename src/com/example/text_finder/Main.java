package com.example.text_finder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static String sentence;
    static Boolean check;
    static String word;
    static String Lastword;


    static File file = new File("/Users/henry/Downloads/txtexample.txt");

    static Scanner scan1;

    static {
        try {
            scan1 = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner scan2;

    static {
        try {
            scan2 = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner scan3;

    static {
        try {
            scan3 = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static int lineatxt = 1;

    public static int getline(String palabra){
        //word = scan2.next();

        //Lastword = sentence.substring(sentence.lastIndexOf(" ")+1);
        check = sentence.contains(palabra);

        if (check == true){
            return lineatxt;
        }
        lineatxt = lineatxt + 1;
        if (scan1.hasNextLine()) {
            sentence = scan1.nextLine();
        }
        return lineatxt;
    }


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
            ArrayList<Document> listDocuments = (ArrayList<Document>) message;

            System.out.println(listDocuments);


            clientSocket.close();
            System.out.println("Client disconnected");

        } catch (IOException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e);
        }


        /*
        while(scan1.hasNextLine()){
            System.out.println(scan1.nextLine());
        }
        */



        BufferedReader br = new BufferedReader(new FileReader("/Users/henry/Downloads/txtexample.txt"));
        /*
        String ln;
        int lineIndex = 1;
        boolean found = false;
        while((ln = br.readLine()) != null){
            if (lineIndex == 2){
                System.out.println(ln);
                found = true;
                break;
            }
            lineIndex++;
        }
        */

        //Insertar palabras para txt
/*
        ArbolBinario arbolBinario = new ArbolBinario();
        ArbolAVL arbolAVL = new ArbolAVL();

        while (scan3.hasNext()){
            if (scan1.hasNextLine()) {
                sentence = scan1.nextLine();
            }
            String palabraActual = "";
            palabraActual = scan3.next();
            arbolBinario.agregarNodoBinario(palabraActual, String.valueOf(file), getline(palabraActual), false, false);
            arbolAVL.insertar(palabraActual, String.valueOf(file), getline(palabraActual));
        }
        //arbolBinario.agregarNodoBinario("It", "X", 1, false, false);
        System.out.println(arbolBinario.buscarNodo("It"));

        //arbolBinario.inOrden(arbolBinario.raiz);



        arbolBinario.agregarNodoBinario("Aguacate", "F", 1);
        arbolBinario.agregarNodoBinario("aguacate", "F", 1);
        arbolBinario.agregarNodoBinario("bguacate", "F", 1);
        arbolBinario.agregarNodoBinario("cguacate", "F", 1);
        arbolBinario.agregarNodoBinario("Sguacate", "F", 1);
        arbolBinario.agregarNodoBinario("Aguacate", "F", 1);
        arbolBinario.inOrden(arbolBinario.raiz);
        if (arbolBinario.buscarNodo("cguacates") == null){
            System.out.println("Nodo no encontrado");
        }else{
            System.out.println(arbolBinario.buscarNodo("cxguacate"));
        }

        arbolAVL.insertar("Aguacate", "F", 1);
        arbolAVL.insertar("banano", "F", 1);
        arbolAVL.insertar("Agsuacate", "F", 1);
        arbolAVL.insertar("esacate", "F", 1);
        arbolAVL.insertar("Aguacate", "F", 1);
        arbolAVL.insertar("esf", "F", 1);
        arbolAVL.insertar("Abanico", "F", 1);
        arbolAVL.inOrden(arbolAVL.obtenerRaiz());
        if (arbolAVL.buscar("esf") == null){
            System.out.println("Nodo no encontrado");
        }else{
            System.out.println(arbolAVL.buscar("esf").palabra + arbolAVL.buscar("esf").archivo + arbolAVL.buscar("esf").posicion);
        }
        */

/*


        //para docx
        try{
            XWPFDocument fis = new XWPFDocument(new FileInputStream("C:/Users/henry/Downloads/HenryNúñez_Tarea 1.docx"));
            XWPFWordExtractor we = new XWPFWordExtractor(fis);
            System.out.println(we.getText());
        } catch (Exception e){
            System.out.println(e);
        }

        //para pdf
        FileInputStream fis = new FileInputStream(file);

        PDDocument pdfdocument = PDDocument.load(fis);
        System.out.println(pdfdocument.getPages().getCount());
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String docText = pdfTextStripper.getText(pdfdocument);
        System.out.println(docText);

        pdfdocument.close();
        fis.close();

        //pal tequiste

*/


    }

}
