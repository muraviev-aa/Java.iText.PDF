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

public class TableExample {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test2.pdf";
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        document.setFont(font);

        float[] columnWidth = {100f, 50f, 80f};
        Table table = new Table(columnWidth);

        Cell cell = new Cell();
        cell.setTextAlignment(TextAlignment.CENTER);
        cell.add("Название").setFontColor(Color.BLUE);
        table.addCell(cell);

        table.addCell(new Cell().add("Место").setFontColor(Color.BLUE).setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Количество").setFontColor(Color.BLUE).setTextAlignment(TextAlignment.CENTER));

        table.addCell(new Cell().add("Бычки").setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Река").setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("25").setTextAlignment(TextAlignment.CENTER));

        table.addCell(new Cell().add("Карась").setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("Озеро").setTextAlignment(TextAlignment.CENTER));
        table.addCell(new Cell().add("48").setTextAlignment(TextAlignment.CENTER));

        document.add(table);
        document.close();
        System.out.println("Pdf created");
    }
}
