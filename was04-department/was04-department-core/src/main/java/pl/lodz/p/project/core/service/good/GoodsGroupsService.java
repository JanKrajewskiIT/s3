package pl.lodz.p.project.core.service.good;

import java.util.List;

import pl.lodz.p.project.core.dto.good.GoodGroupDTO;

/**
 *
 * @author Janiu
 */
public interface GoodsGroupsService {

    List<GoodGroupDTO> getGoodsGroups();

    GoodGroupDTO getGroup(Long id);
    
    Long add(GoodGroupDTO goodGroupDTO);
    
    void edit(GoodGroupDTO goodGroupDTO);
    
    void remove(GoodGroupDTO goodGroupDTO);
}
