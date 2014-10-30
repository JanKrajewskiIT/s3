package pl.lodz.p.was04.department.core.dao.document;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.document.Department;

/**
*
* @author Janiu
*/
@Repository
@Transactional
public class DepartmentDaoImpl extends AbstractCrudDao<Department, Long> implements DepartmentDao {
    
    public DepartmentDaoImpl() {
        super(Department.class);
    }
    
}
