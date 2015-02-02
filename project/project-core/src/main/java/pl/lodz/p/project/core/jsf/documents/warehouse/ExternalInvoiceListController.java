package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.jsf.base.EditPageableListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceServiceImpl;

import javax.annotation.PostConstruct;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@Scope("view")
public class ExternalInvoiceListController extends EditPageableListController<ExternalInvoiceDTO> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ExternalInvoiceServiceImpl service;

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
		GUI.redirect("externalIncoming", id);
	}

}
