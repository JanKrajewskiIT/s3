package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.jsf.good.GoodListController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

import javax.inject.Named;
import java.util.ArrayList;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class InternalInvoiceController extends EditObjectController<InternalInvoiceDTO> {

	private static final long serialVersionUID = 7763768017180337728L;

	@Autowired
	private GoodListController goodListController;

	@Autowired
	private InternalInvoiceService service;

	@Autowired
	private DocumentNumeratorService documentNumeratorService;

	@Autowired
	private ConstantElements constantElements;

	@Autowired
	private GUI gui;

	@Override
	protected void createNew() {
		setSourceObject(new InternalInvoiceDTO());
		getSourceObject().setGoodList(new ArrayList<InternalInvoiceGoodDTO>());
		setTotal();
	}

	public void afterObjectSet(String type) {
		//createNew();
		setVisible(true);
		getSourceObject().setType(type);
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(type));
	}

	@Override
	public void save() {
		getSourceObject().setDocumentDate(constantElements.getCurrentDate());
		getSourceObject().setIssuePerson(constantElements.getUser());
		if(getSourceObject().getType().equals("PW")) {
			estimateQuantityUp();
		} else if(getSourceObject().getType().equals("RW")){
			estimateQuantityDown();
		}
		super.save();
	}

	private void estimateQuantityUp() {
		for(InternalInvoiceGoodDTO invoice : getSourceObject().getGoodList()) {
			invoice.getGood().setQuantity(
					invoice.getGood().getQuantity() + invoice.getQuantity()
			);
		}
	}

	private void estimateQuantityDown() {
		for(InternalInvoiceGoodDTO invoice : getSourceObject().getGoodList()) {
			invoice.getGood().setQuantity(
				invoice.getGood().getQuantity() - invoice.getQuantity()
			);
		}
	}

	public void addGood() {
		GoodDTO good = goodListController.getSingleSelection();
		Double quantity = goodListController.getQuantity();
		setVisible(true);

		if(getSourceObject().getType().equals("RW")) {
			if (good.getQuantity() < quantity || quantity <= 0.0) {
				gui.showWarnMessage("Brak wystarczającej ilości " + good.getName());
				return;
			}
		}

		getExistingInvoiceGood().setQuantity(quantity);
		setTotal();
	}

	public InternalInvoiceGoodDTO getExistingInvoiceGood() {
		GoodDTO good = goodListController.getSingleSelection();
		for(InternalInvoiceGoodDTO invoiceGood : getSourceObject().getGoodList()) {
			if(invoiceGood.getGood().equals(good)) {
				return invoiceGood;
			}
		}
		return addNewInvoiceGood();
	}

	public InternalInvoiceGoodDTO addNewInvoiceGood() {
		InternalInvoiceGoodDTO invoiceGood = new InternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setInvoice(getSourceObject());
		getSourceObject().getGoodList().add(invoiceGood);
		return invoiceGood;
	}

	public void setTotal() {
		double total = 0d;
		for(InternalInvoiceGoodDTO good : getSourceObject().getGoodList()) {
			total += good.getQuantity() * good.getGood().getPrices().getPriceAGross();
		}
		getSourceObject().setTotal(total);
	}

	@Override
	public void setVisible(boolean state) {
		super.setVisible(state);
		goodListController.setVisible(!state);
	}

	public void selectGood() {
		super.setVisible(false);
		goodListController.setVisible(true);
	}

	@Override
	public ServiceRepository getService() {
		return service;
	}
}
