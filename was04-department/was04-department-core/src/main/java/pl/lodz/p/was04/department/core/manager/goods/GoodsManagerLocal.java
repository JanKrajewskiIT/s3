package pl.lodz.p.was04.department.core.manager.goods;

import java.util.List;

import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.goods.Good;

/**
 *
 * @author Łukasz, milczu
 */
public interface GoodsManagerLocal {

    List<Good> getAllGoods();

    void removeGood(Good goodId);

    Long add(Good good);
    
    void edit(Good good);
    
    Good findById(Long goodId);
    
    Page<Good> search(String searchQuery, PageRequest pageRequest);
}
