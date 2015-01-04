package pl.lodz.p.project.core.jsf.documents.warehouse;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

@Named
@Scope("request")
public class InternalInvoiceController extends EditObjectController<InternalInvoice> {

	private static final long serialVersionUID = 7763768017180337728L;

	@Autowired
	private InternalInvoiceService service;
	
	@PostConstruct
	private void init() {
		InternalInvoice invoice = new InternalInvoice();
		invoice.setDeliverPerson("Jan Krajewski");
		setSourceObject(invoice);
	}
}
