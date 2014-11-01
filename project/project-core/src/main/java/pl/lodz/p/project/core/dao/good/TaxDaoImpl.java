package pl.lodz.p.project.core.dao.good;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.AbstractCrudDao;
import pl.lodz.p.project.core.domain.good.Tax;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class TaxDaoImpl extends AbstractCrudDao<Tax, Long> implements TaxDao {

    public TaxDaoImpl() {
        super(Tax.class);
    }
    
}
