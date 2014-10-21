package pl.lodz.p.was04.department.core.dao.contractors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.contractors.ContractorGroup;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class ContractorsGroupsDaoImpl extends AbstractCrudDao<ContractorGroup, Long> implements ContractorsGroupsDao {
    
    public ContractorsGroupsDaoImpl() {
        super(ContractorGroup.class);
    }
    
}
