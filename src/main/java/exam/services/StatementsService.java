package exam.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import exam.models.Statements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface StatementsService {
    Document pdfGenerator(Statements statements) throws IOException, DocumentException;
}
