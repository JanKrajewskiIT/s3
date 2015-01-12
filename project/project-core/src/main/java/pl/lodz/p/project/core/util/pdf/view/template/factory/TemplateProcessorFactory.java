package pl.lodz.p.project.core.util.pdf.view.template.factory;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.dto.document.FinancialReportDTO;
import pl.lodz.p.project.core.util.pdf.view.template.TemplateProcessor;
import pl.lodz.p.project.core.util.pdf.view.template.impl.FinancialReportTemplateProcessor;

@Component
public class TemplateProcessorFactory {

    public TemplateProcessor getTemplateProcessor(Object reportToGenerate) {
        if(reportToGenerate instanceof FinancialReportDTO) {
            return new FinancialReportTemplateProcessor(reportToGenerate);
        }
        return null;
    }
}
