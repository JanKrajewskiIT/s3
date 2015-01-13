package pl.lodz.p.project.core.converter.document.items;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.converter.good.TaxConverter;
import pl.lodz.p.project.core.domain.document.items.DocumentPosition;
import pl.lodz.p.project.core.domain.good.Good;
import pl.lodz.p.project.core.domain.good.Tax;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.good.GoodDTO;
import pl.lodz.p.project.core.dto.good.TaxDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class DocumentPositionConverter implements Converter<DocumentPosition, DocumentPositionDTO> {

    @Inject
	TaxConverter taxConverter;

    @Inject
	GoodConverter goodConverter;
	
	@Override
	public DocumentPosition convertDTO(DocumentPositionDTO objectDTO) {
		Tax tax = taxConverter.convertDTO(objectDTO.getTax());
		Good good = goodConverter.convertDTO(objectDTO.getGood());
		
		DocumentPosition entity = new DocumentPosition();
		entity.setId(objectDTO.getId());
		entity.setPriceNet(objectDTO.getPriceNet());
		entity.setQuantity(objectDTO.getQuantity());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setTax(tax);
		entity.setGood(good);
		return entity;
	}

	@Override
	public DocumentPositionDTO convertEntity(DocumentPosition entity) {
		TaxDTO tax = taxConverter.convertEntity(entity.getTax());
		GoodDTO good = goodConverter.convertEntity(entity.getGood());
		
		DocumentPositionDTO objectDTO = new DocumentPositionDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setPriceNet(entity.getPriceNet());
		objectDTO.setQuantity(entity.getQuantity());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setTax(tax);
		objectDTO.setGood(good);
		return objectDTO;
	}

}
