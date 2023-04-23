package org.example;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.IOException;

public class Invoice {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test13.pdf";
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);
        document.setFont(font);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        /**
         * Шапка
         */
        float[] columnWidth = {350, 210};
        Table table = new Table(columnWidth);
        table.setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE);
        table.addCell(new Cell().add("СДЕЛАЙТЕ ПОКУПКУ")
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(20f)
                .setMarginBottom(20f)
                .setFontSize(25f)
                .setBorder(Border.NO_BORDER)
        );
        table.addCell(new Cell().add("Санкт-Петербург,\nНаб. р. Фонтанки,\n44 - 46")
                .setTextAlignment(TextAlignment.RIGHT)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setMarginTop(10f)
                .setMarginRight(10f)
                .setFontSize(12f)
                .setBorder(Border.NO_BORDER)
        );

        /**
         * Таблица c информацией о пользователе
         */
        float[] colWidth = {80, 300, 100, 80};
        Table customerInfoTable = new Table(colWidth);
        customerInfoTable.addCell(new Cell(0, 4)
                .add("Информация")
                .setBold()
                .setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("Имя").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("Джеймс").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("Номер").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("007").setBorder(Border.NO_BORDER));

        customerInfoTable.addCell(new Cell().add("Рег. номер").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("+100500").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("Дата").setBorder(Border.NO_BORDER));
        customerInfoTable.addCell(new Cell().add("24-10-2023").setBorder(Border.NO_BORDER));

        /**
         * Таблица о книгах
         */
        float[] itemInfoColWidth = {140, 140, 140, 140};
        Table itemInfoTable = new Table(itemInfoColWidth);

        itemInfoTable.addCell(new Cell()
                .add("Название")
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE));
        itemInfoTable.addCell(new Cell()
                .add("Автор")
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE));
        itemInfoTable.addCell(new Cell()
                .add("Год издания")
                .setTextAlignment(TextAlignment.RIGHT)
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE));
        itemInfoTable.addCell(new Cell()
                .add("Цена (руб.)")
                .setTextAlignment(TextAlignment.RIGHT)
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setFontColor(Color.WHITE));

        itemInfoTable.addCell(new Cell().add("Курочка Ряба"));
        itemInfoTable.addCell(new Cell().add("Народ"));
        itemInfoTable.addCell(new Cell().add("2000")
                .setTextAlignment(TextAlignment.RIGHT)
        );
        itemInfoTable.addCell(new Cell().add("1500")
                .setTextAlignment(TextAlignment.RIGHT)
        );

        itemInfoTable.addCell(new Cell().add("Вредные советы"));
        itemInfoTable.addCell(new Cell().add("Остер"));
        itemInfoTable.addCell(new Cell().add("1987")
                .setTextAlignment(TextAlignment.RIGHT)
        );
        itemInfoTable.addCell(new Cell().add("2000")
                .setTextAlignment(TextAlignment.RIGHT)
        );

        itemInfoTable.addCell(new Cell().add("")
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setBorder(Border.NO_BORDER)
        );
        itemInfoTable.addCell(new Cell().add("")
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setBorder(Border.NO_BORDER)
        );
        itemInfoTable.addCell(new Cell().add("Итого:")
                .setTextAlignment(TextAlignment.RIGHT)
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setBorder(Border.NO_BORDER)
                .setFontColor(Color.WHITE)
        );
        itemInfoTable.addCell(new Cell().add("3500")
                .setTextAlignment(TextAlignment.RIGHT)
                .setBackgroundColor(new DeviceRgb(63, 169, 219))
                .setBorder(Border.NO_BORDER)
                .setFontColor(Color.WHITE)
        );

        document.add(table);
        document.add(new Paragraph("\n"));
        document.add(customerInfoTable);
        document.add(new Paragraph("\n"));
        document.add(itemInfoTable);
        document.add(new Paragraph("Приходите!")
                .setTextAlignment(TextAlignment.RIGHT));

        document.close();
        System.out.println("Pdf created");
    }
}
