package pl.lodz.p.project.core.converter.document.warehouse;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * 
 * @author Jan Krajewski
 *
 */
@Named
@ApplicationScoped
public class InternalInvoiceConverter implements Converter<InternalInvoice, InternalInvoiceDTO> {

	@Inject private UserConverter userConverter;

	@Inject
	private InternalInvoiceGoodConverter invoiceGoodConverter;

	@Override
	public InternalInvoice convertDTO(InternalInvoiceDTO objectDTO) {
		User issuePerson = userConverter.convertDTO(objectDTO.getIssuePerson());
		List<InternalInvoiceGood> invoiceGoodList = Lists.transform(objectDTO.getGoodList(), new InvoiceGoodDTOConverter());

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
		entity.setGoodList(invoiceGoodList);
		return entity;
	}

	@Override
	public InternalInvoiceDTO convertEntity(InternalInvoice entity) {
		UserDTO issuePerson = userConverter.convertEntity(entity.getIssuePerson());
		List<InternalInvoiceGoodDTO> invoiceGoodList = Lists.transform(entity.getGoodList(), new InvoiceGoodConverter());

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
		objectDTO.setGoodList(invoiceGoodList);
		return objectDTO;
	}

	private class InvoiceGoodConverter implements Function<InternalInvoiceGood, InternalInvoiceGoodDTO> {
		@Override
		public InternalInvoiceGoodDTO apply(InternalInvoiceGood input) {
			return invoiceGoodConverter.convertEntity(input);
		}
	}

	private class InvoiceGoodDTOConverter implements Function<InternalInvoiceGoodDTO, InternalInvoiceGood> {
		@Override
		public InternalInvoiceGood apply(InternalInvoiceGoodDTO input) {
			return invoiceGoodConverter.convertDTO(input);
		}
	}
}
