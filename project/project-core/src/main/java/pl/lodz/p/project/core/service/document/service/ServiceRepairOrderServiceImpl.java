package pl.lodz.p.project.core.service.document.service;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.domain.document.service.ServiceRepairOrder;
import pl.lodz.p.project.core.dto.document.service.ServiceRepairOrderDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.interceptor.Interceptors;

@Service
@Interceptors({TrackerInterceptor.class})
public class ServiceRepairOrderServiceImpl extends AbstractService<ServiceRepairOrder, ServiceRepairOrderDTO> implements ServiceRepairOrderService {

}
