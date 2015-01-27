package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.jsf.contractor.ContractorListController;
import pl.lodz.p.project.core.jsf.good.GoodListController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.items.TransportMeanService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
public class ExternalInvoiceController extends EditObjectController<ExternalInvoiceDTO> {

	private static final long serialVersionUID = 6806332655702953164L;

	@Autowired
	private GoodListController goodListController;

	@Autowired
	private ContractorListController contractorListController;

	@Autowired
	private ExternalInvoiceService service;

	@Autowired
	private DocumentNumeratorService documentNumeratorService;

	@Autowired
	private ConstantElements constantElements;

	@Override
	protected void createNew() {
		setSourceObject(new ExternalInvoiceDTO());
		getSourceObject().setTransportMean(new TransportMeanDTO());
		getSourceObject().setGoodList(new ArrayList<ExternalInvoiceGoodDTO>());
		getSourceObject().setDeliveryDate(constantElements.getCurrentDate());
		setTotal();
	}

	public void afterObjectSet(String type) {
		createNew();
		setVisible(true);
		getSourceObject().setType(type);
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(type));
	}

	@Override
	public void save() {
		getSourceObject().setIssuePerson(constantElements.getUser());
		getSourceObject().setDocumentDate(constantElements.getCurrentDate());
		super.save();
	}

	public void addGood() {
		setVisible(true);

		ExternalInvoiceGoodDTO invoiceGood = new ExternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setQuantity(goodListController.getQuantity());
		invoiceGood.setInvoice(getSourceObject());
		getSourceObject().getGoodList().add(invoiceGood);

		setTotal();
	}

	public void setTotal() {
		double total = 0d;
		for(ExternalInvoiceGoodDTO good : getSourceObject().getGoodList()) {
			total += good.getQuantity() * good.getGood().getPrices().getPriceAGross();
		}
		getSourceObject().setTotal(total);
	}

	public void addContractor() {
		setVisible(true);
		getSourceObject().setContractor(contractorListController.getSingleSelection());
	}

	public String forwardContractor() {
		String id = getSourceObject().getContractor().getId().toString();
		return GUI.redirect("contractorTemplate", id);
	}

	public void setVisible(boolean state) {
		super.setVisible(state);
		goodListController.setVisible(!state);
		contractorListController.setVisible(!state);
	}

	public void selectContractor() {
		super.setVisible(false);
		goodListController.setVisible(false);
		contractorListController.setVisible(true);
	}

	public void selectGood() {
		super.setVisible(false);
		goodListController.setVisible(true);
		contractorListController.setVisible(false);
	}

	@Override
	public ServiceRepository getService() {
		return service;
	}
}
