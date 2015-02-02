package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.jsf.base.EditPageableListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceService;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class InternalInvoiceListController extends EditPageableListController<InternalInvoiceDTO> {

	private static final long serialVersionUID = -5147461464856795798L;

	@Autowired
	private InternalInvoiceService service;

	@PostConstruct
	private void init() {
		initStartPage(5, "symbol");
		search();
	}

	@Override
	public ServiceRepository getService() {
		return service;
	}

	@Override
	public void edit(String id) {
		GUI.redirect("internalIncoming", id);
	}

}
