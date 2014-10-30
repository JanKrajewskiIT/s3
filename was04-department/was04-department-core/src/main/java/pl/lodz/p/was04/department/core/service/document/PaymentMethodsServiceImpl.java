package pl.lodz.p.was04.department.core.service.document;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.converter.document.PaymentMethodConverter;
import pl.lodz.p.was04.department.core.dao.document.PaymentMethodDao;
import pl.lodz.p.was04.department.core.domain.document.PaymentMethod;
import pl.lodz.p.was04.department.core.dto.document.PaymentMethodDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Milczu, Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PaymentMethodsServiceImpl implements PaymentMethodsService {

    @Autowired
    private PaymentMethodDao paymentMethodsDao;

    @Inject
    private PaymentMethodConverter converter;

    @RolesAllowed("documentManagement")
    @Override
    public PaymentMethodDTO getById(Long id) {
        return converter.convertEntity(paymentMethodsDao.findOne(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<PaymentMethodDTO> getPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodsDao.findAll();
        List<PaymentMethodDTO> paymentMethodDTOs = new ArrayList<>(paymentMethods.size());
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethodDTOs.add(converter.convertEntity(paymentMethod));
        }
        return paymentMethodDTOs;
    }

    @RolesAllowed("documentManagement")
    @Override
    public Long add(PaymentMethodDTO paymentMethodDTO) {
        paymentMethodsDao.save(converter.convertDTO(paymentMethodDTO));
        return paymentMethodDTO.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(PaymentMethodDTO paymentMethod) {
        paymentMethodsDao.save(converter.convertDTO(paymentMethod));
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(PaymentMethodDTO paymentMethod) {
    	paymentMethodsDao.delete(converter.convertDTO(paymentMethod));
    }

}
