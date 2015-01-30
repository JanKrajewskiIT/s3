package pl.lodz.p.project.core.service.document.service;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.domain.document.service.ServiceFixSummary;
import pl.lodz.p.project.core.dto.document.service.ServiceFixSummaryDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.interceptor.Interceptors;

/**
 * Created by milczu on 20.01.15.
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class ServiceFixSummaryServiceImpl extends AbstractBaseService<ServiceFixSummary, ServiceFixSummaryDTO> implements ServiceFixSummaryService {

}
