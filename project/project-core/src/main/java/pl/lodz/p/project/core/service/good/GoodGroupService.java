package pl.lodz.p.project.core.service.good;

import pl.lodz.p.project.core.dto.good.GoodGroupDTO;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface GoodGroupService {

    List<GoodGroupDTO> getAll();

    GoodGroupDTO getOneById(Long id);
    
    void save(GoodGroupDTO goodGroupDTO);
    
    void delete(GoodGroupDTO goodGroupDTO);
    
}
