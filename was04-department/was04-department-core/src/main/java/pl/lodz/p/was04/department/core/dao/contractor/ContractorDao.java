package pl.lodz.p.was04.department.core.dao.contractor;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.contractor.Contractor;

/**
 *
 * @author Janiu
 */
public interface ContractorDao extends CrudDao<Contractor, Long> {

    void remove(Long id);
    
    void save(Contractor contractor, boolean edit);
    
    Page<Contractor> search(String searchQuery, PageRequest pageRequest);
    
}
