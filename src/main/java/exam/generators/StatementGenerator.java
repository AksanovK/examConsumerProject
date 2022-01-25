package exam.generators;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Component
public class StatementGenerator {
    private ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
    private ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();

    public byte[] pdfRecoveryGenerating(Map<String, Object> fileParams) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream1);
        document.open();
        BaseFont times = BaseFont.createFont("c:/windows/fonts/times.ttf","cp1251",BaseFont.EMBEDDED);
        Chunk chunk = new Chunk("                                                             ЗАЯВЛЕНИЕ              ", new Font(times,14));
        Paragraph paragraph9 = new Paragraph(" ", new Font(times,14));
        Paragraph paragraph = new Paragraph("Я, " + fileParams.get("firstName").toString() +
                " " + fileParams.get("lastName").toString() + ", прошу восстановить меня в число обучающихся университета", new Font(times,14));
        Paragraph paragraph1 = new Paragraph(" на _ курс очной формы для дальнейшего обучения.", new Font(times,14));
        Paragraph paragraph4 = new Paragraph(" ", new Font(times,14));
        Paragraph paragraph5 = new Paragraph("Уведомлен(а), что при восстановлении буду продолжать обучение на _ курсе", new Font(times,14));
        Paragraph paragraph6 = new Paragraph("при условии ликвидации академической задолженности.", new Font(times,14));
        Paragraph paragraph3 = new Paragraph("Был(а) отчислен(а) из числа обучающихся университета с _ курса", new Font(times,14));
        Paragraph paragraph2 = new Paragraph("очной формы обучения по причине ______________________", new Font(times,14));
        Paragraph paragraph7 = new Paragraph("                                                                                                                            Дата", new Font(times,14));
        Paragraph paragraph8 = new Paragraph("                                                                                                                            Подпись", new Font(times,14));
        document.add(chunk);
        document.add(paragraph9);
        document.add(paragraph);
        document.add(paragraph1);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(paragraph3);
        document.add(paragraph2);
        document.add(paragraph7);
        document.add(paragraph8);
        document.close();
        return byteArrayOutputStream1.toByteArray();
    }

    public byte[] pdfAcademicLeaveGenerating(Map<String, Object> fileParams) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream2);
        document.open();
        BaseFont times = BaseFont.createFont("c:/windows/fonts/times.ttf","cp1251",BaseFont.EMBEDDED);
        Chunk chunk = new Chunk("                                                             ЗАЯВЛЕНИЕ              ", new Font(times,14));
        Paragraph paragraph9 = new Paragraph(" ", new Font(times,14));
        Paragraph paragraph = new Paragraph("Я, " + fileParams.get("firstName").toString() +
                " " + fileParams.get("lastName").toString() + ", прошу предоставить мне академический отпуск", new Font(times,14));
        Paragraph paragraph1 = new Paragraph("с 1 сентября 2022 года по 30 июня 2023 года.", new Font(times,14));
        Paragraph paragraph2 = new Paragraph("     В случае моего невыхода на обучение по завершению академического отпуска", new Font(times,14));
        Paragraph paragraph3 = new Paragraph("прошу отчислить меня по собственному желанию.", new Font(times,14));
        Paragraph paragraph4 = new Paragraph(" ", new Font(times,14));
        Paragraph paragraph5 = new Paragraph("Уведомлен(а), что при выходе из академического отпуска буду продолжать", new Font(times,14));
        Paragraph paragraph6 = new Paragraph("обучение при условии ликвидации академической задолженности.", new Font(times,14));
        Paragraph paragraph7 = new Paragraph("                                                                                                                            Дата", new Font(times,14));
        Paragraph paragraph8 = new Paragraph("                                                                                                                            Подпись", new Font(times,14));
        document.add(chunk);
        document.add(paragraph9);
        document.add(paragraph);
        document.add(paragraph1);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
        document.add(paragraph6);
        document.add(paragraph7);
        document.add(paragraph8);
        document.close();
        return byteArrayOutputStream2.toByteArray();
    }

    public ByteArrayOutputStream convertingDocumentToStream(Document document) {
        return new ByteArrayOutputStream();
    }
}
