package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.documents.PaymentMethodsDao;
import pl.lodz.p.was04.department.core.domain.documents.PaymentMethod;

/**
 *
 * @author milczu
 */
@Component
public class PaymentMethodsManager implements PaymentMethodsManagerLocal {

    @Autowired
    private PaymentMethodsDao paymentMethodsDao;

    @RolesAllowed("documentManagement")
    @Override
    public PaymentMethod getById(Long id) {
        return paymentMethodsDao.findOne(id);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethodsDao.findAll();
    }

    @RolesAllowed("documentManagement")
    @Override
    public Long add(PaymentMethod paymentMethod) {
        paymentMethodsDao.save(paymentMethod);
        return paymentMethod.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(PaymentMethod paymentMethod) {
        paymentMethodsDao.save(paymentMethod);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(PaymentMethod paymentMethod) {
        paymentMethodsDao.delete(paymentMethod);
    }

}
