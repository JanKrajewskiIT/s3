package pl.lodz.p.project.core.converter.document.warehouse;

import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.domain.document.warehouse.InvoiceGoodKey;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

/**
 * @author Jan Krajewski
 */
@Named
@ApplicationScoped
public class InternalInvoiceConverter implements Converter<InternalInvoice, InternalInvoiceDTO> {

	@Inject private UserConverter userConverter;

	@Inject
	private GoodConverter goodConverter;

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
		entity.setInvoiceGoodList(new ArrayList<InternalInvoiceGood>());

		for(InternalInvoiceGoodDTO invoiceGoodDTO : objectDTO.getGoodList()) {
			InternalInvoiceGood invoiceGood = new InternalInvoiceGood();
			invoiceGood.setId(new InvoiceGoodKey<InternalInvoice>());
			invoiceGood.getId().setGood(goodConverter.convertDTO(invoiceGoodDTO.getGood()));
			invoiceGood.getId().setInvoice(entity);
			invoiceGood.setQuantity(invoiceGoodDTO.getQuantity());
			entity.getInvoiceGoodList().add(invoiceGood);
		}
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
		objectDTO.setGoodList(new ArrayList<InternalInvoiceGoodDTO>());

		for(InternalInvoiceGood invoiceGood : entity.getInvoiceGoodList()) {
			InternalInvoiceGoodDTO invoiceGoodDTO = new InternalInvoiceGoodDTO();
			invoiceGoodDTO.setGood(goodConverter.convertEntity(invoiceGood.getId().getGood()));
			invoiceGoodDTO.setQuantity(invoiceGood.getQuantity());
			invoiceGoodDTO.setInvoice(objectDTO);
			objectDTO.getGoodList().add(invoiceGoodDTO);
		}
		return objectDTO;
	}

}
