package pl.lodz.p.project.core.jsf.documents.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceFixSummaryDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceRepairOrderDTO;
import pl.lodz.p.project.core.service.account.UserService;
import pl.lodz.p.project.core.service.document.service.ServiceFixSummaryService;
import pl.lodz.p.project.core.service.document.service.ServiceRepairOrderService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Scope("request")
@Named("serviceFixSummaryTemplateBean")
public class ServiceFixSummaryTemplateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ServiceFixSummaryService serviceFixSummaryService;

    private ServiceFixSummaryDTO document;
    private String issuePerson;

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (StringUtils.isBlank(id)) {
            document = createNew();
        } else {
            document = serviceFixSummaryService.getOneById(Long.parseLong(id));
        }
        issuePerson = document.getIssuePerson().getFirstName() + " " + document.getIssuePerson().getSecondName();
    }

    private ServiceFixSummaryDTO createNew() {
        ServiceFixSummaryDTO document = new ServiceFixSummaryDTO();
        document.setState(ServiceDocumentState.NEW);
        document.setDocumentDate(new Date());
        String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        UserDTO documentCreator = userService.getUserByEmail(remoteUser);
        document.setIssuePerson(documentCreator);

        return document;
    }

    public void clear() {
        document = createNew();
    }

    public ServiceFixSummaryDTO getDocument() {
        return document;
    }

    public void setDocument(ServiceFixSummaryDTO document) {
        this.document = document;
    }

    public String save() {
        serviceFixSummaryService.save(document);
        return "/documents/service/serviceDocumentsTable.xhtml";
    }

    public String getIssuePerson() {
        return issuePerson;
    }
}
