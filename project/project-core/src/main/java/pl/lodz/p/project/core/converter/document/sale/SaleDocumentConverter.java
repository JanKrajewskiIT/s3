package pl.lodz.p.project.core.converter.document.sale;

import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.contractor.ContractorConverter;
import pl.lodz.p.project.core.converter.document.items.PaymentMethodConverter;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.items.PaymentMethod;
import pl.lodz.p.project.core.domain.document.sale.SaleDocument;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.items.PaymentMethodDTO;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
		User issuePerson = userConverter.convertDTO(objectDTO.getIssuePerson());
		PaymentMethod paymentMethod = paymentMethodConverter.convertDTO(objectDTO.getPaymentMethod());
		
		SaleDocument entity = new SaleDocument();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setContractor(contractor);
		entity.setDiscount(objectDTO.getDiscount());
		entity.setDocumentDate(objectDTO.getDocumentDate());
		entity.setDocumentPlace(objectDTO.getDocumentPlace());
		entity.setIssuePerson(issuePerson);
		entity.setPaymentMethod(paymentMethod);
		entity.setOrderSymbol(objectDTO.getOrderSymbol());
		entity.setAnnotation(objectDTO.getAnnotation());
		entity.setPaidTotal(objectDTO.getPaidTotal());
		entity.setPaid(objectDTO.isPaid());
		entity.setPaymentDate(objectDTO.getPaymentDate());
		entity.setReceivePerson(objectDTO.getReceivePerson());
		entity.setDeliverPerson(objectDTO.getDeliverPerson());
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
		UserDTO issuePerson = userConverter.convertEntity(entity.getIssuePerson());
		PaymentMethodDTO paymentMethod = paymentMethodConverter.convertEntity(entity.getPaymentMethod());
		
		SaleDocumentDTO objectDTO = new SaleDocumentDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setContractor(contractor);
		objectDTO.setDiscount(entity.getDiscount());
		objectDTO.setDocumentDate(objectDTO.getDocumentDate());
		objectDTO.setDocumentPlace(entity.getDocumentPlace());
		objectDTO.setIssuePerson(issuePerson);
		objectDTO.setAnnotation(entity.getAnnotation());
		objectDTO.setPaymentMethod(paymentMethod);
		objectDTO.setOrderSymbol(entity.getOrderSymbol());
		objectDTO.setPaidTotal(entity.getPaidTotal());
		objectDTO.setPaid(entity.isPaid());
		objectDTO.setPaymentDate(entity.getPaymentDate());
		objectDTO.setReceivePerson(entity.getReceivePerson());
		objectDTO.setDeliverPerson(entity.getDeliverPerson());
		objectDTO.setSaleDate(entity.getSaleDate());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setTotal(entity.getTotal());
		objectDTO.setType(entity.getType());
		objectDTO.setWarehouseResult(entity.isWarehouseResult());
		return objectDTO;
	}

}
