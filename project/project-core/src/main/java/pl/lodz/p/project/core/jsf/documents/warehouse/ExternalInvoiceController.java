package pl.lodz.p.project.core.jsf.documents.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.items.TransportMeanService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceGoodService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

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
	private ExternalInvoiceGoodService goodService;

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
		getSourceObject().setTransportMean(new TransportMeanDTO());
		getSourceObject().setGoodList(goodService.getGoodsByInvoice(getSourceObject().getId()));
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
		goodService.save(getSourceObject().getGoodList());
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
		invoiceGood.setInvoice(getSourceObject());
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
		System.out.println("ELO313");
		super.setVisible(false);
		goodListController.setVisible(false);
		contractorListController.setVisible(true);
	}

	public void selectGood() {
		System.out.println("ELO312");
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
