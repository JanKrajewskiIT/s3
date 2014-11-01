package pl.lodz.p.project.core.dao.document;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.PaymentMethod;

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
