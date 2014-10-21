package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.documents.Department;
import pl.lodz.p.was04.department.core.dto.documents.DepartmentDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.documents.DepartmentsManagerLocal;

/**
 *
 * @author janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DepartmentsEndpoint implements DepartmentsEndpointLocal {

    @Autowired
    private DepartmentsManagerLocal departmentManager;

    @RolesAllowed("documentManagement")
    @Override
    public DepartmentDTO getById(Long id) {
        return new DepartmentDTO(departmentManager.getById(id));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<DepartmentDTO> getDepartments() {
        List<Department> departments = departmentManager.getDepartments();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        for (Department department : departments) {
            departmentDTOs.add(new DepartmentDTO(department));
        }
        return departmentDTOs;
    }
}
