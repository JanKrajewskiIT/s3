package pl.lodz.p.project.core.jsf.documents.service;

import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceFixSummary;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceFixSummaryDTO;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.document.service.ServiceFixSummaryService;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Scope("request")
@Named
public class ServiceFixSummaryTemplateBean extends AbstractServiceTemplateBean<ServiceFixSummaryDTO, ServiceFixSummary, ServiceFixSummaryService> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected ServiceFixSummaryDTO createNew() {
        ServiceFixSummaryDTO document = new ServiceFixSummaryDTO();
        document.setState(ServiceDocumentState.NEW);
        document.setDocumentDate(new Date());

        UserDTO documentCreator = currentUser();
        document.setIssuePerson(documentCreator);

        return document;
    }
}
