package pl.lodz.p.project.core.jsf.documents.financialReports;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.FinancialReportDTO;
import pl.lodz.p.project.core.service.document.FinancialReportService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "addFinancialReportBean")
@Scope("request")
public class AddFinancialReportBean implements Serializable {
    private static final long serialVersionUID = -5504508900103108521L;

    @Autowired
    private FinancialReportService financialReportServiceLocal;

    private FinancialReportDTO financialReport;
    private String breadcrumb;

    @PostConstruct
    public void init() {
        String goodId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(goodId)) {
            financialReport = new FinancialReportDTO();
            breadcrumb = "Dodaj";
        }
    }

    public void clear() {
        setFinancialReport(new FinancialReportDTO());
    }

    public void setFinancialReport(FinancialReportDTO financialReport) {
        this.financialReport = financialReport;
    }

    public FinancialReportDTO getFinancialReport() {
        return financialReport;
    }

    public String saveReport() {
        financialReportServiceLocal.save(getFinancialReport());
        return "financialReportsTable.xhtml?faces-redirect=true";
    }

    /**
     * @return the breadcrumb
     */
    public String getBreadcrumb() {
        return breadcrumb;
    }

    /**
     * @param breadcrumb the breadcrumb to set
     */
    public void setBreadcrumb(String breadcrumb) {
        this.breadcrumb = breadcrumb;
    }
}
