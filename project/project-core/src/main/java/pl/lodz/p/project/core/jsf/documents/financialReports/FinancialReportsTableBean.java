package pl.lodz.p.project.core.jsf.documents.financialReports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.FinancialReportDTO;
import pl.lodz.p.project.core.service.document.FinancialReportService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named(value = "financialReportsTableBean")
@Scope("request")
public class FinancialReportsTableBean {

    private static final long serialVersionUID = 1L;

    @Autowired
    private FinancialReportService financialReportService;

    private List<FinancialReportDTO> reports;


    public FinancialReportsTableBean() {
    }

    @PostConstruct
    public void init() {
        setReports(financialReportService.getAll());
    }

    public void removeReport(FinancialReportDTO invoice) {
        getReports().remove(invoice);
        financialReportService.delete(invoice);
    }

    /**
     * @return the invoices
     */
    public List<FinancialReportDTO> getReports() {
        return reports;
    }


    public void setReports(List<FinancialReportDTO> invoices) {
        this.reports = reports;
    }
}
