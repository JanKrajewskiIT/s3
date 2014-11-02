package pl.lodz.p.project.core.service.contractor;

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
import pl.lodz.p.project.core.service.Transformer;

import com.google.common.collect.Lists;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class PostalCodesServiceImpl implements PostalCodesService {

    @Autowired
    PostalCodeDao postalCodeDao;
    
    @Autowired
    PostalCodeConverter postalCodeConverter;

    @RolesAllowed("contractorManagement")
    @Override
    public List<PostalCodeDTO> getPostalCodes() {
    	Transformer<PostalCode, PostalCodeDTO> transformer = new Transformer<>(postalCodeConverter);
    	return Lists.transform(postalCodeDao.findAll(), transformer);
    }

    @RolesAllowed("contractorManagement")
    @Override
    public PostalCodeDTO getPostalCode(Long id) {
    	PostalCode postalCode = postalCodeDao.findOne(id);
        return postalCodeConverter.convertEntity(postalCode);
    }
    
}
