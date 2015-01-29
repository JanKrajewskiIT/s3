package pl.lodz.p.project.core.jsf.documents.saleDocuments;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;
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
import pl.lodz.p.project.core.service.document.sale.SaleDocumentService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;

/**
 *
 * @author Łukasz
 */
@Named
@ViewScoped
public class VatInvoiceController extends EditObjectController<SaleDocumentDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6806332655702953164L;


	@Autowired
	private ContractorListController contractorListController;


	@Autowired
	private SaleDocumentService service;

	@Autowired
	private DocumentNumeratorService documentNumeratorService;


	@Autowired
	private DocumentSettingsService documentSettingsService;



	@Autowired
	private GoodListController goodListController;

	@Autowired
	private ConstantElements constantElements;

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

	public String forwardContractor() {
		String id = getSourceObject().getContractor().getId().toString();
		return GUI.redirect("contractorTemplate", id);
	}


	public void addGood() {
		setVisible(true);
		DocumentPositionDTO documentPosition = new DocumentPositionDTO();
		documentPosition.setGood(goodListController.getSingleSelection());
		documentPosition.setQuantity(goodListController.getQuantity());
		getSourceObject().getGoodList().add(documentPosition);
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

	@PostConstruct
	@Override
	public void createNew() {
		setSourceObject(new SaleDocumentDTO());
		getSourceObject().setGoodList(new ArrayList<DocumentPositionDTO>());
		getSourceObject().setSaleDate(DateUtil.getCurrentDate());
		getSourceObject().setPaymentDate(DateUtil.getCurrentDate());
		getSourceObject().setPaymentMethod(new PaymentMethodDTO());
		getSourceObject().setDocumentPlace(documentSettingsService.findDefaultDocumentPlace());
		getSourceObject().setIssuePerson(constantElements.getUser());
		getSourceObject().setDeliverPerson(getSourceObject().getIssuePerson().getFirstName() + " " + getSourceObject().getIssuePerson().getSecondName());
		/*totalNet = 0d;
		totalGross = 0d;
		documentSymbol = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isBlank(documentSymbol)) {
			documentSymbol = documentNumeratorService.nextNumber(DOCUMENT_TYPE);
			saleDocumentDTO = new SaleDocumentDTO();

			saleDocumentDTO.setSymbol(documentSymbol);
			breadcrumb = "Dodaj";
		} else {
			// saleDocumentDTO = saleDocumentService.getOneById(invoiceId);
			goodsPositions = documentPositionService.getDocumentPositions(documentSymbol);
			breadcrumb = "Edytuj";
			countTotals();
		}
		loadPaymentMethods();*/
	}
/*
	public String editInvoice(String id, String whId) {
		return "vatInvoice.xhtml?faces-redirect=true&id=" + id + "&whId=" + whId;
	}*/

	public void saveInvoice() {
		/*saleDocumentDTO.setPaymentMethod((paymentMethodsService.getOneById(saleDocumentDTO.getPaymentMethod().getId())));
//		if (StringUtils.isNotBlank(documentSymbol)) {
			documentsPositionsEndpointLocal.edit(goodsPositions);
//			saleDocumentService.save(saleDocumentDTO); // TODO : Proably here
														should be separte
														method edit
//		} else {
//			try {
				saleDocumentDTO.setGoodList(goodsPositions);
//				saleDocumentService.save(saleDocumentDTO);
//				FacesContext.getCurrentInstance().getExternalContext().redirect("vatInvoiceList.xhtml");
				} catch (DocumentSymbolAlreadyInUseException e) {
				System.out.println("DocumentSymbolAlreadyInUseException!!!");
				documentSymbol =
				documentNumeratorEndpoint.nextNumber(DOCUMENT_TYPE);
				updateDocumentSymbol(documentSymbol);
				FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Symbol dokumentu jest już zajęty",
				"Symbol został ustawiony na najbliższy wolny"));
				} catch (WarehouseQuantityLimitExceededException e) {
				System.out.println("WarehouseQuantityLimitExceededException - max qty: "
				+ e.getMaxAvailableQuantity());
				FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage("Brak wpisanej ilości w magazynie",
				"Dostępna ilosć " + e.getGood().getName() + " w magazynie: "
				+ e.getMaxAvailableQuantity()));
//			} catch (IOException e) {
//				e.printStackTrace();
//			}*/
		//}

	}

	/*private void updateDocumentSymbol(String symbol) {
		saleDocumentDTO.setSymbol(symbol);
		for (DocumentPositionDTO documentPositionDTO : getSourceObject().getGoodList()) {
			documentPositionDTO.setSymbol(symbol);
		}
	}*/

	public void setTotal() {
		totalNet = 0d;
		totalGross = 0d;
		for (DocumentPositionDTO documentPositionDTO : getSourceObject().getGoodList()) {
			totalNet = totalNet + (documentPositionDTO.getGood().getPrices().getPriceANet() * documentPositionDTO.getQuantity());
			totalGross = totalGross + (documentPositionDTO.getGood().getPrices().getPriceAGross() * documentPositionDTO.getQuantity());
		}

		if (getSourceObject().getDiscount() == 0) {
			getSourceObject().setTotal(totalGross);
		} else {
			Double hundred = 100.00;
			Double discountMultiplier = 100 - (getSourceObject().getDiscount() / hundred);
			getSourceObject().setTotal(totalGross * discountMultiplier);
		}

	}

	// public void quantityChanged(DocumentPositionDTO documentPosition) {
	// GoodDTO good = documentPosition.getGood();
	// double newQuantity = documentPosition.getQuantity();
	// try {
	// warehousesGoodsEndpoint.isAvailable(good.getId(), warehouseId,
	// newQuantity);
	// } catch (WarehouseQuantityLimitExceededException e) {
	// System.out.println("WarehouseQuantityLimitExceededException - max qty: "
	// + e.getMaxAvailableQuantity());
	// documentPosition.setQuantity(e.getMaxAvailableQuantity());
	// FacesContext.getCurrentInstance().addMessage(
	// null,
	// new FacesMessage("Brak wpisanej ilości w magazynie", "Zmniejszono ilosć "
	// + good.getName() + " do dostępnego stanu: "
	// + e.getMaxAvailableQuantity()));
	// } finally {
	// countTotals();
	// }
	//
	// }

	/*
	 * @return the totalNet
	 */
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
	}

	@Override
	public ServiceRepository getService() {
		return service;
	}


}
