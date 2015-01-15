package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.jsf.base.EditListController;

import javax.inject.Named;

@Named
@Scope("request")
public class InternalInvoiceListController extends EditListController<InternalInvoice> {

	private static final long serialVersionUID = -5147461464856795798L;

}
