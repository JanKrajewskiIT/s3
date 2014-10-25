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
	public User findByEmail(String email) {
		LOGGER.info("findByLogin: {}", email);
		return getEntityManager().createNamedQuery(User.NAMED_QUERY_FIND_BY_EMAIL, User.class)
				.setParameter("email", email).getSingleResult();
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
