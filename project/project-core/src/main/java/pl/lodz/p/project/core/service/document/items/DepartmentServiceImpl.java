package pl.lodz.p.project.core.service.document.items;

import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.domain.document.items.Department;
import pl.lodz.p.project.core.dto.document.items.DepartmentDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.base.AbstractService;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;
import java.util.List;

/**
 * @author Janiu
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class DepartmentServiceImpl extends AbstractService<Department, DepartmentDTO> implements DepartmentService {

    private final static String ACCESS_LEVEL = "documentManagement";

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public DepartmentDTO getOneById(Long id) {
        return super.getOneById(id);
    }

    @RolesAllowed(ACCESS_LEVEL)
    @Override
    public List<DepartmentDTO> getAll() {
        return super.getAll();
    }

}
