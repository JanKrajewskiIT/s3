package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.jsf.base.EditPageableListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ViewScoped
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
	public String edit(String id) {
		return GUI.redirect("externalIncoming", id);
	}

}
