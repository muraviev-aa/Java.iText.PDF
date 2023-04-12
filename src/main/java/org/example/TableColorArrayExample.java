package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.*;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;

public class TableColorArrayExample {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test4.pdf";
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
                {"Коробка", "Синий", "Средний"}, {"Шарф", "Красный", "Длинный"},
                {"Ремень", "Черный", "Широкий"}, {"Очки", "Черные", "Узкие"},
                {"Кошелек", "Коричневый", "Маленький"}
        };
        /**
         * Шапка таблицы
         */
        for (int x = 0; x < 3; x++) {
            table.addCell(new Cell().add(tableHeader[x]).setTextAlignment(TextAlignment.CENTER).
                    setBackgroundColor(new DeviceRgb(180, 40, 255)));
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (i % 2 == 0) {
                    table.addCell(new Cell().add(thingsArray[i][j]).setTextAlignment(TextAlignment.CENTER).
                            setBackgroundColor(new DeviceRgb(165, 250, 250)));
                } else {
                    table.addCell(new Cell().add(thingsArray[i][j]).setTextAlignment(TextAlignment.CENTER).
                            setBackgroundColor(new DeviceRgb(215, 250, 5)));
                }
            }
        }
        document.add(table);
        document.close();
    }
}
