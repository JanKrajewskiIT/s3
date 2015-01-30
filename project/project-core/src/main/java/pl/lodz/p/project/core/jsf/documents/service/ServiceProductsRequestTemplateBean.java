package pl.lodz.p.project.core.jsf.documents.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceProductRequestItemDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceProductsRequestDTO;
import pl.lodz.p.project.core.jsf.contractor.ContractorListController;
import pl.lodz.p.project.core.jsf.good.GoodListController;
import pl.lodz.p.project.core.service.document.service.ServiceProductsRequestService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by milczu on 28.01.15.
 */
@Named
@ViewScoped
public class ServiceProductsRequestTemplateBean extends AbstractServiceTemplateBean<ServiceProductsRequestDTO, ServiceProductsRequest, ServiceProductsRequestService> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean documentsGoodsListVisible = true;

    @Autowired
    private GoodListController goodListController;

    @Autowired
    private ContractorListController contractorListController;

    @PostConstruct
    public void init() {
        super.init();
        goodListController.setVisible(false);
        contractorListController.setVisible(false);
    }

    @Override
    protected ServiceProductsRequestDTO createNew() {
        ServiceProductsRequestDTO document = new ServiceProductsRequestDTO();
        document.setState(ServiceDocumentState.NEW);
        document.setDocumentDate(new Date());

        UserDTO documentCreator = currentUser();
        document.setIssuePerson(documentCreator);

        return document;
    }

    public ServiceProductsRequestDTO getSourceObject() {
        return getDocument();
    }

    public void selectGood() {
        documentsGoodsListVisible = false;
        goodListController.setVisible(true);
        contractorListController.setVisible(false);
    }

    public void addGood() {
        documentsGoodsListVisible = true;
        goodListController.setVisible(false);

        ServiceProductRequestItemDTO documentGood = new ServiceProductRequestItemDTO();
        documentGood.setGood(goodListController.getSingleSelection());
        documentGood.setQuantity(goodListController.getQuantity());
        documentGood.setDocument(getSourceObject());

        getSourceObject().getGoodList().add(documentGood);
    }

    public boolean isDocumentsGoodsListVisible() {
        return documentsGoodsListVisible;
    }

    public GoodListController getGoodListController() {
        return goodListController;
    }
}
