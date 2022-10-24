import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.util.ZipEntrySource;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws Exception {
        //File file = new File("/Users/henry/Downloads/pdfexample.pdf");

        //pal docx
        try{
            XWPFDocument fis = new XWPFDocument(new FileInputStream("C:/Users/henry/Downloads/HenryNúñez_Tarea 1.docx"));
            XWPFWordExtractor we = new XWPFWordExtractor(fis);
            System.out.println(we.getText());
        } catch (Exception e){
            System.out.println(e);
        }




        /*
        //pal pedeefe
        FileInputStream fis = new FileInputStream(file);

        PDDocument pdfdocument = PDDocument.load(fis);
        System.out.println(pdfdocument.getPages().getCount());
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String docText = pdfTextStripper.getText(pdfdocument);
        System.out.println(docText);

        pdfdocument.close();
        fis.close();




        pal tequiste
        Scanner scan = new Scanner(file);
        System.out.println(scan.next());
        while(scan.hasNextLine()){
            //System.out.println(scan.nextLine());
        }
        */

    }

}
