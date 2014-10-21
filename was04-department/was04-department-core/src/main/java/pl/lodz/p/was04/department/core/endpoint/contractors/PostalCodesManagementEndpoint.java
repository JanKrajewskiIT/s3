package pl.lodz.p.was04.department.core.endpoint.contractors;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.contractors.PostalCode;
import pl.lodz.p.was04.department.core.dto.contractors.PostalCodeDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.contractors.PostalCodesManagerLocal;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PostalCodesManagementEndpoint implements PostalCodesManagementEndpointLocal {

    @Autowired
    PostalCodesManagerLocal postalCodesManagerLocal;

    @RolesAllowed("contractorManagement")
    @Override
    public List<PostalCodeDTO> getPostalCodes() {
        return createPostalCodesList(postalCodesManagerLocal.getPostalCodes());
    }

    private List<PostalCodeDTO> createPostalCodesList(List<PostalCode> listOfEnties) {
        List<PostalCodeDTO> postalCodesList = new ArrayList<>();
        for (PostalCode listOfEntie : listOfEnties) {
            postalCodesList.add(new PostalCodeDTO(listOfEntie));
        }
        return postalCodesList;
    }

    @RolesAllowed("contractorManagement")
    @Override
    public PostalCodeDTO getPostalCode(String code) {
        return new PostalCodeDTO(postalCodesManagerLocal.getById(code));
    }
}
