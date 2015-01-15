package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.items.TransportMeanService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceService;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;

@Named
@Scope("request")
public class ExternalInvoiceController extends EditObjectController<ExternalInvoiceDTO> {

	private static final long serialVersionUID = 6806332655702953164L;

	@Autowired
	private InvoiceGoodListController invoiceGoodListController;

	@Autowired
	private GoodListController goodListController;

	@Autowired
	private ContractorListController contractorListController;

	@Autowired
	private ExternalInvoiceService service;

	@Autowired
	private TransportMeanService transportMeanService;

	@Autowired
	private DocumentNumeratorService documentNumeratorService;

	@Autowired
	private ConstantElements constantElements;

	@Autowired
	private GUI gui;

	private List<TransportMeanDTO> transportMeanList;

	@PostConstruct
	private void init() {
		contractorListController.setVisible(false);
		setSourceObject(new ExternalInvoiceDTO());
		transportMeanList = transportMeanService.getAll();
	}

	public void afterObjectSet(String type) {
		getSourceObject().setType(type);
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(type));
	}

	@Override
	public void save() {
		//getSourceObject().setGoodList(invoiceGoodListController.getItems());
		getSourceObject().setIssuePerson(constantElements.getUser());
		getSourceObject().setDocumentDate(constantElements.getCurrentDate());
		service.save(getSourceObject());
	}

	public void addGood() {
		invoiceGoodListController.setVisible(true);

		InternalInvoiceGoodDTO invoiceGood = new InternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setQuantity(goodListController.getQuantity());
		invoiceGoodListController.getItems().add(invoiceGood);

		setTotal();
	}

	public void addContractor() {
		contractorListController.setVisible(false);
		setVisible(true);
		getSourceObject().setContractor(contractorListController.getSingleSelection());
	}

	public void selectContractor() {
		contractorListController.setVisible(true);
		setVisible(false);
	}

	public String forwardContractor() {
		String id = getSourceObject().getContractor().getId().toString();
		return gui.redirect("contractorTemplate", id);
	}

	public void setTotal() {
		getSourceObject().setTotal(1.0);
	}

	public List<TransportMeanDTO> getTransportMeanList() {
		return transportMeanList;
	}

	public void setTransportMeanList(List<TransportMeanDTO> transportMeanList) {
		this.transportMeanList = transportMeanList;
	}

}
