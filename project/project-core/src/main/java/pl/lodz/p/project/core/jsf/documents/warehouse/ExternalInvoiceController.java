package pl.lodz.p.project.core.jsf.documents.warehouse;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceService;

@Named
@Scope("request")
public class ExternalInvoiceController extends EditObjectController<ExternalInvoice> {

	private static final long serialVersionUID = 6806332655702953164L;

	@Autowired
	private ExternalInvoiceService service;
	
	@PostConstruct
	private void init() {
		
	}
}
