package pl.lodz.p.was04.department.core.service.document;

import java.util.List;

import pl.lodz.p.was04.department.core.dto.document.DepartmentDTO;

/**
 *
 * @author Janiu
 */
public interface DepartmentsService {
    
    DepartmentDTO getById(Long id);

    List<DepartmentDTO> getDepartments();
}
