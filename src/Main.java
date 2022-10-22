import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public void ReadPDFile() throws Exception {


        File file = new File("/Users/henry/Downloads/txtexample.txt");
        //FileInputStream fis = new FileInputStream(file);
        //PDDocument pdfdocument = PDDocument.load(fis);
    }



    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/henry/Downloads/pdfexample.pdf");


        //pal pedeefe





        //pal tequiste
        Scanner scan = new Scanner(file);
        System.out.println(scan.next());
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }


    }

}
