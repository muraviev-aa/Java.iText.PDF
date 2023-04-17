package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.IOException;

public class ColumnAndRowSpanInDetail {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test9.pdf";
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        document.setFont(font);

        float[] columnWidth = {100f, 100f, 100f, 100f, 100f, 100f};
        Table table = new Table(columnWidth);

        table.addCell(new Cell().add("Обозначение"));
        table.addCell(new Cell(2, 0).add("Расположение"));
        table.addCell(new Cell(3, 0).add("Комплектация"));
        table.addCell(new Cell(3, 0).add("Количество"));
        table.addCell(new Cell(0, 2).add("Цвет"));
        table.addCell(new Cell().add("Трактор"));
        table.addCell(new Cell().add("Зеленый"));
        table.addCell(new Cell().add("Красный"));
        table.addCell(new Cell().add("Машина"));
        table.addCell(new Cell().add("На улице"));
        table.addCell(new Cell().add("Красный"));
        table.addCell(new Cell().add("Коричневый"));

        document.add(table);
        document.close();
        System.out.println("Pdf created");
    }
}
