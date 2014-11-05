package pl.lodz.p.project.core.service.document;

import java.util.List;

import pl.lodz.p.project.core.dto.document.DepartmentDTO;

/**
 *
 * @author Janiu
 */
public interface DepartmentService {
    
    DepartmentDTO getOneById(Long id);

    List<DepartmentDTO> getAll();
    
}
