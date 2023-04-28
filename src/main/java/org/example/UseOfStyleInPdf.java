package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class UseOfStyleInPdf {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test15.pdf";
        /**
         * Установка шрифта
         */
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        Style author = new Style();
        author.setFontColor(Color.MAGENTA)
                .setFontSize(14f)
                .setItalic();

        Paragraph paragraph = new Paragraph();
        paragraph.add("Здравствуй, Стиль!").addStyle(author);

        Paragraph paragraph1 = new Paragraph();
        paragraph.add("\nИзучим твою работу!");

        Paragraph paragraph2 = new Paragraph();
        paragraph.add("\nИ будем использовать в дальнейшем.");

        /**
         * Назначение шрифта
         */
        document.setFont(font);
        document.add(paragraph);
        document.add(paragraph1);
        document.add(paragraph2);

        document.close();
        System.out.println("Pdf created");
    }
}
