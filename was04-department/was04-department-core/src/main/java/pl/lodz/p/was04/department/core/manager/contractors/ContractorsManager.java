package pl.lodz.p.was04.department.core.manager.contractors;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.contractors.ContractorsDao;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.Page;
import pl.lodz.p.was04.department.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.was04.department.core.domain.contractors.Contractor;

/**
 *
 * @author Janiu
 */
@Component
public class ContractorsManager implements ContractorsManagerLocal {

    @Autowired
    private ContractorsDao contractorsDao;

    @RolesAllowed("contractorManagement")
    @Override
    public List<Contractor> getAllContractors() {
        return contractorsDao.findAll();
    }

    @RolesAllowed("contractorManagement")
    @Override
    public void removeContractor(Long id) {
        contractorsDao.delete(id);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public void saveContractor(Contractor contractor, boolean edit) {
        contractorsDao.saveContractor(contractor, edit);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public Contractor findById(Long goodId) {
        return contractorsDao.findOne(goodId);
    }
    
    @Override
    public Page<Contractor> search(String searchQuery, PageRequest pageRequest) {
        return contractorsDao.search(searchQuery, pageRequest);
    }

}
