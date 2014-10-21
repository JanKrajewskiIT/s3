package pl.lodz.p.was04.department.core.dao.goods;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.goods.Good;

/**
 *
 * @author Łukasz, milczu
 */
public interface GoodsDao extends CrudDao<Good, Long> {
    
    Page<Good> search(String searchQuery, PageRequest pageRequest);
}
