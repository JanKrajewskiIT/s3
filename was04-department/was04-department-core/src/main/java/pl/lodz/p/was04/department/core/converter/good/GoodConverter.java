package pl.lodz.p.was04.department.core.converter.good;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.domain.good.Good;
import pl.lodz.p.was04.department.core.domain.good.GoodGroup;
import pl.lodz.p.was04.department.core.domain.good.Tax;
import pl.lodz.p.was04.department.core.domain.good.Unit;
import pl.lodz.p.was04.department.core.dto.good.GoodDTO;
import pl.lodz.p.was04.department.core.dto.good.GoodGroupDTO;
import pl.lodz.p.was04.department.core.dto.good.TaxDTO;
import pl.lodz.p.was04.department.core.dto.good.UnitDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class GoodConverter implements Converter<Good, GoodDTO> {

    @Inject
	GoodGroupConverter goodGroupConverter;

    @Inject
	TaxConverter taxConverter;

    @Inject
	UnitConverter unitConverter;
	
	@Override
	public Good convertDTO(GoodDTO objectDTO) {
		GoodGroup goodGroup = goodGroupConverter.convertDTO(objectDTO.getGroup());
		Unit unit = unitConverter.convertDTO(objectDTO.getUnit());
		Tax tax = taxConverter.convertDTO(objectDTO.getTax());
		
		Good entity = new Good();
		entity.setId(objectDTO.getId());
		entity.setDescription(objectDTO.getDescription());
		entity.setGroup(goodGroup);
		entity.setName(objectDTO.getName());
		entity.setPkwiu(objectDTO.getPkwiu());
		entity.setPriceAGross(objectDTO.getPriceAGross());
		entity.setPriceANet(objectDTO.getPriceANet());
		entity.setPriceBGross(objectDTO.getPriceBGross());
		entity.setPriceBNet(objectDTO.getPriceBNet());
		entity.setPriceCGross(objectDTO.getPriceCGross());
		entity.setPriceCNet(objectDTO.getPriceCNet());
		entity.setPriceMagGross(objectDTO.getPriceMagGross());
		entity.setPriceMagNet(objectDTO.getPriceMagNet());
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

		GoodDTO objectDTO = new GoodDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setDescription(entity.getDescription());
		objectDTO.setGroup(goodGroup);
		objectDTO.setName(entity.getName());
		objectDTO.setPkwiu(entity.getPkwiu());
		objectDTO.setPriceAGross(entity.getPriceAGross());
		objectDTO.setPriceANet(entity.getPriceANet());
		objectDTO.setPriceBGross(entity.getPriceBGross());
		objectDTO.setPriceBNet(entity.getPriceBNet());
		objectDTO.setPriceCGross(entity.getPriceCGross());
		objectDTO.setPriceCNet(entity.getPriceCNet());
		objectDTO.setPriceMagGross(entity.getPriceMagGross());
		objectDTO.setPriceMagNet(entity.getPriceMagNet());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setTax(tax);
		objectDTO.setType(entity.getType());
		objectDTO.setUnit(unit);
		objectDTO.setWeight(entity.getWeight());
		return objectDTO;
	}

}
