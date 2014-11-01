package pl.lodz.p.project.core.dao.account;

import pl.lodz.p.project.core.dao.CrudDao;
import pl.lodz.p.project.core.domain.account.User;

/**
*
* @author Łukasz Gadomski, Milczu
*/
public interface UserDao extends CrudDao<User, Long> {

	User findByEmail(String email);

    User findByCredentials(String userName, String password);

    void flush();
    
}
