package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.jsf.base.EditListController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.service.document.warehouse.InternalInvoiceServiceImpl;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named
@Scope("request")
public class InternalInvoiceListController extends EditListController<InternalInvoiceDTO> {

	private static final long serialVersionUID = -5147461464856795798L;

	@Autowired
	private InternalInvoiceServiceImpl service;

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
		return gui.redirect("", id);
	}

}
