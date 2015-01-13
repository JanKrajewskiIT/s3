package pl.lodz.p.project.core.dao.contractor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.contractor.ContractorGroup;

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
