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
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Text;

import java.io.IOException;

public class ImageAsListIcon {
    public static final String IMG = "src/main/resources/img/file.png";

    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test11.pdf";
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        document.setFont(font);

        ImageData imageData = ImageDataFactory.create(IMG);
        /**
         * Настройка размеров картинки
         */
        imageData.setHeight(15f);
        imageData.setWidth(15f);

        List list = new List();
        list.setListSymbol(new Image(imageData));

        list.setFontSize(20F);

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
