package pl.lodz.p.was04.department.core.service.document;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.converter.document.DepartmentConverter;
import pl.lodz.p.was04.department.core.dao.document.DepartmentDao;
import pl.lodz.p.was04.department.core.domain.document.Department;
import pl.lodz.p.was04.department.core.dto.document.DepartmentDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;

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
        List<DepartmentDTO> departmentList = new ArrayList<>();
        for (Department department : departmentDao.findAll()) {
        	DepartmentDTO departmentDTO = departmentConverter.convertEntity(department);
        	departmentList.add(departmentDTO);
        }
        return departmentList;
    }
}
