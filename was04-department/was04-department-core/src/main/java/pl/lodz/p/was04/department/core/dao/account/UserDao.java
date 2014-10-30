package pl.lodz.p.was04.department.core.dao.account;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.domain.account.User;

/**
*
* @author Łukasz Gadomski, Milczu
*/
public interface UserDao extends CrudDao<User, Long> {

	User findByEmail(String email);

    User findByCredentials(String userName, String password);

    void flush();
    
}
