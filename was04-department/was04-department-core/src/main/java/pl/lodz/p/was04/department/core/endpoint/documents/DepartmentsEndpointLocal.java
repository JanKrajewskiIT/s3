package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.documents.DepartmentDTO;

/**
 *
 * @author janiu
 */
public interface DepartmentsEndpointLocal {
    
    DepartmentDTO getById(Long id);

    List<DepartmentDTO> getDepartments();
}
