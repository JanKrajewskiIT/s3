package pl.lodz.p.project.core.dao.contractor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.contractor.ContractorContact;

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
