package pl.lodz.p.project.core.service.good;

import pl.lodz.p.project.core.dto.good.UnitDTO;

import java.util.List;

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
