package pl.lodz.p.was04.department.core.dao.contractors;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.contractors.Contractor;

/**
 *
 * @author Janiu
 */
public interface ContractorsDao extends CrudDao<Contractor, Long> {

    void removeById(Long id);
    
    void saveContractor(Contractor contractor, boolean edit);
    
    Page<Contractor> search(String searchQuery, PageRequest pageRequest);
    
}
