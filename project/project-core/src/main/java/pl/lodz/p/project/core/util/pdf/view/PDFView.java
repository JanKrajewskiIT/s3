package pl.lodz.p.project.core.util.pdf.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.util.pdf.view.template.TemplateProcessor;
import pl.lodz.p.project.core.util.pdf.view.template.factory.TemplateProcessorFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * The PDF view that uses iText.
 */
public class PDFView extends AbstractPdfView {

    public static final String DOCUMENT = "document";
    @Autowired
    private TemplateProcessorFactory templateProcessorFactory;

    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest req,
            HttpServletResponse resp)
            throws Exception {

        Object documentToGenerate =  model.get(DOCUMENT);
        TemplateProcessor processor = templateProcessorFactory.getTemplateProcessor(documentToGenerate);
        if(processor != null) {
            processor.process(document);
        }

        req.getSession().removeAttribute(DOCUMENT);
    }
}
