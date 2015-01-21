package pl.lodz.p.project.core.domain.document.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by milczu on 20.01.15.
 */
@Table(name = "service_fix_summaries")
@Entity
public class ServiceFixSummary extends BaseDocumentService {

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "service_fix_order_symbol", length = 80)
    private String serviceFixOrderSymbol;

    public ServiceFixSummary() {
        super(ServiceDocumentType.FIX_SUMMARY);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceFixOrderSymbol() {
        return serviceFixOrderSymbol;
    }

    public void setServiceFixOrderSymbol(String serviceFixOrderSymbol) {
        this.serviceFixOrderSymbol = serviceFixOrderSymbol;
    }
}
