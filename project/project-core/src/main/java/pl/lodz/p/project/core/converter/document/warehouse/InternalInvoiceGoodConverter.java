package pl.lodz.p.project.core.converter.document.warehouse;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.domain.good.Good;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jan Krajewski
 *
 */
@Named
@ApplicationScoped
public class InternalInvoiceGoodConverter implements Converter<InternalInvoiceGood, InternalInvoiceGoodDTO> {

	@Inject
	private GoodConverter goodConverter;
	
	@Inject
	private InternalInvoiceConverter invoiceConverter;
	
	@Override
	public InternalInvoiceGood convertDTO(InternalInvoiceGoodDTO objectDTO) {
		Good good = goodConverter.convertDTO(objectDTO.getGood());
		InternalInvoice invoice = invoiceConverter.convertDTO(objectDTO.getInvoice());

		InternalInvoiceGood entity = new InternalInvoiceGood();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setQuantity(objectDTO.getQuantity());
		entity.setGood(good);
		entity.setInvoice(invoice);
		return entity;
	}

	@Override
	public InternalInvoiceGoodDTO convertEntity(InternalInvoiceGood entity) {
		GoodDTO good = goodConverter.convertEntity(entity.getGood());
		InternalInvoiceDTO invoice = new InternalInvoiceDTO();
		invoice.setId(entity.getInvoice().getId());
		
		InternalInvoiceGoodDTO objectDTO = new InternalInvoiceGoodDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setQuantity(entity.getQuantity());
		objectDTO.setGood(good);
		objectDTO.setInvoice(invoice);
		return objectDTO;
	}

}
