package pl.lodz.p.project.core.jsf.documents.service;

import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceRepairOrder;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceRepairOrderDTO;
import pl.lodz.p.project.core.service.document.service.ServiceRepairOrderService;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@Scope("view")
public class ServiceRepairOrderTemplateBean extends AbstractServiceTemplateBean<ServiceRepairOrderDTO, ServiceRepairOrder, ServiceRepairOrderService> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected ServiceRepairOrderDTO createNew() {
        ServiceRepairOrderDTO document = new ServiceRepairOrderDTO();
        document.setState(ServiceDocumentState.NEW);
        document.setDocumentDate(new Date());
        UserDTO documentCreator = currentUser();
        document.setIssuePerson(documentCreator);
        return document;
    }
}
