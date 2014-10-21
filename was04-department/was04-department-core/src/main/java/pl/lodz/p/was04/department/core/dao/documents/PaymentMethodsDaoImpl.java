package pl.lodz.p.was04.department.core.dao.documents;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.documents.PaymentMethod;

/**
 *
 * @author milczu
 */
@Repository
@Transactional
public class PaymentMethodsDaoImpl extends AbstractCrudDao<PaymentMethod, Long> implements PaymentMethodsDao {
    
    public PaymentMethodsDaoImpl() {
        super(PaymentMethod.class);
    }

}
