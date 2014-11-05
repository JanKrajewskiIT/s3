package pl.lodz.p.project.core.service.document;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.domain.document.Department;
import pl.lodz.p.project.core.dto.document.DepartmentDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.AbstractService;

/**
 *
 * @author Janiu
 */
@Component
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
