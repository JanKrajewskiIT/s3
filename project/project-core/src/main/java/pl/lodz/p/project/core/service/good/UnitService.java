package pl.lodz.p.project.core.service.good;

import java.util.List;

import pl.lodz.p.project.core.dto.good.UnitDTO;

/**
 *
 * @author Janiu, Milczu
 */
public interface UnitService {

    List<UnitDTO> getAll();
    
    UnitDTO getOneById(Long unitId);
        
    void save(UnitDTO unitDTO);
    
    void delete(UnitDTO unitDTO);
    
}
