package pl.lodz.p.project.core.jsf.documents.saleDocuments;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.PaymentMethodDTO;
import pl.lodz.p.project.core.dto.document.SaleDocumentDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.service.account.UserService;
import pl.lodz.p.project.core.service.contractor.ContractorService;
import pl.lodz.p.project.core.service.document.DocumentNumeratorService;
import pl.lodz.p.project.core.service.document.DocumentPositionService;
import pl.lodz.p.project.core.service.document.DocumentSettingsService;
import pl.lodz.p.project.core.service.document.PaymentMethodService;
import pl.lodz.p.project.core.service.document.SaleDocumentService;
import pl.lodz.p.project.core.service.good.GoodService;

/**
 *
 * @author Łukasz
 */
@Named(value = "vatInvoiceAddEditBean")
@Scope("request")
public class VatInvoiceAddEditBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ContractorService contractorService;

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

	private List<ContractorDTO> contractorsList;
	private List<GoodDTO> allGoodsList;
	private List<DocumentPositionDTO> goodsPositions;
	private List<PaymentMethodDTO> paymentMethods;
	private BigDecimal totalNet, totalGross;

	private String breadcrumb = "Dodaj";
	private GoodDTO selectedGood;
	private SaleDocumentDTO saleDocumentDTO;
	private static final String DOCUMENT_TYPE = "FV";
	private String documentSymbol;

	public VatInvoiceAddEditBean() {
		goodsPositions = new ArrayList<>();

	}

	public void getCurrentSessionUser(String userName) {
		saleDocumentDTO.setIssuePerson(userService.getUserByEmail(userName));
	}

	@PostConstruct
	public void init() {
		totalNet = new BigDecimal(BigInteger.ZERO);
		totalGross = new BigDecimal(BigInteger.ZERO);
		documentSymbol = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isBlank(documentSymbol)) {
			documentSymbol = documentNumeratorService.nextNumber(DOCUMENT_TYPE);
			saleDocumentDTO = new SaleDocumentDTO();
			saleDocumentDTO.setDocumentDate(getTodaysDate());
			saleDocumentDTO.setSaleDate(getTodaysDate());
			saleDocumentDTO.setPaymentDate(getTodaysDate());
			saleDocumentDTO.setSymbol(documentSymbol);
			saleDocumentDTO.setDocumentPlace(documentSettingsService.findDefaultDocumentPlace());
			breadcrumb = "Dodaj";
		} else {
			// saleDocumentDTO = saleDocumentService.getOneById(invoiceId);
			goodsPositions = documentPositionService.getDocumentPositions(documentSymbol);
			breadcrumb = "Edytuj";
			countTotals();
		}
		loadPaymentMethods();
	}

	private void loadPaymentMethods() {
		setPaymentMethods(paymentMethodsService.getAll());
	}

	private Date getTodaysDate() {
		return new Date();
	}

	/**
	 * @return the breadcrumb
	 */
	public String getBreadcrumb() {
		return breadcrumb;
	}

	/**
	 * @param breadcrumb
	 *            the breadcrumb to set
	 */
	public void setBreadcrumb(String breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

	public List<GoodDTO> completeGood(String providedValue) {
		setAllGoodsList(goodService.getAll());
		Collections.sort(getAllGoodsList());
		List<GoodDTO> list = new ArrayList<>();
		for (int i = 0; i < allGoodsList.size(); i++) {
			if (allGoodsList.get(i).getSymbol().toLowerCase().startsWith(providedValue.toLowerCase())
					|| allGoodsList.get(i).getName().toLowerCase().startsWith(providedValue.toLowerCase())) {
				list.add(allGoodsList.get(i));
			}
		}
		return list;
	}

	public List<ContractorDTO> completeBuyer(String providedValue) {
		setContractorsList(contractorService.getAll());
		Collections.sort(getContractorsList());
		List<ContractorDTO> list = new ArrayList<>();
		for (int i = 0; i < contractorsList.size(); i++) {
			if (contractorsList.get(i).getName().toLowerCase().startsWith(providedValue.toLowerCase())
					|| contractorsList.get(i).getSymbol().toLowerCase().startsWith(providedValue.toLowerCase())) {
				list.add(contractorsList.get(i));
			}
		}
		return list;
	}

	public String editInvoice(String id, String whId) {
		return "vatInvoiceAddEdit.xhtml?faces-redirect=true&id=" + id + "&whId=" + whId;
	}

	public void saveInvoice() {
		saleDocumentDTO.setType(DOCUMENT_TYPE);
		saleDocumentDTO.setPaymentMethod((paymentMethodsService.getOneById(saleDocumentDTO.getPaymentMethod().getId())));
		if (StringUtils.isNotBlank(documentSymbol)) {
			// documentsPositionsEndpointLocal.edit(goodsPositions);
			saleDocumentService.save(saleDocumentDTO); // TODO : Proably here
														// should be separte
														// method edit
		} else {
			try {
				saleDocumentDTO.setGoodsPositions(goodsPositions);
				saleDocumentService.save(saleDocumentDTO);
				FacesContext.getCurrentInstance().getExternalContext().redirect("vatInvoicesTable.xhtml");
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
		for (DocumentPositionDTO documentPositionDTO : getGoodsPositions()) {
			documentPositionDTO.setSymbol(symbol);
		}
	}

	public void countTotals() {
		totalNet = BigDecimal.ZERO;
		totalGross = BigDecimal.ZERO;
		for (DocumentPositionDTO documentPositionDTO : getGoodsPositions()) {
			totalNet = totalNet.add(documentPositionDTO.getValueNet());
			totalGross = totalGross.add(documentPositionDTO.getValueGross());
		}

		if (BigDecimal.ZERO.equals(saleDocumentDTO.getDiscount())) {
			saleDocumentDTO.setTotal(totalGross);
		} else {
			BigDecimal hundred = BigDecimal.valueOf(100.00);
			BigDecimal discountMultiplier = hundred.subtract(saleDocumentDTO.getDiscount()).divide(hundred);
			saleDocumentDTO.setTotal(totalGross.multiply(discountMultiplier));
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
					+ saleDocumentDTO.getContractor().getCity() + "\r\nAdress: " + saleDocumentDTO.getContractor().getAdress() + "\r\nNIP: "
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

	public void addGoodPositionToDocument() {
		if (selectedGood != null) {
			DocumentPositionDTO documentPositionDTO = new DocumentPositionDTO();
			documentPositionDTO.setGood(selectedGood);
			documentPositionDTO.setSymbol(documentSymbol);
			documentPositionDTO.setTax(selectedGood.getTax());
			documentPositionDTO.setQuantity(1.0);
			documentPositionDTO.setPriceNet(selectedGood.getPriceANet());
			documentPositionDTO.setPriceGross(selectedGood.getPriceAGross());
			getGoodsPositions().add(documentPositionDTO);

			countTotals();
		}
	}

	public void priceNetChanged(DocumentPositionDTO documentPosition) {
		GoodDTO good = documentPosition.getGood();
		if (documentPosition.getPriceNet().equals(good.getPriceANet())) {
			documentPosition.setPriceGross(good.getPriceAGross());
		} else if (documentPosition.getPriceNet().equals(good.getPriceBNet())) {
			documentPosition.setPriceGross(good.getPriceBGross());
		} else if (documentPosition.getPriceNet().equals(good.getPriceCNet())) {
			documentPosition.setPriceGross(good.getPriceCGross());
		} else {
			throw new IllegalArgumentException("Invalid value of price net");
		}

		countTotals();
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
	 * @return the goodsPositions
	 */
	public List<DocumentPositionDTO> getGoodsPositions() {
		return goodsPositions;
	}

	/**
	 * @param goodsPositions
	 *            the goodsPositions to set
	 */
	public void setGoodsPositions(List<DocumentPositionDTO> goodsPositions) {
		this.goodsPositions = goodsPositions;
	}

	/**
	 * @return the totalNet
	 */
	public BigDecimal getTotalNet() {
		return totalNet;
	}

	/**
	 * @param totalNet
	 *            the totalNet to set
	 */
	public void setTotalNet(BigDecimal totalNet) {
		this.totalNet = totalNet;
	}

	/**
	 * @return the totalGross
	 */
	public BigDecimal getTotalGross() {
		return totalGross;
	}

	/**
	 * @param totalGross
	 *            the totalGross to set
	 */
	public void setTotalGross(BigDecimal totalGross) {
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
}
