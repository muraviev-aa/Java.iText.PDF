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

public class WatermarkImage {
    public static void main(String[] args) throws IOException {
        String path = "E:/ITMO/Java_new/test17.pdf";
        /**
         * Установка шрифта
         */
        String fontFilename = "./src/main/resources/arial.ttf";
        PdfFont font = PdfFontFactory.createFont(fontFilename, PdfEncodings.IDENTITY_H);

        PdfWriter pdfWriter = new PdfWriter(path);

        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();
        Document document = new Document(pdfDocument);

        String imgPath = "images/tang.png";
        ImageData imageData = ImageDataFactory.create(imgPath);
        Image image = new Image(imageData);
        image.setFixedPosition(pdfDocument.getDefaultPageSize().getWidth() / 2 - 109,
                pdfDocument.getDefaultPageSize().getWidth() / 2 - 99);
        image.setOpacity(0.3f);

        Paragraph paragraph = new Paragraph();
        paragraph.add("Таким образом, сложившаяся структура организации обеспечивает широкому "
                + "кругу специалистов участие в формировании системы обучения кадров, соответствующей "
                + "насущным потребностям. Практический опыт показывает, что социально-экономическое "
                + "развитие позволяет оценить значение ключевых компонентов планируемого обновления. "
                + "Повседневная практика показывает, что социально-экономическое развитие требует от "
                + "нас анализа модели развития!");

        /**
         * Назначение шрифта
         */
        document.setFont(font);
        document.add(image);
        document.add(paragraph);
        document.add(paragraph);
        document.add(paragraph);
        document.add(paragraph);
        document.add(paragraph);
        document.add(paragraph);

        document.close();
        System.out.println("Pdf created");
    }
}
