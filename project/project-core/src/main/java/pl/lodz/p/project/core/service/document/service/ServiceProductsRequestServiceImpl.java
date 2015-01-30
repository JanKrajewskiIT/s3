package pl.lodz.p.project.core.service.document.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequestGood;
import pl.lodz.p.project.core.dto.document.service.ServiceProductsRequestDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.interceptor.Interceptors;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by milczu on 29.01.15.
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class ServiceProductsRequestServiceImpl extends AbstractBaseService<ServiceProductsRequest, ServiceProductsRequestDTO> implements ServiceProductsRequestService {

}
