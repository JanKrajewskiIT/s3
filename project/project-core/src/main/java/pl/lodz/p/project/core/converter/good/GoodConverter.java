package pl.lodz.p.project.core.converter.good;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.good.*;
import pl.lodz.p.project.core.dto.good.*;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class GoodConverter implements Converter<Good, GoodDTO> {

    @Inject
	private GoodGroupConverter goodGroupConverter;

    @Inject
	private TaxConverter taxConverter;

    @Inject
	private UnitConverter unitConverter;

	@Inject
	private PricesConverter pricesConverter;

	@Override
	public Good convertDTO(GoodDTO objectDTO) {
		GoodGroup goodGroup = goodGroupConverter.convertDTO(objectDTO.getGroup());
		Unit unit = unitConverter.convertDTO(objectDTO.getUnit());
		Tax tax = taxConverter.convertDTO(objectDTO.getTax());
		Prices prices = pricesConverter.convertDTO(objectDTO.getPrices());
		
		Good entity = new Good();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setDescription(objectDTO.getDescription());
		entity.setGroup(goodGroup);
		entity.setName(objectDTO.getName());
		entity.setPkwiu(objectDTO.getPkwiu());
		entity.setPrices(prices);
		entity.setSymbol(objectDTO.getSymbol());
		entity.setTax(tax);
		entity.setType(objectDTO.getType());
		entity.setUnit(unit);
		entity.setWeight(objectDTO.getWeight());
		return entity;
	}

	@Override
	public GoodDTO convertEntity(Good entity) {
		GoodGroupDTO goodGroup = goodGroupConverter.convertEntity(entity.getGroup());
		UnitDTO unit = unitConverter.convertEntity(entity.getUnit());
		TaxDTO tax = taxConverter.convertEntity(entity.getTax());
		PricesDTO prices = pricesConverter.convertEntity(entity.getPrices());

		GoodDTO objectDTO = new GoodDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setDescription(entity.getDescription());
		objectDTO.setGroup(goodGroup);
		objectDTO.setName(entity.getName());
		objectDTO.setPkwiu(entity.getPkwiu());
		objectDTO.setPrices(prices);
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setTax(tax);
		objectDTO.setType(entity.getType());
		objectDTO.setUnit(unit);
		objectDTO.setWeight(entity.getWeight());
		return objectDTO;
	}

}
