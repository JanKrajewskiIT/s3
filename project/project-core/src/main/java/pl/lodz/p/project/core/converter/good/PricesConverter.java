package pl.lodz.p.project.core.converter.good;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.good.Prices;
import pl.lodz.p.project.core.dto.good.PricesDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ApplicationScoped
public class PricesConverter implements Converter<Prices, PricesDTO> {

    @Override
    public Prices convertDTO(PricesDTO objectDTO) {
        Prices entity = new Prices();
        entity.setPriceAGross(objectDTO.getPriceAGross());
        entity.setPriceANet(objectDTO.getPriceANet());
        entity.setPriceBGross(objectDTO.getPriceBGross());
        entity.setPriceBNet(objectDTO.getPriceBNet());
        entity.setPriceCGross(objectDTO.getPriceCGross());
        entity.setPriceCNet(objectDTO.getPriceCNet());
        entity.setPriceMagGross(objectDTO.getPriceMagGross());
        entity.setPriceMagNet(objectDTO.getPriceMagNet());
        return entity;
    }

    @Override
    public PricesDTO convertEntity(Prices entity) {
        PricesDTO objectDTO = new PricesDTO();
        objectDTO.setPriceAGross(entity.getPriceAGross());
        objectDTO.setPriceANet(entity.getPriceANet());
        objectDTO.setPriceBGross(entity.getPriceBGross());
        objectDTO.setPriceBNet(entity.getPriceBNet());
        objectDTO.setPriceCGross(entity.getPriceCGross());
        objectDTO.setPriceCNet(entity.getPriceCNet());
        objectDTO.setPriceMagGross(entity.getPriceMagGross());
        objectDTO.setPriceMagNet(entity.getPriceMagNet());
        return objectDTO;
    }

}
