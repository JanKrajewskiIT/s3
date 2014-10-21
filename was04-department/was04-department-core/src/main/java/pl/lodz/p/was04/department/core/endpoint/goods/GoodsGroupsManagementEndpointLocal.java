package pl.lodz.p.was04.department.core.endpoint.goods;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.goods.GoodGroupDTO;

/**
 *
 * @author Łukasz
 */
public interface GoodsGroupsManagementEndpointLocal {

    List<GoodGroupDTO> getGoodsGroups();

    GoodGroupDTO getGroup(Long id);
    
    Long add(GoodGroupDTO goodGroupDTO);
    
    void edit(GoodGroupDTO goodGroupDTO);
    
    void remove(GoodGroupDTO goodGroupDTO);
}
