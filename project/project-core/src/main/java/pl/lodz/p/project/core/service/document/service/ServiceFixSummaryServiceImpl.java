package pl.lodz.p.project.core.service.document.service;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.dao.pagingandsearching.Page;
import pl.lodz.p.project.core.dao.pagingandsearching.PageRequest;
import pl.lodz.p.project.core.domain.document.service.ServiceFixSummary;
import pl.lodz.p.project.core.dto.document.service.ServiceFixSummaryDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.interceptor.Interceptors;
import java.util.List;

/**
 * Created by milczu on 20.01.15.
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class ServiceFixSummaryServiceImpl /*extends AbstractService<ServiceFixSummary, ServiceFixSummaryDTO>*/ implements ServiceFixSummaryService {

    // TODO

    @Override
    public long count() {
        return 0;
    }

    @Override
    public ServiceFixSummary save(ServiceFixSummaryDTO objectDTO) {
        return null;
    }

    @Override
    public void save(List<ServiceFixSummaryDTO> objectList) {

    }

    @Override
    public ServiceFixSummaryDTO getOneById(Long id) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<ServiceFixSummaryDTO> getAll() {
        return null;
    }

    @Override
    public List<ServiceFixSummaryDTO> getAll(List<Long> idList) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(ServiceFixSummaryDTO objectDTO) {

    }

    @Override
    public void delete(List<ServiceFixSummaryDTO> objectList) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Page<ServiceFixSummaryDTO> search(String searchQuery, PageRequest pageRequest) {
        return null;
    }
}
