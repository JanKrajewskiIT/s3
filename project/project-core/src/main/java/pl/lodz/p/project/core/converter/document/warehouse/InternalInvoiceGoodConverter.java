package pl.lodz.p.project.core.converter.document.warehouse;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoice;
import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;
import pl.lodz.p.project.core.domain.good.Good;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.InternalInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;

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

		InvoiceGoodKey<InternalInvoice> key = new InvoiceGoodKey<>();
		key.setGood(good);
		key.setInvoice(invoice);
		
		InternalInvoiceGood entity = new InternalInvoiceGood();
		entity.setQuantity(objectDTO.getQuantity());
		entity.setVersion(objectDTO.getVersion());	
		entity.setId(key);		
		return entity;
	}

	@Override
	public InternalInvoiceGoodDTO convertEntity(InternalInvoiceGood entity) {
		GoodDTO good = goodConverter.convertEntity(entity.getId().getGood());
		InternalInvoiceDTO invoice = invoiceConverter.convertEntity(entity.getId().getInvoice());
		
		InternalInvoiceGoodDTO objectDTO = new InternalInvoiceGoodDTO();
		objectDTO.setGood(good);
		objectDTO.setInvoice(invoice);
		objectDTO.setQuantity(entity.getQuantity());
		objectDTO.setVersion(entity.getVersion());
		return objectDTO;
	}

}
