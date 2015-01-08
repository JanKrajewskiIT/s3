package pl.lodz.p.project.core.jsf.documents.warehouse;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.jsf.base.DateUtil;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.service.document.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.TransportMeanService;
import pl.lodz.p.project.core.service.document.warehouse.ExternalInvoiceService;
import java.math.BigDecimal;
import java.util.List;

@Named
@ViewScoped
public class ExternalInvoiceController extends EditObjectController<ExternalInvoiceDTO> {

	private static final long serialVersionUID = 6806332655702953164L;

	private enum Type {
		ANY, RW, PW
	}

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

	private List<TransportMeanDTO> transportMeanList;

	@PostConstruct
	private void init() {
		contractorListController.setVisible(false);

		setSourceObject(new ExternalInvoiceDTO());
		getSourceObject().setTotal(12d);
		getSourceObject().setType(Type.RW.name());
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(Type.RW.name()));

		transportMeanList = transportMeanService.getAll();
	}

	@Override
	public void save() {
		//getSourceObject().setGoodList(invoiceGoodListController.getItems());
		getSourceObject().setDocumentDate(DateUtil.getCurrentDate());
		service.save(getSourceObject());
	}

	public void addGood() {
		invoiceGoodListController.setVisible(true);

		InternalInvoiceGoodDTO invoiceGood = new InternalInvoiceGoodDTO();
		invoiceGood.setGood(goodListController.getSingleSelection());
		invoiceGood.setQuantity(new BigDecimal(goodListController.getQuantity()));
		invoiceGoodListController.getItems().add(invoiceGood);
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

	public String getCurrentDate() {
		return DateUtil.getCurrentDateValue();
	}

	public List<TransportMeanDTO> getTransportMeanList() {
		return transportMeanList;
	}

	public void setTransportMeanList(List<TransportMeanDTO> transportMeanList) {
		this.transportMeanList = transportMeanList;
	}

}
