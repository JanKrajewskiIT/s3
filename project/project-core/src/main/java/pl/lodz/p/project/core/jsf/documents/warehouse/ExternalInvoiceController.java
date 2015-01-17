package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.items.TransportMeanService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.List;
import java.util.function.Function;

@Named
@ViewScoped
public class ExternalInvoiceController extends EditObjectController<ExternalInvoiceDTO> {

	private static final long serialVersionUID = 6806332655702953164L;

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
		setSourceObject(new ExternalInvoiceDTO());
		transportMeanList = transportMeanService.getAll();
	}

	public void afterObjectSet(String type) {
		init();
		setVisible(true);
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

	public void addContractor() {
		setVisible(true);
		getSourceObject().setContractor(contractorListController.getSingleSelection());
	}

	public String forwardContractor() {
		String id = getSourceObject().getContractor().getId().toString();
		return gui.redirect("contractorTemplate", id);
	}

	public void addGood() {
		setVisible(true);

		ExternalInvoiceGoodDTO invoiceGood = new ExternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setQuantity(goodListController.getQuantity());
		getSourceObject().getGoodList().add(invoiceGood);

		setTotal();
	}

	public void setTotal() {
		double total = 0d;
		for(ExternalInvoiceGoodDTO good : getSourceObject().getGoodList()) {
			total += good.getQuantity() * good.getGood().getPrices().getPriceAGross();
		}
		getSourceObject().setTotal(total);
	}

	public void setVisible(boolean state) {
		super.setVisible(state);
		goodListController.setVisible(!state);
		contractorListController.setVisible(!state);
	}

	public void selectContractor() {
		super.setVisible(false);
		goodListController.setVisible(false);
		contractorListController.setVisible(true);
	}

	public void selectGood() {
		super.setVisible(false);
		goodListController.setVisible(true);
		contractorListController.setVisible(false);
	}

	public List<TransportMeanDTO> getTransportMeanList() {
		return transportMeanList;
	}

	public void setTransportMeanList(List<TransportMeanDTO> transportMeanList) {
		this.transportMeanList = transportMeanList;
	}

}
