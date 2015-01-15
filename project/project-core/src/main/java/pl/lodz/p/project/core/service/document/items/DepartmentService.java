package pl.lodz.p.project.core.service.document.items;

import pl.lodz.p.project.core.dto.document.items.DepartmentDTO;

import java.util.List;

/**
 *
 * @author Janiu
 */
public interface DepartmentService {
    
    DepartmentDTO getOneById(Long id);

    List<DepartmentDTO> getAll();
    
}
