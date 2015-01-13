package pl.lodz.p.project.core.dao.account;

import pl.lodz.p.project.core.dao.base.CrudDao;
import pl.lodz.p.project.core.domain.account.Role;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;

/**
 *
 * @author Łukasz Gadomski
 */
public interface RoleDao extends CrudDao<Role, Long> {

    void flush() throws UniqueConstraintViolationException;

    Role findByName(String roleName);

}
