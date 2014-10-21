package pl.lodz.p.was04.department.core.dao.goods;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.goods.Tax;

/**
 *
 * @author Łukasz
 */
@Repository
@Transactional
public class TaxesDaoImpl extends AbstractCrudDao<Tax, Long> implements TaxesDao {

    public TaxesDaoImpl() {
        super(Tax.class);
    }
    
}
