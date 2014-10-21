package pl.lodz.p.was04.department.core.dao.accountmanagement;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.domain.User;

/**
 *
 * @author Łukasz Gadomski
 */
public interface UserDao2 extends CrudDao<User, Long> {

    void flush();

    User findByEmail(String email);

    User findByCredentials(String userName, String password);

}
