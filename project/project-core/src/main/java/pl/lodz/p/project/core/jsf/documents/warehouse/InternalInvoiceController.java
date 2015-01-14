package pl.lodz.p.project.core.jsf.documents.warehouse;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

import java.math.BigDecimal;

@Named
@Scope("request")
public class InternalInvoiceController extends EditObjectController<InternalInvoiceDTO> {

	private static final long serialVersionUID = 7763768017180337728L;

	@Autowired
	private InvoiceGoodListController invoiceGoodListController;

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

	@PostConstruct
	private void init() {
		setSourceObject(new InternalInvoiceDTO());
	}

	public void afterObjectSet(String type) {
		getSourceObject().setType(type);
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(type));
	}

	@Override
	public void save() {
		getSourceObject().setGoodList(invoiceGoodListController.getItems());
		getSourceObject().setDocumentDate(constantElements.getCurrentDate());
		getSourceObject().setIssuePerson(constantElements.getUser());
		service.save(getSourceObject());
	}

	public void addGood() {
		invoiceGoodListController.setVisible(true);

		InternalInvoiceGoodDTO invoiceGood = new InternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setQuantity(new BigDecimal(goodListController.getQuantity()));
		invoiceGoodListController.getItems().add(invoiceGood);

		setTotal();
	}

	public void setTotal() {
		getSourceObject().setTotal(1.0);
	}
}
