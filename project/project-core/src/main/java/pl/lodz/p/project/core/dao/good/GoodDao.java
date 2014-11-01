package pl.lodz.p.project.core.dao.good;

import pl.lodz.p.project.core.dao.CrudDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.good.Good;

/**
 *
 * @author Milczu, Janiu
 */
public interface GoodDao extends CrudDao<Good, Long> {
    
    Page<Good> search(String searchQuery, PageRequest pageRequest);
}
