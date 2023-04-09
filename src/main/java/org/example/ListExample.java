package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;

import java.io.IOException;

public class ListExample {
    public static void main(String[] args) throws IOException {
        List list1 = new List();
        list1.add("Старт");
        list1.add("Создания");
        list1.add("Pdf");

        String path = "E:/ITMO/Java_new/test1.pdf";
        /**
         * Установка шрифта
         */
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        /**
         * Назначение шрифта
         */
        document.setFont(font);
        document.add(list1);

        document.close();
        System.out.println("Pdf created");
    }
}
