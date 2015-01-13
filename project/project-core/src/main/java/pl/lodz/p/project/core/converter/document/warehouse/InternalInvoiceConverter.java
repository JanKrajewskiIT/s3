package pl.lodz.p.project.core.converter.document.warehouse;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Named
@ApplicationScoped
public class InternalInvoiceConverter implements Converter<InternalInvoice, InternalInvoiceDTO> {

	@Inject private UserConverter userConverter;

	@Override
	public InternalInvoice convertDTO(InternalInvoiceDTO objectDTO) {
		User issuePerson = userConverter.convertDTO(objectDTO.getIssuePerson());

		InternalInvoice entity = new InternalInvoice();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setType(objectDTO.getType());
		entity.setTotal(objectDTO.getTotal());
		entity.setDocumentDate(objectDTO.getDocumentDate());
		entity.setDeliverPerson(objectDTO.getDeliverPerson());
		entity.setIssuePerson(issuePerson);
		entity.setReceivePerson(objectDTO.getReceivePerson());
		entity.setAnnotation(objectDTO.getAnnotation());
		return entity;
	}

	@Override
	public InternalInvoiceDTO convertEntity(InternalInvoice entity) {
		UserDTO issuePerson = userConverter.convertEntity(entity.getIssuePerson());

		InternalInvoiceDTO objectDTO = new InternalInvoiceDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setType(entity.getType());
		objectDTO.setTotal(entity.getTotal());
		objectDTO.setDocumentDate(entity.getDocumentDate());
		objectDTO.setDeliverPerson(entity.getDeliverPerson());
		objectDTO.setIssuePerson(issuePerson);
		objectDTO.setReceivePerson(entity.getReceivePerson());
		objectDTO.setAnnotation(entity.getAnnotation());
		return objectDTO;
	}

}
