package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.IOException;

public class WorkingWithTheFont {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test14.pdf";
        /**
         * Установка шрифта
         */
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        Text text1 = new Text("Нормальный").setFont(font);
        Text text2 = new Text("\nЖирный").setFont(font).setBold();
        Text text3 = new Text("\nС наклоном").setFont(font).setItalic();
        Text text4 = new Text("\nПодчеркнутый").setFont(font).setUnderline();
        Text text5 = new Text("\nЖирный с наклоном").setFont(font).setBold().setItalic();
        Text text6 = new Text("\nЖирный цветной").setFont(font).setFontColor(Color.BLUE);
        Text text7 = new Text("\nЖирный цветной с черной прожилкой")
                .setFont(font).setBold().setStrokeColor(Color.GREEN);
        Text text8 = new Text("\nEnglish only")
                .setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.STROKE)
                .setStrokeColor(Color.RED)
                .setStrokeWidth(0.5f);

        Paragraph paragraph = new Paragraph()
                .add(text1)
                .add(text2)
                .add(text3)
                .add(text4)
                .add(text5)
                .add(text6)
                .add(text7)
                .add(text8);

        document.add(paragraph);

        /**
         * Назначение шрифта
         */
        document.setFont(font);

        document.close();
        System.out.println("Pdf created");
    }
}
