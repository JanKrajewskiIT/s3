package pl.lodz.p.was04.department.core.dao.good;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.good.Good;

/**
 *
 * @author Milczu, Janiu
 */
public interface GoodDao extends CrudDao<Good, Long> {
    
    Page<Good> search(String searchQuery, PageRequest pageRequest);
}
