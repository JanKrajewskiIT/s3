package pl.lodz.p.project.core.dto.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.dto.account.UserDTO;

import java.io.Serializable;
import java.util.Date;

public class BaseServiceDocumentDTO implements ServiceDocumentDTO, Serializable {

    private final ServiceDocumentType serviceDocumentType;
    private Long id;
    private Long version = 1L;
    private String symbol;
    private Date creationDate;
    private UserDTO documentCreator;
    private ServiceDocumentState state;
    private boolean active;

    public BaseServiceDocumentDTO(ServiceDocumentType serviceDocumentType) {
        this.serviceDocumentType = serviceDocumentType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UserDTO getDocumentCreator() {
        return documentCreator;
    }

    public void setDocumentCreator(UserDTO documentCreator) {
        this.documentCreator = documentCreator;
    }

    public ServiceDocumentType getServiceDocumentType() {
        return serviceDocumentType;
    }

    public ServiceDocumentState getState() {
        return state;
    }

    public void setState(ServiceDocumentState state) {
        this.state = state;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
