package pl.lodz.p.project.core.converter.document.warehouse;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;
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

		InvoiceGoodKey<ExternalInvoice> key = new InvoiceGoodKey<>();
		key.setGood(good);
		key.setInvoice(invoice);
		
		ExternalInvoiceGood entity = new ExternalInvoiceGood();
		entity.setQuantity(objectDTO.getQuantity());
		entity.setVersion(objectDTO.getVersion());	
		entity.setId(key);		
		return entity;
	}

	@Override
	public ExternalInvoiceGoodDTO convertEntity(ExternalInvoiceGood entity) {
		GoodDTO good = goodConverter.convertEntity(entity.getId().getGood());
		ExternalInvoiceDTO invoice = invoiceConverter.convertEntity(entity.getId().getInvoice());

		ExternalInvoiceGoodDTO objectDTO = new ExternalInvoiceGoodDTO();
		objectDTO.setGood(good);
		objectDTO.setInvoice(invoice);
		objectDTO.setQuantity(entity.getQuantity());
		objectDTO.setVersion(entity.getVersion());
		return objectDTO;
	}

}
