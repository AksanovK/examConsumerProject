package exam.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import exam.models.Statements;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class StatementsServiceImpl implements StatementsService {
    @Override
    public Document pdfGenerator(Statements statements) throws IOException, DocumentException {

        return new Document();
    }
}
