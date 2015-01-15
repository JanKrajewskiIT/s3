package pl.lodz.p.project.core.dao.document.items;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.items.PaymentMethod;

/**
 *
 * @author Milczu
 */
@Repository
@Transactional
public class PaymentMethodDaoImpl extends AbstractCrudDao<PaymentMethod, Long> implements PaymentMethodDao {
    
    public PaymentMethodDaoImpl() {
        super(PaymentMethod.class);
    }

}
