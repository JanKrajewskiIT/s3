package pl.lodz.p.project.core.domain.document.service;

import pl.lodz.p.project.core.domain.BaseEntity;
import pl.lodz.p.project.core.domain.account.User;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by milczu on 09.01.15.
 */
@MappedSuperclass
public abstract class BaseDocumentService extends BaseEntity<Long> {

    @NotNull
    @Column(length = 80)
    private String symbol;

    @NotNull
    @Column(name = "document_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @NotNull
    @JoinColumn(name = "document_creator_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User documentCreator;

    @NotNull
    @Column(name = "service_document_type")
    @Enumerated(EnumType.STRING)
    private ServiceDocumentType serviceDocumentType;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ServiceDocumentState state;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getDocumentCreator() {
        return documentCreator;
    }

    public void setDocumentCreator(User documentCreator) {
        this.documentCreator = documentCreator;
    }

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
