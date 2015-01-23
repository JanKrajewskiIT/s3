package pl.lodz.p.project.core.jsf.documents.saleDocuments;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.jsf.base.DateUtil;
import pl.lodz.p.project.core.jsf.base.EditObjectController;
import pl.lodz.p.project.core.jsf.base.GUI;
import pl.lodz.p.project.core.jsf.config.ConstantElements;
import pl.lodz.p.project.core.jsf.documents.warehouse.ContractorListController;
import pl.lodz.p.project.core.jsf.documents.warehouse.GoodListController;
import pl.lodz.p.project.core.service.account.UserService;
import pl.lodz.p.project.core.service.contractor.ContractorService;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.items.DocumentPositionService;
import pl.lodz.p.project.core.service.document.items.DocumentSettingsService;
import pl.lodz.p.project.core.service.document.items.PaymentMethodService;
import pl.lodz.p.project.core.service.document.sale.SaleDocumentService;
import pl.lodz.p.project.core.service.good.GoodService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private ContractorService contractorService;

	@Autowired
	private ContractorListController contractorListController;

	@Autowired
	private GoodService goodService;

	@Autowired
	private SaleDocumentService saleDocumentService;

	@Autowired
	private DocumentNumeratorService documentNumeratorService;

	@Autowired
	private PaymentMethodService paymentMethodsService;

	@Autowired
	private DocumentSettingsService documentSettingsService;

	@Autowired
	private UserService userService;

	@Autowired
	private DocumentPositionService documentPositionService;

	@Autowired
	private GoodListController goodListController;

	@Autowired
	private ConstantElements constantElements;

	private List<ContractorDTO> contractorsList;
	private List<GoodDTO> allGoodsList;
	private List<PaymentMethodDTO> paymentMethods;
	private Double totalNet, totalGross;

	private GoodDTO selectedGood;
	private SaleDocumentDTO saleDocumentDTO;
	private String documentSymbol;

	public VatInvoiceController() {

	}

	public void afterObjectSet(String type) {
		init();
		setVisible(true);
		getSourceObject().setType(type);
		getSourceObject().setSymbol(documentNumeratorService.nextNumber(type));
	}

	public void addContractor() {
		setVisible(true);
		getSourceObject().setContractor(contractorListController.getSingleSelection());
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

	@PostConstruct
	public void init() {
		setSourceObject(new SaleDocumentDTO());
		getSourceObject().setGoodList(new ArrayList<DocumentPositionDTO>());
		getSourceObject().setSaleDate(DateUtil.getCurrentDate());
		getSourceObject().setPaymentDate(DateUtil.getCurrentDate());
		getSourceObject().setPaymentMethod(new PaymentMethodDTO());
		getSourceObject().setDocumentPlace(documentSettingsService.findDefaultDocumentPlace());
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


	private void loadPaymentMethods() {
		setPaymentMethods(paymentMethodsService.getAll());
	}


	public String editInvoice(String id, String whId) {
		return "vatInvoice.xhtml?faces-redirect=true&id=" + id + "&whId=" + whId;
	}

	public void saveInvoice() {
		saleDocumentDTO.setPaymentMethod((paymentMethodsService.getOneById(saleDocumentDTO.getPaymentMethod().getId())));
		if (StringUtils.isNotBlank(documentSymbol)) {
			// documentsPositionsEndpointLocal.edit(goodsPositions);
			saleDocumentService.save(saleDocumentDTO); // TODO : Proably here
														// should be separte
														// method edit
		} else {
			try {
				//saleDocumentDTO.setGoodList(goodsPositions);
				saleDocumentService.save(saleDocumentDTO);
				FacesContext.getCurrentInstance().getExternalContext().redirect("vatInvoiceList.xhtml");
				// } catch (DocumentSymbolAlreadyInUseException e) {
				// System.out.println("DocumentSymbolAlreadyInUseException!!!");
				// documentSymbol =
				// documentNumeratorEndpoint.nextNumber(DOCUMENT_TYPE);
				// updateDocumentSymbol(documentSymbol);
				// FacesContext.getCurrentInstance().addMessage(null,
				// new FacesMessage("Symbol dokumentu jest już zajęty",
				// "Symbol został ustawiony na najbliższy wolny"));
				// } catch (WarehouseQuantityLimitExceededException e) {
				// System.out.println("WarehouseQuantityLimitExceededException - max qty: "
				// + e.getMaxAvailableQuantity());
				// FacesContext.getCurrentInstance().addMessage(
				// null,
				// new FacesMessage("Brak wpisanej ilości w magazynie",
				// "Dostępna ilosć " + e.getGood().getName() + " w magazynie: "
				// + e.getMaxAvailableQuantity()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void updateDocumentSymbol(String symbol) {
		saleDocumentDTO.setSymbol(symbol);
		for (DocumentPositionDTO documentPositionDTO : getSourceObject().getGoodList()) {
			documentPositionDTO.setSymbol(symbol);
		}
	}

	public void setTotal() {
		totalNet = 0d;
		totalGross = 0d;
		for (DocumentPositionDTO documentPositionDTO : getSourceObject().getGoodList()) {
			totalNet = totalNet + documentPositionDTO.getValueNet();
			totalGross = totalGross + documentPositionDTO.getValueGross();
		}

		if (getSourceObject().getDiscount() == 0) {
			getSourceObject().setTotal(totalGross);
		} else {
			Double hundred = 100.00;
			Double discountMultiplier = 100 - (getSourceObject().getDiscount() / hundred);
			getSourceObject().setTotal(totalGross * discountMultiplier);
		}

	}

	/**
	 * @return the contractorsList
	 */
	public List<ContractorDTO> getContractorsList() {
		return contractorsList;
	}

	/**
	 * @param contractorsList
	 *            the contractorsList to set
	 */
	public void setContractorsList(List<ContractorDTO> contractorsList) {
		this.contractorsList = contractorsList;
	}

	public String buyerToTextAreaString() {
		if (saleDocumentDTO.getContractor() != null) {
			return "Symbol: " + saleDocumentDTO.getContractor().getSymbol() + "\r\nNazwa: " + saleDocumentDTO.getContractor().getName() + "\r\nMiasto: "
					+ saleDocumentDTO.getContractor().getAddress().getCity() + "\r\nAdress: " + saleDocumentDTO.getContractor().getAddress().getAddress() + "\r\nNIP: "
					+ saleDocumentDTO.getContractor().getNip();
		} else {
			return "";
		}
	}

	/**
	 * @return the allGoodsList
	 */
	public List<GoodDTO> getAllGoodsList() {
		return allGoodsList;
	}

	/**
	 * @param allGoodsList
	 *            the allGoodsList to set
	 */
	public void setAllGoodsList(List<GoodDTO> allGoodsList) {
		this.allGoodsList = allGoodsList;
	}

	/**
	 * @return the selectedGood
	 */
	public GoodDTO getSelectedGood() {
		return selectedGood;
	}

	/**
	 * @param selectedGood
	 *            the selectedGood to set
	 */
	public void setSelectedGood(GoodDTO selectedGood) {
		this.selectedGood = selectedGood;
	}


	public void priceNetChanged(DocumentPositionDTO documentPosition) {
		GoodDTO good = documentPosition.getGood();
		if (documentPosition.getPriceNet().equals(good.getPrices().getPriceANet())) {
			documentPosition.setPriceGross(good.getPrices().getPriceAGross());
		} else if (documentPosition.getPriceNet().equals(good.getPrices().getPriceBNet())) {
			documentPosition.setPriceGross(good.getPrices().getPriceBGross());
		} else if (documentPosition.getPriceNet().equals(good.getPrices().getPriceCNet())) {
			documentPosition.setPriceGross(good.getPrices().getPriceCGross());
		} else {
			throw new IllegalArgumentException("Invalid value of price net");
		}

		setTotal();
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

	public void clear() {
		setSaleDocumentDTO(new SaleDocumentDTO());
	}

	/**
	 * @return the saleDocumentDTO
	 */
	public SaleDocumentDTO getSaleDocumentDTO() {
		return saleDocumentDTO;
	}

	/**
	 * @param saleDocumentDTO
	 *            the saleDocumentDTO to set
	 */
	public void setSaleDocumentDTO(SaleDocumentDTO saleDocumentDTO) {
		this.saleDocumentDTO = saleDocumentDTO;
	}
	/**
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

	/**
	 * @return the paymentMethods
	 */
	public List<PaymentMethodDTO> getPaymentMethods() {
		return paymentMethods;
	}

	/**
	 * @param paymentMethods
	 *            the paymentMethods to set
	 */
	public void setPaymentMethods(List<PaymentMethodDTO> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	@Override
	public void save() {
		getSourceObject().setIssuePerson(constantElements.getUser());
		getSourceObject().setDocumentDate(constantElements.getCurrentDate());
		saleDocumentService.save(getSourceObject());
	}
}
