package pl.lodz.p.was04.department.core.dao.contractors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.contractors.ContractorContact;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class ContractorsContactsDaoImpl extends AbstractCrudDao<ContractorContact, Long> implements ContractorsContactsDao {

    public ContractorsContactsDaoImpl() {
        super(ContractorContact.class);
    }
    
}
