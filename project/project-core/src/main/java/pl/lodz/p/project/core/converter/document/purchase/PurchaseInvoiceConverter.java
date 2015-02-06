package pl.lodz.p.project.core.converter.document.purchase;

import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.contractor.ContractorConverter;
import pl.lodz.p.project.core.converter.document.items.PaymentMethodConverter;
import pl.lodz.p.project.core.converter.document.items.TransportMeanConverter;
import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.converter.good.TaxConverter;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;
import pl.lodz.p.project.core.domain.document.items.PaymentMethod;
import pl.lodz.p.project.core.domain.document.items.TransportMean;
import pl.lodz.p.project.core.domain.document.purchase.PurchaseInvoice;
import pl.lodz.p.project.core.domain.document.purchase.PurchaseInvoiceGood;
import pl.lodz.p.project.core.domain.document.sale.DocumentPosition;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.purchase.PurchaseInvoiceDTO;
import pl.lodz.p.project.core.dto.document.purchase.PurchaseInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.document.sale.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;
import pl.lodz.p.project.core.dto.document.items.TransportMeanDTO;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Janiu
 */
@Named
@ApplicationScoped
public class PurchaseInvoiceConverter implements Converter<PurchaseInvoice, PurchaseInvoiceDTO> {

	@Inject
	UserConverter userConverter;

	@Inject
	ContractorConverter contractorConverter;

	@Inject
	private GoodConverter goodConverter;

	@Inject
	private TransportMeanConverter transportMeanConverter;

	@Inject
	PaymentMethodConverter paymentMethodConverter;

	@Inject
	TaxConverter taxConverter;

	@Override
	public PurchaseInvoice convertDTO(PurchaseInvoiceDTO objectDTO) {
		Contractor contractor = contractorConverter.convertDTO(objectDTO.getContractor());
		User issuePerson = userConverter.convertDTO(objectDTO.getIssuePerson());
		PaymentMethod paymentMethod = paymentMethodConverter.convertDTO(objectDTO.getPaymentMethod());
		TransportMean transportMean= transportMeanConverter.convertDTO(objectDTO.getTransportMean());

		PurchaseInvoice entity = new PurchaseInvoice();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setContractor(contractor);
		entity.setDiscount(objectDTO.getDiscount());
		entity.setDocumentDate(objectDTO.getDocumentDate());
		entity.setDocumentPlace(objectDTO.getDocumentPlace());
		entity.setIssuePerson(issuePerson);
		entity.setPaymentMethod(paymentMethod);
		entity.setAnnotation(objectDTO.getAnnotation());
		entity.setPaidTotal(objectDTO.getPaidTotal());
		entity.setPaid(objectDTO.isPaid());
		entity.setTransportMean(transportMean);
		entity.setPaymentDate(objectDTO.getPaymentDate());
		entity.setReceivePerson(objectDTO.getReceivePerson());
		entity.setDeliverPerson(objectDTO.getDeliverPerson());
		entity.setPurchaseDate(objectDTO.getPurchaseDate());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setTotal(objectDTO.getTotal());
		entity.setType(objectDTO.getType());
		entity.setWarehouseResult(objectDTO.isWarehouseResult());
		entity.setInvoiceGoodList(new TreeSet<PurchaseInvoiceGood>());

		for (PurchaseInvoiceGoodDTO invoiceGoodDTO : objectDTO.getGoodList()) {
			PurchaseInvoiceGood invoiceGood = new PurchaseInvoiceGood();
			invoiceGood.setId(new InvoiceGoodKey<PurchaseInvoice>());
			invoiceGood.getId().setGood(goodConverter.convertDTO(invoiceGoodDTO.getGood()));
			invoiceGood.getId().setInvoice(entity);
			invoiceGood.setQuantity(invoiceGoodDTO.getQuantity());
			invoiceGood.setTax(taxConverter.convertDTO(invoiceGoodDTO.getTax()));
			invoiceGood.setPriceNet(invoiceGoodDTO.getPriceNet());
			entity.getInvoiceGoodList().add(invoiceGood);
		}
		return entity;
	}

	@Override
	public PurchaseInvoiceDTO convertEntity(PurchaseInvoice entity) {
		ContractorDTO contractor = contractorConverter.convertEntity(entity.getContractor());
		UserDTO issuePerson = userConverter.convertEntity(entity.getIssuePerson());
		PaymentMethodDTO paymentMethod = paymentMethodConverter.convertEntity(entity.getPaymentMethod());
		TransportMeanDTO transportMeanDTO = transportMeanConverter.convertEntity(entity.getTransportMean());

		PurchaseInvoiceDTO objectDTO = new PurchaseInvoiceDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setContractor(contractor);
		objectDTO.setTransportMean(transportMeanDTO);
		objectDTO.setDiscount(entity.getDiscount());
		objectDTO.setDocumentDate(entity.getDocumentDate());
		objectDTO.setDocumentPlace(entity.getDocumentPlace());
		objectDTO.setIssuePerson(issuePerson);
		objectDTO.setAnnotation(entity.getAnnotation());
		objectDTO.setPaymentMethod(paymentMethod);
		objectDTO.setPaidTotal(entity.getPaidTotal());
		objectDTO.setPaid(entity.isPaid());
		objectDTO.setPaymentDate(entity.getPaymentDate());
		objectDTO.setReceivePerson(entity.getReceivePerson());
		objectDTO.setDeliverPerson(entity.getDeliverPerson());
		objectDTO.setPurchaseDate(entity.getPurchaseDate());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setTotal(entity.getTotal());
		objectDTO.setType(entity.getType());
		objectDTO.setWarehouseResult(entity.isWarehouseResult());
		objectDTO.setGoodList(new ArrayList<PurchaseInvoiceGoodDTO>());
		for (PurchaseInvoiceGood invoiceGood : entity.getInvoiceGoodList()) {
			PurchaseInvoiceGoodDTO invoiceGoodDTO = new PurchaseInvoiceGoodDTO();
			invoiceGoodDTO.setGood(goodConverter.convertEntity(invoiceGood.getId().getGood()));
			invoiceGoodDTO.setQuantity(invoiceGood.getQuantity());
			invoiceGoodDTO.setPurchaseInvoiceDTO(objectDTO);
			invoiceGoodDTO.setTax(taxConverter.convertEntity(invoiceGood.getTax()));
			invoiceGoodDTO.setPriceNet(invoiceGood.getPriceNet());
			objectDTO.getGoodList().add(invoiceGoodDTO);
		}

		return objectDTO;
	}

}