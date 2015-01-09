package pl.lodz.p.project.core.jsf.documents.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceRepairOrderDTO;
import pl.lodz.p.project.core.service.account.UserService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Scope("request")
@Named("serviceRepairOrderTemplateBean")
public class ServiceRepairOrderTemplateBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRepairOrderTemplateBean.class);

    private ServiceRepairOrderDTO document;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(id)) {
            document = createNew();
        } else {
            // TODO
            document = createNew();
            document.setSymbol("SRO/16/01/2015");
            document.setDescription("Tutaj opis usterki");
            document.setEquipentInfo("Laptop DELL Inspirion 15");
            document.setGuarantee(true);
            document.setGuaranteeNo("1254/2014");
            document.setSaleDocumentNo("ABC/3213");
        }
    }

    private ServiceRepairOrderDTO createNew() {
        ServiceRepairOrderDTO document = new ServiceRepairOrderDTO();
        document.setState(ServiceDocumentState.NEW);
        document.setCreationDate(new Date());
        String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        UserDTO documentCreator = userService.getUserByEmail(remoteUser);
        document.setDocumentCreator(documentCreator);

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
