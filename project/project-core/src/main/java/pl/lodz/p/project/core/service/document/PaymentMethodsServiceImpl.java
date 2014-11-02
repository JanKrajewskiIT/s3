package pl.lodz.p.project.core.service.document;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.document.PaymentMethodConverter;
import pl.lodz.p.project.core.dao.document.PaymentMethodDao;
import pl.lodz.p.project.core.domain.document.PaymentMethod;
import pl.lodz.p.project.core.dto.document.PaymentMethodDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Milczu, Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PaymentMethodsServiceImpl implements PaymentMethodsService {

    @Autowired
    private PaymentMethodDao paymentMethodDao;

    @Inject
    private PaymentMethodConverter converter;

    @RolesAllowed("documentManagement")
    @Override
    public PaymentMethodDTO getById(Long id) {
        return converter.convertEntity(paymentMethodDao.findOne(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<PaymentMethodDTO> getPaymentMethods() {
        List<PaymentMethod> paymentMethodList = paymentMethodDao.findAll();
        List<PaymentMethodDTO> paymentMethodDTOs = new ArrayList<>(paymentMethodList.size());
        for (PaymentMethod paymentMethod : paymentMethodList) {
            paymentMethodDTOs.add(converter.convertEntity(paymentMethod));
        }
        return paymentMethodDTOs;
    }

    @RolesAllowed("documentManagement")
    @Override
    public Long add(PaymentMethodDTO paymentMethodDTO) {
        paymentMethodDao.save(converter.convertDTO(paymentMethodDTO));
        return paymentMethodDTO.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(PaymentMethodDTO paymentMethod) {
        paymentMethodDao.save(converter.convertDTO(paymentMethod));
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(PaymentMethodDTO paymentMethod) {
    	paymentMethodDao.delete(converter.convertDTO(paymentMethod));
    }

}
