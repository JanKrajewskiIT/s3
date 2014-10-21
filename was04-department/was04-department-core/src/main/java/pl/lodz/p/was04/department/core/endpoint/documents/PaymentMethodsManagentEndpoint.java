package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.converters.documents.PaymentMethodConverter;
import pl.lodz.p.was04.department.core.domain.documents.PaymentMethod;
import pl.lodz.p.was04.department.core.dto.documents.PaymentMethodDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.documents.PaymentMethodsManagerLocal;

/**
 *
 * @author milczu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PaymentMethodsManagentEndpoint implements PaymentMethodsManagentEndpointLocal {

	@Autowired
    private PaymentMethodsManagerLocal paymentMethodsManager;

    @Inject
    private PaymentMethodConverter converter;

    @RolesAllowed("documentManagement")
    @Override
    public PaymentMethodDTO getById(Long id) {
        return converter.convertEntity(paymentMethodsManager.getById(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<PaymentMethodDTO> getPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodsManager.getPaymentMethods();
        List<PaymentMethodDTO> paymentMethodDTOs = new ArrayList<>(paymentMethods.size());
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethodDTOs.add(converter.convertEntity(paymentMethod));
        }
        return paymentMethodDTOs;
    }

    @RolesAllowed("documentManagement")
    @Override
    public Long add(PaymentMethodDTO paymentMethod) {
        return paymentMethodsManager.add(converter.convertDTO(paymentMethod));
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(PaymentMethodDTO paymentMethod) {
        paymentMethodsManager.edit(converter.convertDTO(paymentMethod));
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(PaymentMethodDTO paymentMethod) {
        paymentMethodsManager.remove(converter.convertDTO(paymentMethod));
    }

}
