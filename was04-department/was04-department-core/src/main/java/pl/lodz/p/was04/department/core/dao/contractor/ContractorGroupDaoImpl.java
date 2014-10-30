package pl.lodz.p.was04.department.core.dao.contractor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.contractor.ContractorGroup;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class ContractorGroupDaoImpl extends AbstractCrudDao<ContractorGroup, Long> implements ContractorGroupDao {
    
    public ContractorGroupDaoImpl() {
        super(ContractorGroup.class);
    }
    
}
