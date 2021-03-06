package pl.lodz.p.project.core.dao.contractor;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.contractor.Contractor;

/**
 *
 * @author Janiu
 */
public interface ContractorDao extends CrudDao<Contractor, Long> {
        
    Page<Contractor> search(String searchQuery, PageRequest pageRequest);
    
}
