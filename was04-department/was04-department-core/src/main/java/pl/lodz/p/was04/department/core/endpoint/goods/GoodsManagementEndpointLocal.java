package pl.lodz.p.was04.department.core.endpoint.goods;

import java.util.List;

import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.dto.goods.GoodDTO;

/**
 *
 * @author Łukasz, milczu
 */
public interface GoodsManagementEndpointLocal {

    List<GoodDTO> getAllGoods();

    void removeGood(GoodDTO goodId);

    Long add(GoodDTO goodDTO);
    
    void edit(GoodDTO goodDTO);
    
    GoodDTO findById(Long id);
    
    Page<GoodDTO> search(String searchQuery, PageRequest pageRequest);

}
