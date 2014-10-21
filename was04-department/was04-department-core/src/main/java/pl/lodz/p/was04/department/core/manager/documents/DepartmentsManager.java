package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.documents.DepartmentsDao;
import pl.lodz.p.was04.department.core.domain.documents.Department;

/**
 *
 * @author janiu
 */
@Component
public class DepartmentsManager implements DepartmentsManagerLocal {

	@Autowired
    private DepartmentsDao departmentDao;

    @RolesAllowed("documentManagement")
    @Override
    public Department getById(Long id) {
        return departmentDao.findOne(id);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<Department> getDepartments() {
        return departmentDao.findAll();
    }

    @RolesAllowed("documentManagement")
    @Override
    public Long add(Department department) {
        departmentDao.save(department);
        return department.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(Department department) {
        departmentDao.save(department);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(Department department) {
        departmentDao.delete(department);
    }

}
