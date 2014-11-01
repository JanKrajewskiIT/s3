package pl.lodz.p.project.core.service.good;

import java.util.List;

import pl.lodz.p.project.core.dto.good.UnitDTO;

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
