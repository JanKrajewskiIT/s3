package pl.lodz.p.project.core.jsf.documents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocument;
import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.service.document.service.BaseServiceDocumentService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("serviceDocumentsTableBean")
@Scope("request")
public class ServiceDocumentsTableBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private BaseServiceDocumentService baseServiceDocumentService;

    private List<ServiceDocument> documents;


    @PostConstruct
    public void init() {
        setDocuments(baseServiceDocumentService.findAll());
    }


    public List<ServiceDocument> getDocuments() {
        return documents;
    }


    public void setDocuments(List<ServiceDocument> documents) {
        this.documents = documents;
    }
}
