package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceServiceImpl;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ExternalInvoiceListController extends EditListController<ExternalInvoiceDTO> {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ExternalInvoiceServiceImpl service;

	@Autowired
	private GUI gui;

	@PostConstruct
	private void init() {
		setService(service);
		initStartPage(5, "symbol");
		search();
	}

	@Override
	public String edit(String id) {
		return gui.redirect("externalIncoming", id);
	}

}
