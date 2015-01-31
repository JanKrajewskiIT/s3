package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.jsf.contractor.ContractorListController;
import pl.lodz.p.project.core.jsf.good.GoodListController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceService;

import javax.inject.Named;
import java.util.ArrayList;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
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

	@Autowired
	private GUI gui;

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
		getSourceObject().setDocumentDate(constantElements.getCurrentDate());
		getSourceObject().setIssuePerson(constantElements.getUser());
		if(getSourceObject().getType().equals("PZ")) {
			estimateQuantityUp();
		} else if(getSourceObject().getType().equals("WZ")) {
			estimateQuantityDown();
		}
		super.save();
	}

	private void estimateQuantityUp() {
		for(ExternalInvoiceGoodDTO invoice : getSourceObject().getGoodList()) {
			invoice.getGood().setQuantity(
					invoice.getGood().getQuantity() + invoice.getQuantity()
			);
		}
	}

	private void estimateQuantityDown() {
		for(ExternalInvoiceGoodDTO invoice : getSourceObject().getGoodList()) {
			invoice.getGood().setQuantity(
					invoice.getGood().getQuantity() - invoice.getQuantity()
			);
		}
	}

	public void addGood() {
		GoodDTO good = goodListController.getSingleSelection();
		Double quantity = goodListController.getQuantity();
		setVisible(true);

		if(getSourceObject().getType().equals("WZ")) {
			if (good.getQuantity() < quantity || quantity <= 0.0) {
				gui.showWarnMessage("Brak wystarczającej ilości " + good.getName());
				return;
			}
		}

		getExistingInvoiceGood().setQuantity(quantity);
		setTotal();
	}

	public ExternalInvoiceGoodDTO getExistingInvoiceGood() {
		GoodDTO good = goodListController.getSingleSelection();
		for(ExternalInvoiceGoodDTO invoiceGood : getSourceObject().getGoodList()) {
			if(invoiceGood.getGood().equals(good)) {
				return invoiceGood;
			}
		}
		return addNewInvoiceGood();
	}

	public ExternalInvoiceGoodDTO addNewInvoiceGood() {
		ExternalInvoiceGoodDTO invoiceGood = new ExternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setInvoice(getSourceObject());
		getSourceObject().getGoodList().add(invoiceGood);
		return invoiceGood;
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
