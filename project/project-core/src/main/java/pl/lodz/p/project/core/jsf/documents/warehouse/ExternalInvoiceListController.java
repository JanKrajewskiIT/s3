package pl.lodz.p.project.core.jsf.documents.warehouse;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.jsf.base.EditListController;

@Named
@ViewScoped
public class ExternalInvoiceListController extends EditListController<ExternalInvoice> {

	private static final long serialVersionUID = -7059378245504886251L;

}