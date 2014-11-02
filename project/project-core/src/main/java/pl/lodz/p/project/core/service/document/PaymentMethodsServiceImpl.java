package pl.lodz.p.project.core.service.document;

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
import pl.lodz.p.project.core.service.Transformer;

import com.google.common.collect.Lists;

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
    private PaymentMethodConverter paymentMethodConverter;

    @RolesAllowed("documentManagement")
    @Override
    public PaymentMethodDTO getById(Long id) {
        return paymentMethodConverter.convertEntity(paymentMethodDao.findOne(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<PaymentMethodDTO> getPaymentMethods() {
    	Transformer<PaymentMethod, PaymentMethodDTO> transformer = new Transformer<>(paymentMethodConverter);
    	return Lists.transform(paymentMethodDao.findAll(), transformer);
    }

    @RolesAllowed("documentManagement")
    @Override
    public Long add(PaymentMethodDTO paymentMethodDTO) {
        paymentMethodDao.save(paymentMethodConverter.convertDTO(paymentMethodDTO));
        return paymentMethodDTO.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(PaymentMethodDTO paymentMethod) {
        paymentMethodDao.save(paymentMethodConverter.convertDTO(paymentMethod));
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(PaymentMethodDTO paymentMethod) {
    	paymentMethodDao.delete(paymentMethodConverter.convertDTO(paymentMethod));
    }

}
