package pl.lodz.p.was04.department.core.manager.contractors;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.contractors.ContractorsGroupsDao;
import pl.lodz.p.was04.department.core.domain.contractors.ContractorGroup;

/**
 *
 * @author Janiu
 */
@Component
public class ContractorsGroupsManager implements ContractorsGroupsManagerLocal {

	@Autowired
    ContractorsGroupsDao contractorsGroupsDao;

    @RolesAllowed("contractorGroupManagement")
    @Override
    public List<ContractorGroup> getContractorsGroups() {
        return contractorsGroupsDao.findAll();
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public ContractorGroup getById(Long id) {
        return contractorsGroupsDao.findOne(id);
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public Long add(ContractorGroup clientGroup) {
        contractorsGroupsDao.save(clientGroup);
        return clientGroup.getId();
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public void edit(ContractorGroup clientGroup) {
        contractorsGroupsDao.save(clientGroup);
    }

    @RolesAllowed("contractorGroupManagement")
    @Override
    public void remove(ContractorGroup clientGroup) {
        contractorsGroupsDao.delete(clientGroup);
    }
}
