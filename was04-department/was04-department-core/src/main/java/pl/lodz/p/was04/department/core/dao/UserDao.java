package pl.lodz.p.was04.department.core.dao;

import pl.lodz.p.was04.department.core.domain.User;

public interface UserDao extends CrudDao<User, Long> {

	User findByEmail(String login);

    void flush();

    User findByCredentials(String userName, String password);
    
}
