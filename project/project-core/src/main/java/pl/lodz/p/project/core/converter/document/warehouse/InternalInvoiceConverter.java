package pl.lodz.p.project.core.converter.document.warehouse;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Named
@ApplicationScoped
public class InternalInvoiceConverter implements Converter<InternalInvoice, InternalInvoiceDTO> {

	@Override
	public InternalInvoice convertDTO(InternalInvoiceDTO objectDTO) {
		InternalInvoice entity = new InternalInvoice();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setTotal(objectDTO.getTotal());
		entity.setDocumentDate(objectDTO.getDocumentDate());
		entity.setDeliverPerson(objectDTO.getDeliverPerson());
		entity.setIssuePerson(objectDTO.getIssuePerson());
		entity.setReceivePerson(objectDTO.getReceivePerson());
		return entity;
	}

	@Override
	public InternalInvoiceDTO convertEntity(InternalInvoice entity) {
		InternalInvoiceDTO objectDTO = new InternalInvoiceDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setTotal(entity.getTotal());
		objectDTO.setDocumentDate(entity.getDocumentDate());
		objectDTO.setDeliverPerson(entity.getDeliverPerson());
		objectDTO.setIssuePerson(entity.getIssuePerson());
		objectDTO.setReceivePerson(entity.getReceivePerson());
		return objectDTO;
	}

}
