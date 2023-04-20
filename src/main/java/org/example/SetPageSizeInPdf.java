package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class SetPageSizeInPdf {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test12.pdf";
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        /**
         * Назначения формата + поворот
         */
        pdfDocument.setDefaultPageSize(PageSize.A5.rotate());
        document.setFont(font);

        Paragraph paragraph = new Paragraph("Hello");

        document.add(paragraph);
        document.close();

        System.out.println("Pdf created");
    }
}
