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
import com.itextpdf.layout.element.Text;

import java.io.IOException;

public class EmbedFonts {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test16.pdf";
        /**
         * Установка шрифта
         */
        String arial = "./src/main/resources/arial.ttf";
        String segoepr = "./src/main/resources/segoepr.ttf";
        PdfFont var1 = PdfFontFactory.createFont(arial, true);
        PdfFont var2 = PdfFontFactory.createFont(segoepr, true);

        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        /**
         * Назначение шрифта
         */
        Text text1 = new Text("This is arial").setFont(var1);
        Text text2 = new Text("\nThis is segoepr. English only").setFont(var2).setFontColor(Color.GREEN);

        Paragraph paragraph = new Paragraph()
                .add(text1)
                .add(text2);
        document.add(paragraph);

        document.close();
        System.out.println("Pdf created");
    }
}
