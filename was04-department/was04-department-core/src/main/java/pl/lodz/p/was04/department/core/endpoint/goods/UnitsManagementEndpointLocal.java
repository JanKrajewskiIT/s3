package pl.lodz.p.was04.department.core.endpoint.goods;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.goods.UnitDTO;

/**
 *
 * @author Łukasz, milczu
 */
public interface UnitsManagementEndpointLocal {

    List<UnitDTO> getUnits();
    
    UnitDTO getUnit(Long unitId);
    
    Long add(UnitDTO unitDTO);
    
    void edit(UnitDTO unitDTO);
    
    void remove(UnitDTO unitDTO);
}
