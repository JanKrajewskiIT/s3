package pl.lodz.p.project.core.service.document;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.document.DepartmentConverter;
import pl.lodz.p.project.core.dao.document.DepartmentDao;
import pl.lodz.p.project.core.domain.document.Department;
import pl.lodz.p.project.core.dto.document.DepartmentDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.Transformer;

import com.google.common.collect.Lists;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DepartmentsServiceImpl implements DepartmentsService {

	@Autowired
    private DepartmentDao departmentDao;
	
	@Autowired
	private DepartmentConverter departmentConverter;

    @RolesAllowed("documentManagement")
    @Override
    public DepartmentDTO getById(Long id) {
    	Department department = departmentDao.findOne(id);
        return departmentConverter.convertEntity(department);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<DepartmentDTO> getDepartments() {
    	Transformer<Department, DepartmentDTO> transformer = new Transformer<>(departmentConverter);
    	return Lists.transform(departmentDao.findAll(), transformer);
    }
    
}
