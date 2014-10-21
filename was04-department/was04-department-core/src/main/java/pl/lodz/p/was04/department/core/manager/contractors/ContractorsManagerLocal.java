package pl.lodz.p.was04.department.core.manager.contractors;

import java.util.List;

import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.contractors.Contractor;

/**
 *
 * @author Janiu
 */
public interface ContractorsManagerLocal {

    public List<Contractor> getAllContractors();

    public void removeContractor(Long id);

    public void saveContractor(Contractor contractor, boolean edit);

    public Contractor findById(Long goodId);
    
    Page<Contractor> search(String searchQuery, PageRequest pageRequest);
}
