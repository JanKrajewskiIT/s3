package pl.lodz.p.project.core.domain.document.service;

import pl.lodz.p.project.core.domain.document.base.Document;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * @author Milczu
 */
@MappedSuperclass
public abstract class BaseDocumentService extends Document<Long> {

    public BaseDocumentService(ServiceDocumentType serviceDocumentType) {
        this.serviceDocumentType = serviceDocumentType;
    }

    @NotNull
    @Column(name = "service_document_type")
    @Enumerated(EnumType.STRING)
    private ServiceDocumentType serviceDocumentType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ServiceDocumentState state;

    public ServiceDocumentType getServiceDocumentType() {
        return serviceDocumentType;
    }

    public void setServiceDocumentType(ServiceDocumentType serviceDocumentType) {
        this.serviceDocumentType = serviceDocumentType;
    }

    public ServiceDocumentState getState() {
        return state;
    }

    public void setState(ServiceDocumentState state) {
        this.state = state;
    }

}
