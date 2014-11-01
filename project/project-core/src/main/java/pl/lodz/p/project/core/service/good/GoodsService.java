package pl.lodz.p.project.core.service.good;

import java.util.List;

import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.dto.good.GoodDTO;

/**
 *
 * @author Janiu, Milczu
 */
public interface GoodsService {

    List<GoodDTO> getAllGoods();

    void removeGood(GoodDTO goodId);

    Long add(GoodDTO goodDTO);
    
    void edit(GoodDTO goodDTO);
    
    GoodDTO findById(Long id);
    
    Page<GoodDTO> search(String searchQuery, PageRequest pageRequest);

}
