package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Text;

import java.io.IOException;

public class ChangeListSymbol {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test10.pdf";
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        document.setFont(font);

        List list = new List();
        Text text = new Text("\u007E");

        list.setListSymbol(text);

        list.add("Яблоко");
        list.add("Груша");
        list.add("Слива");
        list.add("Арбуз");
        list.add("Ананас");

        document.add(list);
        document.close();

        System.out.println("Pdf created");
    }
}
