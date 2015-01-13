package pl.lodz.p.project.core.jsf.documents.warehouse;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.DateUtil;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

import java.math.BigDecimal;

@Named
@Scope("request")
public class InternalInvoiceController extends EditObjectController<InternalInvoiceDTO> {

	private static final long serialVersionUID = 7763768017180337728L;

	private enum Type {
		ANY, WZ, PZ
	}

	@Autowired
	private InvoiceGoodListController invoiceGoodListController;

	@Autowired
	private GoodListController goodListController;

	@Autowired
	private InternalInvoiceService service;

	@Autowired
	private DocumentNumeratorService documentNumeratorService;

	@PostConstruct
	private void init() {
		setSourceObject(new InternalInvoiceDTO());
		getSourceObject().setTotal(12d);
		getSourceObject().setType(Type.WZ.name());
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(Type.WZ.name()));
	}

	@Override
	public void save() {
		getSourceObject().setGoodList(invoiceGoodListController.getItems());
		getSourceObject().setDocumentDate(DateUtil.getCurrentDate());
		service.save(getSourceObject());
	}

	public void addGood() {
		invoiceGoodListController.setVisible(true);

		InternalInvoiceGoodDTO invoiceGood = new InternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setQuantity(new BigDecimal(goodListController.getQuantity()));
		invoiceGoodListController.getItems().add(invoiceGood);
	}

	public String getCurrentDate() {
		return DateUtil.getCurrentDateValue();
	}

}
