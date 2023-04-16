package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;

import java.io.IOException;

public class ColumnAndRowSpan {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test8.pdf";
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        document.setFont(font);

        float[] columnWidth = {100f, 100f, 100f};
        Table table = new Table(columnWidth);

        table.addCell(new Cell().add("Один"));
        table.addCell(new Cell().add("Два"));
        table.addCell(new Cell(2, 0).add("Три"));
        table.addCell(new Cell().add("Четыре"));
        table.addCell(new Cell().add("Пять"));
        table.addCell(new Cell(0, 2).add("Шесть"));
        table.addCell(new Cell().add("Семь"));

        document.add(table);
        document.close();
        System.out.println("Pdf created");
    }
}
