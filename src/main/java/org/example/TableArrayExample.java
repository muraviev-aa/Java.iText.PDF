package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;

public class TableArrayExample {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test3.pdf";
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        document.setFont(font);

        float[] columnWidth = {100f, 50f, 80f};
        Table table = new Table(columnWidth);

        String[] tableHeader = {"Обозначение", "Цвет", "Размер"};
        String[][] thingsArray = {
                {"Коробка", "Синий", "Средний"},
                {"Шарф", "Красный", "Длинный"},
                {"Ремень", "Черный", "Широкий"},
                {"Очки", "Черные", "Узкие"},
                {"Кошелек", "Коричневый", "Маленький"}
        };
        table.addCell(new Cell().add(tableHeader[0]).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add(tableHeader[1]).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add(tableHeader[2])).setTextAlignment(TextAlignment.CENTER);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                table.addCell(new Cell().add(thingsArray[i][j]).setTextAlignment(TextAlignment.CENTER));
            }
        }

        document.add(table);
        document.close();
    }
}
