package pl.lodz.p.was04.department.core.dao.contractor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.contractor.ContractorContact;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class ContractorContactDaoImpl extends AbstractCrudDao<ContractorContact, Long> implements ContractorContactDao {

    public ContractorContactDaoImpl() {
        super(ContractorContact.class);
    }
    
}
