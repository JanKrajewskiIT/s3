package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.jsf.good.GoodListController;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named
@ViewScoped
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

	@PostConstruct
	private void init() {
		setSourceObject(new InternalInvoiceDTO());
		getSourceObject().setGoodList(new ArrayList<InternalInvoiceGoodDTO>());
		setTotal();
	}

	public void afterObjectSet(String type) {
		init();
		setVisible(true);
		getSourceObject().setType(type);
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(type));
	}

	@Override
	public void save() {
		getSourceObject().setDocumentDate(constantElements.getCurrentDate());
		getSourceObject().setIssuePerson(constantElements.getUser());
		service.save(getSourceObject());
	}

	public void addGood() {
		setVisible(true);

		InternalInvoiceGoodDTO invoiceGood = new InternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setQuantity(goodListController.getQuantity());
		invoiceGood.setInvoice(getSourceObject());
		getSourceObject().getGoodList().add(invoiceGood);

		setTotal();
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
}
