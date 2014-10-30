package pl.lodz.p.was04.department.core.converter.document;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.converter.account.UserConverter;
import pl.lodz.p.was04.department.core.converter.contractor.ContractorConverter;
import pl.lodz.p.was04.department.core.domain.account.User;
import pl.lodz.p.was04.department.core.domain.contractor.Contractor;
import pl.lodz.p.was04.department.core.domain.document.PaymentMethod;
import pl.lodz.p.was04.department.core.domain.document.SaleDocument;
import pl.lodz.p.was04.department.core.dto.account.UserDTO;
import pl.lodz.p.was04.department.core.dto.contractor.ContractorDTO;
import pl.lodz.p.was04.department.core.dto.document.PaymentMethodDTO;
import pl.lodz.p.was04.department.core.dto.document.SaleDocumentDTO;

/**
 *
 * @author Janiu
 */
@Named
@ApplicationScoped
public class SaleDocumentConverter implements Converter<SaleDocument, SaleDocumentDTO> {

    @Inject
	UserConverter userConverter;

    @Inject
	ContractorConverter contractorConverter;

    @Inject
	PaymentMethodConverter paymentMethodConverter;
	
	@Override
	public SaleDocument convertDTO(SaleDocumentDTO objectDTO) {
		Contractor contractor = contractorConverter.convertDTO(objectDTO.getContractor());
		Contractor receivePerson = contractorConverter.convertDTO(objectDTO.getReceivePerson());
		User issuePerson = userConverter.convertDTO(objectDTO.getIssuePerson());
		PaymentMethod methodOfPayment = paymentMethodConverter.convertDTO(objectDTO.getMethodOfPayment());
		
		SaleDocument entity = new SaleDocument();
		entity.setId(objectDTO.getId());
		entity.setContractor(contractor);
		entity.setDiscount(objectDTO.getDiscount());
		entity.setDocumentDate(objectDTO.getDocumentDate());
		entity.setDocumentPlace(objectDTO.getDocumentPlace());
		entity.setIssuePerson(issuePerson);
		entity.setMethodOfPayment(methodOfPayment);
		entity.setOrderSymbol(objectDTO.getOrderSymbol());
		entity.setPaidTotal(objectDTO.getPaidTotal());
		entity.setPaid(objectDTO.isPaid());
		entity.setPaymentDate(objectDTO.getPaymentDate());
		entity.setReceivePerson(receivePerson);
		entity.setSaleDate(objectDTO.getSaleDate());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setTotal(objectDTO.getTotal());
		entity.setType(objectDTO.getType());
		entity.setWarehouseResult(objectDTO.isWarehouseResult());
		return entity;
	}

	@Override
	public SaleDocumentDTO convertEntity(SaleDocument entity) {
		ContractorDTO contractor = contractorConverter.convertEntity(entity.getContractor());
		ContractorDTO receivePerson = contractorConverter.convertEntity(entity.getReceivePerson());
		UserDTO issuePerson = userConverter.convertEntity(entity.getIssuePerson());
		PaymentMethodDTO methodOfPayment = paymentMethodConverter.convertEntity(entity.getMethodOfPayment());
		
		SaleDocumentDTO objectDTO = new SaleDocumentDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setContractor(contractor);
		objectDTO.setDiscount(entity.getDiscount());
		objectDTO.setDocumentDate(objectDTO.getDocumentDate());
		objectDTO.setDocumentPlace(entity.getDocumentPlace());
		objectDTO.setIssuePerson(issuePerson);
		objectDTO.setMethodOfPayment(methodOfPayment);
		objectDTO.setOrderSymbol(entity.getOrderSymbol());
		objectDTO.setPaidTotal(entity.getPaidTotal());
		objectDTO.setPaid(entity.isPaid());
		objectDTO.setPaymentDate(entity.getPaymentDate());
		objectDTO.setReceivePerson(receivePerson);
		objectDTO.setSaleDate(entity.getSaleDate());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setTotal(entity.getTotal());
		objectDTO.setType(entity.getType());
		objectDTO.setWarehouseResult(entity.isWarehouseResult());
		return objectDTO;
	}

}