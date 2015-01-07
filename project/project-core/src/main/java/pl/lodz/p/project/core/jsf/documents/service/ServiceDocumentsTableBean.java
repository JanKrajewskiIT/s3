package pl.lodz.p.project.core.jsf.documents.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.service.document.ServiceDocumentService;

@Named("serviceDocumentsTableBean")
@Scope("request")
public class ServiceDocumentsTableBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ServiceDocumentService serviceDocumentService;

    private List<BaseServiceDocumentDTO> documents;


    @PostConstruct
    public void init() {
        setDocuments(serviceDocumentService.getAllBaseDocuments());
    }

   
    public List<BaseServiceDocumentDTO> getDocuments() {
        return documents;
    }


    public void setDocuments(List<BaseServiceDocumentDTO> documents) {
        this.documents = documents;
    }
}
