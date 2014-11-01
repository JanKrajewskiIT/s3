package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.DepartmentDTO;

/**
 *
 * @author Janiu
 */
public interface DepartmentsService {
    
    DepartmentDTO getById(Long id);

    List<DepartmentDTO> getDepartments();
}
