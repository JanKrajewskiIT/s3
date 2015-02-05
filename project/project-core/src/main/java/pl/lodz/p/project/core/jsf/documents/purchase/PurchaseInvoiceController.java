package pl.lodz.p.project.core.jsf.documents.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import pl.lodz.p.project.core.dto.document.purchase.PurchaseInvoiceDTO;
import pl.lodz.p.project.core.dto.document.purchase.PurchaseInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.document.sale.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;
import pl.lodz.p.project.core.jsf.base.DateUtil;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.jsf.contractor.ContractorListController;
import pl.lodz.p.project.core.jsf.good.GoodListController;
import pl.lodz.p.project.core.service.base.ServiceRepository;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.items.DocumentSettingsService;
import pl.lodz.p.project.core.service.document.purchase.PurchaseInvoiceService;
import pl.lodz.p.project.core.service.document.sale.SaleDocumentService;

import javax.inject.Named;
import java.util.ArrayList;

/**
 *
 * @author Łukasz
 */
@Named
@Scope("view")
public class PurchaseInvoiceController extends EditObjectController<PurchaseInvoiceDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6806332655702953164L;


	@Autowired
	private ContractorListController contractorListController;


	@Autowired
	private PurchaseInvoiceService service;

	@Autowired
	private DocumentNumeratorService documentNumeratorService;


	@Autowired
	private DocumentSettingsService documentSettingsService;



	@Autowired
	private GoodListController goodListController;

	@Autowired
	private ConstantElements constantElements;

	@Autowired
	GUI gui;
	private Double totalNet, totalGross;


	public void afterObjectSet(String type) {
		init();
		setVisible(true);
		getSourceObject().setType(type);
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(type));
	}

	public void addContractor() {
		setVisible(true);
		getSourceObject().setContractor(contractorListController.getSingleSelection());
		getSourceObject().setReceivePerson(contractorListController.getSingleSelection().getName());
	}

	public void forwardContractor() {
		String id = getSourceObject().getContractor().getId().toString();
		GUI.redirect("contractorTemplate", id);
	}


	public void addGood() {
		setVisible(true);
		PurchaseInvoiceGoodDTO purchaseInvoiceGood = new PurchaseInvoiceGoodDTO();
		purchaseInvoiceGood.setGood(goodListController.getSingleSelection());
		purchaseInvoiceGood.setQuantity(goodListController.getQuantity());
		purchaseInvoiceGood.setTax(goodListController.getSingleSelection().getTax());
		purchaseInvoiceGood.setPriceNet(goodListController.getSingleSelection().getPrices().getPriceANet());
		getSourceObject().getGoodList().add(purchaseInvoiceGood);
		setTotal();
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

	@Override
	public void createNew() {
		setSourceObject(new PurchaseInvoiceDTO());
		getSourceObject().setGoodList(new ArrayList<PurchaseInvoiceGoodDTO>());
		getSourceObject().setTransportMean(new TransportMeanDTO());
		getSourceObject().setPurchaseDate(DateUtil.getCurrentDate());
		getSourceObject().setPaymentDate(DateUtil.getCurrentDate());
		getSourceObject().setPaymentMethod(new PaymentMethodDTO());
		getSourceObject().setDocumentPlace(documentSettingsService.findDefaultDocumentPlace());
		getSourceObject().setIssuePerson(constantElements.getUser());
		getSourceObject().setDeliverPerson(getSourceObject().getIssuePerson().getFirstName() + " " + getSourceObject().getIssuePerson().getSecondName());

	}

	public void setTotal() {
		totalNet = 0d;
		totalGross = 0d;
		for (PurchaseInvoiceGoodDTO purchaseInvoiceGoodDTO : getSourceObject().getGoodList()) {
			totalNet = totalNet + (purchaseInvoiceGoodDTO.getGood().getPrices().getPriceANet() * purchaseInvoiceGoodDTO.getQuantity());
			totalGross = totalGross + (purchaseInvoiceGoodDTO.getGood().getPrices().getPriceAGross() * purchaseInvoiceGoodDTO.getQuantity());
		}

		if (getSourceObject().getDiscount() == 0) {
			getSourceObject().setTotal(totalGross);
		} else {
			Double hundred = 100.00;
			Double discountMultiplier = 100 - (getSourceObject().getDiscount() / hundred);
			getSourceObject().setTotal(totalGross * discountMultiplier);
		}

	}

	public Double getTotalNet() {
		return totalNet;
	}

	/**
	 * @param totalNet
	 *            the totalNet to set
	 */
	public void setTotalNet(Double totalNet) {
		this.totalNet = totalNet;
	}

	/**
	 * @return the totalGross
	 */
	public Double getTotalGross() {
		return totalGross;
	}

	/**
	 * @param totalGross
	 *            the totalGross to set
	 */
	public void setTotalGross(Double totalGross) {
		this.totalGross = totalGross;
	}


	@Override
	public void save() {
		getSourceObject().setIssuePerson(constantElements.getUser());
		getSourceObject().setDocumentDate(constantElements.getCurrentDate());
		super.save();
		gui.showInformationMessage("Fakutra zakupu została zapisana!");
		if (getSourceObject().isWarehouseResult() && getSourceObject().isNew())
			gui.showInformationMessage("Utworzono również dokument magazynowy PZ!");
	}

	@Override
	public ServiceRepository getService() {
		return service;
	}


}
