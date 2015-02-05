package pl.lodz.p.project.core.jsf.documents.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceFixSummary;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;
import pl.lodz.p.project.core.domain.document.service.ServiceRepairOrder;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceFixSummaryDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceProductsRequestDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceRepairOrderDTO;
import pl.lodz.p.project.core.jsf.base.Action;
import pl.lodz.p.project.core.jsf.base.CanBeVisible;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.base.Mode;
import pl.lodz.p.project.core.jsf.contractor.ContractorListController;
import pl.lodz.p.project.core.jsf.documents.service.action.CreateFixSummaryFromServiceDocumentAction;
import pl.lodz.p.project.core.jsf.documents.service.action.CreateProductsRequestFromServiceDocumentAction;
import pl.lodz.p.project.core.jsf.documents.service.action.FixSummaryCreatable;
import pl.lodz.p.project.core.jsf.documents.service.action.ProductsRequestCreatable;
import pl.lodz.p.project.core.service.document.service.ServiceFixSummaryService;
import pl.lodz.p.project.core.service.document.service.ServiceProductsRequestService;
import pl.lodz.p.project.core.service.document.service.ServiceRepairOrderService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@Scope("view")
public class ServiceRepairOrderTemplateBean extends AbstractServiceTemplateBean<ServiceRepairOrderDTO, ServiceRepairOrder, ServiceRepairOrderService> implements Serializable, FixSummaryCreatable, ProductsRequestCreatable, CanBeVisible {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceRepairOrderTemplateBean.class);

    @Autowired
    private ServiceFixSummaryService serviceFixSummaryService;

    @Autowired
    private ServiceProductsRequestService serviceProductsRequestService;

    @Autowired
    private ContractorListController contractorListController;

    private boolean visible = true;

    @PostConstruct
    public void init() {
        super.init();
        contractorListController.setVisible(false);
    }

    protected ServiceRepairOrderDTO createNew() {
        ServiceRepairOrderDTO document = new ServiceRepairOrderDTO();
        document.setState(ServiceDocumentState.NEW);
        document.setDocumentDate(new Date());
        UserDTO documentCreator = currentUser();
        document.setIssuePerson(documentCreator);
        return document;
    }

    @Override
    public List<Action> getActions() {
        List<Action> actions = super.getActions();
        if (Mode.EDIT == getMode() && (getDocument().getState() == ServiceDocumentState.IN_PROGRESS || getDocument().getState() == ServiceDocumentState.DONE)) {
            actions.add(new CreateFixSummaryFromServiceDocumentAction(this));
        }
        if (Mode.EDIT == getMode() && getDocument().getState() == ServiceDocumentState.IN_PROGRESS) {
            actions.add(new CreateProductsRequestFromServiceDocumentAction(this));
        }
        return actions;
    }

    @Override
    public void createFixSummary() {
        ServiceFixSummaryDTO fixSummaryDTO = new ServiceFixSummaryDTO();
        fixSummaryDTO.setSymbol(getDocumentNumeratorService().nextNumber(fixSummaryDTO.getType()));
        fixSummaryDTO.setState(ServiceDocumentState.NEW);
        fixSummaryDTO.setDocumentDate(new Date());

        UserDTO documentCreator = currentUser();
        fixSummaryDTO.setIssuePerson(documentCreator);
        fixSummaryDTO.setServiceFixOrderSymbol(getDocument().getSymbol());
        ServiceFixSummary entity = serviceFixSummaryService.save(fixSummaryDTO);

        GUI.redirect("/documents/service/serviceFixSummary", entity.getId().toString());
    }

    @Override
    public void createProductsRequest() {
        ServiceProductsRequestDTO productsRequestDTO = new ServiceProductsRequestDTO();
        productsRequestDTO.setSymbol(getDocumentNumeratorService().nextNumber(productsRequestDTO.getType()));
        productsRequestDTO.setState(ServiceDocumentState.NEW);
        productsRequestDTO.setDocumentDate(new Date());

        UserDTO documentCreator = currentUser();
        productsRequestDTO.setIssuePerson(documentCreator);
        productsRequestDTO.setServiceRepairOrderSymbol(getDocument().getSymbol());
        ServiceProductsRequest entity = serviceProductsRequestService.save(productsRequestDTO);

        GUI.redirect("/documents/service/serviceProductsRequest", entity.getId().toString());
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void selectContractor() {
        visible = false;
        contractorListController.setVisible(true);
    }

    public void addContractor() {
        visible = true;
        contractorListController.setVisible(false);
        getDocument().setContractor(contractorListController.getSingleSelection());
    }

    public ContractorListController getContractorListController() {
        return contractorListController;
    }
}
