package pl.lodz.p.project.core.service.document.items;

import java.util.List;

import pl.lodz.p.project.core.dto.document.items.DepartmentDTO;

/**
 *
 * @author Janiu
 */
public interface DepartmentService {
    
    DepartmentDTO getOneById(Long id);

    List<DepartmentDTO> getAll();
    
}
