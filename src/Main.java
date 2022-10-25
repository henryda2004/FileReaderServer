import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.Scanner;

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

    static int lineatxt = 1;

    public static int getline(String palabra){
        //word = scan2.next();

        //Lastword = sentence.substring(sentence.lastIndexOf(" ")+1);
        check = sentence.contains(palabra);

        if (check == true){
            return lineatxt;
        }
        lineatxt = lineatxt + 1;
        sentence = scan1.nextLine();
        return lineatxt;
    }

    public static void main(String[] args) throws Exception {

        sentence = scan1.nextLine();
        System.out.println(getline("out"));
        System.out.println(getline("25"));
        System.out.println(getline("spent"));
        System.out.println(getline("satellite"));

        /*

        while(scan1.hasNextLine()){
            System.out.println(scan1.nextLine());
        }
        */



        BufferedReader br = new BufferedReader(new FileReader("/Users/henry/Downloads/txtexample.txt"));

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
        ArbolBinario arbolBinario = new ArbolBinario();
        arbolBinario.agregarNodoBinario("Aguacate", "F", 1);
        arbolBinario.agregarNodoBinario("aguacate", "F", 1);
        arbolBinario.agregarNodoBinario("bguacate", "F", 1);
        arbolBinario.agregarNodoBinario("cguacate", "F", 1);
        arbolBinario.agregarNodoBinario("Sguacate", "F", 1);
        arbolBinario.agregarNodoBinario("Aguacate", "F", 1);
        arbolBinario.inOrden(arbolBinario.raiz);
        if (arbolBinario.buscarNodo("cguacate") == null){
            System.out.println("Nodo no encontrado");
        }else{
            System.out.println(arbolBinario.buscarNodo("cxguacate"));
        }

/*


        //pal docx
        try{
            XWPFDocument fis = new XWPFDocument(new FileInputStream("C:/Users/henry/Downloads/HenryNúñez_Tarea 1.docx"));
            XWPFWordExtractor we = new XWPFWordExtractor(fis);
            System.out.println(we.getText());
        } catch (Exception e){
            System.out.println(e);
        }

        //pal pedeefe
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
