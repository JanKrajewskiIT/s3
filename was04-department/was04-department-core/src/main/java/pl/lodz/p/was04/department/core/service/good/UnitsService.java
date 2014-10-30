package pl.lodz.p.was04.department.core.service.good;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.good.UnitDTO;

/**
 *
 * @author Janiu, Milczu
 */
public interface UnitsService {

    List<UnitDTO> getUnits();
    
    UnitDTO getUnit(Long unitId);
    
    Long add(UnitDTO unitDTO);
    
    void edit(UnitDTO unitDTO);
    
    void remove(UnitDTO unitDTO);
}
