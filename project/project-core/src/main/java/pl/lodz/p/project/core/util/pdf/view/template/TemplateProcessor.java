package pl.lodz.p.project.core.util.pdf.view.template;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

/**
 * The abstract class that is responsible for generating PDF document for given business object.
 */
public abstract class TemplateProcessor {
    protected Object reportObject;

    public TemplateProcessor(Object reportObject) {
        this.reportObject = reportObject;
    }

    public abstract void process(Document document) throws DocumentException;

    protected static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
