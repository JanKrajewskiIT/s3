package pl.lodz.p.project.core.jsf.documents.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.dto.document.service.ServiceRepairOrderDTO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Scope("request")
@Named("serviceRepairOrderTemplateBean")
public class ServiceRepairOrderTemplateBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private ServiceRepairOrderDTO document;

    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(id)) {
            document = createNew();
        } else {
            // TODO
            document = null;
        }
    }

    private ServiceRepairOrderDTO createNew() {
        ServiceRepairOrderDTO document = new ServiceRepairOrderDTO();
        document.setState(ServiceDocumentState.NEW);
        document.setCreationDate(new Date());

        document.setSymbol("SRO/16/01/2015");
        document.setDescription("Tutaj opis usterki");
        document.setEquipentInfo("Laptop DELL Inspirion 15");
        document.setGuarantee(true);
        document.setGuaranteeNo("1254/2014");
        document.setSaleDocumentNo("ABC/3213");
        return document;
    }

    public void clear() {
        document = createNew();
    }

    public ServiceRepairOrderDTO getDocument() {
        return document;
    }

    public void setDocument(ServiceRepairOrderDTO document) {
        this.document = document;
    }

}
