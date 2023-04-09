package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * Добавление картинки в pdf
         */
        String imgSrc = "images/login.png";
        ImageData data = ImageDataFactory.create(imgSrc);
        Image image1 = new Image(data);
        /**
         * Путь до файла pdf
         */
        String path = "E:/ITMO/Java_new/test.pdf";
        /**
         * Установка шрифта
         */
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        String paraText = "Старт!";
        Paragraph paragraph = new Paragraph(paraText);
        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Document document = new Document(pdfDocument);
        /**
         * Назначение шрифта
         */
        document.setFont(font);
        document.add(paragraph);
        document.add(image1);

        document.close();
    }
}