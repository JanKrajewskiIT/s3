package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.documents.Department;

/**
 *
 * @author janiu
 */
public interface DepartmentsManagerLocal {
    
    Department getById(Long id);

    List<Department> getDepartments();
    
    Long add(Department department);
    
    void edit(Department department);
    
    void remove(Department department);
}
