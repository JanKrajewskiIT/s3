package pl.lodz.p.was04.department.core.dao.documents;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.documents.Department;

/**
 *
 * @author janiu
 */
@Repository
@Transactional
public class DepartmentsDaoImpl extends AbstractCrudDao<Department, Long> implements DepartmentsDao {
    
    public DepartmentsDaoImpl() {
        super(Department.class);
    }
    
}
