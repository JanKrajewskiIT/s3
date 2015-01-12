package pl.lodz.p.project.core.util.pdf.view.template.impl;

import com.itextpdf.text.*;
import pl.lodz.p.project.core.dto.document.FinancialReportDTO;
import pl.lodz.p.project.core.util.pdf.view.template.TemplateProcessor;

import java.text.MessageFormat;

/**
 * The class that generates PDF for financial report.
 */
public class FinancialReportTemplateProcessor extends TemplateProcessor {

    public static final String PROPERTY_FORMAT = "{0}: {1}";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    public FinancialReportTemplateProcessor(Object reportToGenerate) {
        super(reportToGenerate);
    }

    @Override
    public void process(Document document) throws DocumentException {
        FinancialReportDTO financialReportDTO = (FinancialReportDTO) reportObject;
        Paragraph preface = new Paragraph();
        preface.setAlignment(Element.ALIGN_CENTER);
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Raport finansowy", catFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(MessageFormat.format(PROPERTY_FORMAT, "Data raportu", financialReportDTO.getReportDate()), smallBold));
        preface.add(new Paragraph(MessageFormat.format(PROPERTY_FORMAT, "Raport od", financialReportDTO.getReportStartDate()), smallBold));
        preface.add(new Paragraph(MessageFormat.format(PROPERTY_FORMAT, "Raport do", financialReportDTO.getReportEndDate()), smallBold));
        preface.add(new Paragraph(MessageFormat.format(PROPERTY_FORMAT, "Liczba sprzedazy", financialReportDTO.getNumberOfSales()), smallBold));
        preface.add(new Paragraph(MessageFormat.format(PROPERTY_FORMAT, "Srednia kwota sprzedazy", financialReportDTO.getAverageSaleAmount()), smallBold));
        preface.add(new Paragraph(MessageFormat.format(PROPERTY_FORMAT, "Calkowita kwota sprzedazy", financialReportDTO.getTotalSalesAmount()), smallBold));
        document.add(preface);
    }
}
