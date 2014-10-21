package pl.lodz.p.was04.department.core.manager.contractors;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.contractors.ContractorsContactsDao;
import pl.lodz.p.was04.department.core.domain.contractors.ContractorContact;

/**
 *
 * @author Janiu
 */
@Component
public class ContractorsContactsManager implements ContractorsContactsManagerLocal {

    @Autowired
    ContractorsContactsDao contractorContactsDao;

    @RolesAllowed("contractorManagement")
    @Override
    public List<ContractorContact> getContractorsContacts() {
        return contractorContactsDao.findAll();
    }

    @RolesAllowed("contractorManagement")
    @Override
    public ContractorContact getById(Long contractorContactId) {
        return contractorContactsDao.findOne(contractorContactId);
    }

}
