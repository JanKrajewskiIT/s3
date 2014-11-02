package pl.lodz.p.project.core.service.good;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.good.UnitConverter;
import pl.lodz.p.project.core.dao.good.UnitDao;
import pl.lodz.p.project.core.domain.good.Unit;
import pl.lodz.p.project.core.dto.good.UnitDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.Transformer;

import com.google.common.collect.Lists;

/**
 *
 * @author Janiu, Milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class UnitsServiceImpl implements UnitsService {

    @Autowired
    UnitDao unitDao;

    @Autowired
    UnitConverter unitConverter;
    
    @RolesAllowed({"settings", "goodsManagement"})
    @Override
    public List<UnitDTO> getUnits() {
    	Transformer<Unit, UnitDTO> transformer = new Transformer<>(unitConverter);
    	return Lists.transform(unitDao.findAll(), transformer);
    }

    @RolesAllowed("goodsManagement")
    @Override
    public UnitDTO getUnit(Long id) {
    	Unit unit = unitDao.findOne(id);
    	return unitConverter.convertEntity(unit);
    }

    @RolesAllowed("settings")
    @Override
    public Long add(UnitDTO unitDTO) {
    	Unit unit = unitConverter.convertDTO(unitDTO);
    	unitDao.save(unit);
        return unit.getId();
    }

    @RolesAllowed("settings")
    @Override
    public void edit(UnitDTO unitDTO) {
    	Unit unit = unitConverter.convertDTO(unitDTO);
    	unitDao.save(unit);
    }

    @RolesAllowed("settings")
    @Override
    public void remove(UnitDTO unitDTO) {
    	Unit unit = unitConverter.convertDTO(unitDTO);
    	unitDao.delete(unit);
    }
    
}
