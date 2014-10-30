package pl.lodz.p.was04.department.core.dao.account;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.domain.account.Role;
import pl.lodz.p.was04.department.core.exception.UniqueConstraintViolationException;

/**
 *
 * @author Łukasz Gadomski
 */
public interface RoleDao extends CrudDao<Role, Long> {

    void flush() throws UniqueConstraintViolationException;

    Role findByName(String roleName);

}
