package pl.lodz.p.project.core.jsf.documents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocument;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.document.service.BaseServiceDocumentService;
import pl.lodz.p.project.core.service.document.service.ServiceFixSummaryService;
import pl.lodz.p.project.core.service.document.service.ServiceRepairOrderService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@Scope("view")
public class ServiceDocumentsTableBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private BaseServiceDocumentService baseServiceDocumentService;

    @Autowired
    private ServiceFixSummaryService serviceFixSummaryService;

    @Autowired
    private ServiceRepairOrderService serviceRepairOrderService;

    private List<ServiceDocument> documents;


    @PostConstruct
    public void init() {
        setDocuments(baseServiceDocumentService.findAll());
    }

    public void edit(Long id, ServiceDocumentType type) {
        switch (type) {
            case REPAIR_ORDER:
                GUI.redirect("/documents/service/repairOrder", id.toString());
            case FIX_SUMMARY:
                GUI.redirect("/documents/service/serviceFixSummary", id.toString());
            default:
                throw new IllegalArgumentException("Not implemented yet!");
        }
    }

    public void remove(Long id, ServiceDocumentType type) {
        switch (type) {
            case REPAIR_ORDER:
                serviceRepairOrderService.delete(id);
                break;
            case FIX_SUMMARY:
                serviceFixSummaryService.delete(id);
            default:
                throw new IllegalArgumentException("Not implemented yet!");
        }
        setDocuments(baseServiceDocumentService.findAll());
    }

    public List<ServiceDocument> getDocuments() {
        return documents;
    }


    public void setDocuments(List<ServiceDocument> documents) {
        this.documents = documents;
    }
}
