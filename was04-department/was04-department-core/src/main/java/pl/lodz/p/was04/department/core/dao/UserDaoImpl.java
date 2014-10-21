package pl.lodz.p.was04.department.core.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.domain.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractCrudDao<User, Long> implements UserDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByLogin(String login) {
		LOGGER.info("findByLogin: {}", login);
		return getEntityManager().createNamedQuery(User.NAMED_QUERY_FIND_BY_LOGIN, User.class)
				.setParameter("login", login).getSingleResult();
	}

    /**
     * Retrieves a user with given e-mail address from the DB.
     *
     * @param email the e-mail address of the searched user
     * @return the found user.
     */
    @Override
    public User findByEmail(String email) {
        try {
            Query query = getEntityManager().createNamedQuery("User.findByEmail");
            query.setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public User findByCredentials(String userName, String password) {
        try {
            Query query = getEntityManager().createNamedQuery("User.findByCredentials");
            query.setParameter("email", userName);
            query.setParameter("password", password);
            return (User) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
