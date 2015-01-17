package pl.lodz.p.project.core.converter.document.warehouse;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.ExternalInvoiceGood;
import pl.lodz.p.project.core.domain.good.Good;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
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
public class ExternalInvoiceGoodConverter implements Converter<ExternalInvoiceGood, ExternalInvoiceGoodDTO> {

	@Inject
	private GoodConverter goodConverter;
	
	@Inject
	private ExternalInvoiceConverter invoiceConverter;
	
	@Override
	public ExternalInvoiceGood convertDTO(ExternalInvoiceGoodDTO objectDTO) {
		Good good = goodConverter.convertDTO(objectDTO.getGood());
		ExternalInvoice invoice = invoiceConverter.convertDTO(objectDTO.getInvoice());

		ExternalInvoiceGood entity = new ExternalInvoiceGood();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setQuantity(objectDTO.getQuantity());
		entity.setGood(good);
		entity.setInvoice(invoice);
		return entity;
	}

	@Override
	public ExternalInvoiceGoodDTO convertEntity(ExternalInvoiceGood entity) {
		GoodDTO good = goodConverter.convertEntity(entity.getGood());
		ExternalInvoiceDTO invoice = new ExternalInvoiceDTO();
		invoice.setId(entity.getInvoice().getId());

		ExternalInvoiceGoodDTO objectDTO = new ExternalInvoiceGoodDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setQuantity(entity.getQuantity());
		objectDTO.setGood(good);
		objectDTO.setInvoice(invoice);
		return objectDTO;
	}

}
