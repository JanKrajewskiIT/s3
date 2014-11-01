package pl.lodz.p.project.core.service.contractor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.contractor.PostalCodeConverter;
import pl.lodz.p.project.core.dao.contractor.PostalCodeDao;
import pl.lodz.p.project.core.domain.contractor.PostalCode;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PostalCodesServiceImpl implements PostalCodesService {

    @Autowired
    PostalCodeDao postalCodesDao;
    
    @Autowired
    PostalCodeConverter postalCodeConverter;

    @RolesAllowed("contractorManagement")
    @Override
    public List<PostalCodeDTO> getPostalCodes() {
        List<PostalCodeDTO> postalCodeList = new ArrayList<>();
        for (PostalCode postalCode : postalCodesDao.findAll()) {
        	PostalCodeDTO postalCodeDTO = postalCodeConverter.convertEntity(postalCode);
            postalCodeList.add(postalCodeDTO);
        }
        return postalCodeList;
    }

    @RolesAllowed("contractorManagement")
    @Override
    public PostalCodeDTO getPostalCode(Long id) {
    	PostalCode postalCode = postalCodesDao.findOne(id);
        return postalCodeConverter.convertEntity(postalCode);
    }
    
}
