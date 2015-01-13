package pl.lodz.p.project.core.dao.document.items;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.items.Department;

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
