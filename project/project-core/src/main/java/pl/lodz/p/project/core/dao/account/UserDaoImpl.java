package pl.lodz.p.project.core.dao.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.exception.OptLockException;
import pl.lodz.p.project.core.exception.UniqueConstraintViolationException;

import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

/**
* @author Łukasz Gadomski, Milczu
*/
@Repository
@Transactional
public class UserDaoImpl extends AbstractCrudDao<User, Long> implements UserDao {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

	public UserDaoImpl() {
		super(User.class);
	}
	
	@Transactional(readOnly = true)
    public void create(User user) throws UniqueConstraintViolationException {
        try {
            save(user);
            user = getEntityManager().merge(user);
        } catch (ConstraintViolationException e) {
            Throwable t = e.getCause();
            if (t != null && t.getMessage().contains("duplicate key value violates unique constraint")) {
                throw new UniqueConstraintViolationException(t.getMessage());
            }
        }
    }

	@Transactional(readOnly = true)
    public void edit(User user) {
        try {
            getEntityManager().merge(user);
            getEntityManager().flush();
        } catch (OptimisticLockException optLockException) {
            throw new OptLockException(optLockException.getMessage(), optLockException);
        }
    }
	
    /**
     * Retrieves a user with given e-mail address from the DB.
     *
     * @param email the e-mail address of the searched user
     * @return the found user.
     */
    @Override
    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        LOGGER.info("findByEmail: {}", email);
        try {
            return getEntityManager().createNamedQuery(User.NAMED_QUERY_FIND_BY_EMAIL, User.class)
                    .setParameter("email", email).getSingleResult();
        } catch (NoResultException nre) {
            LOGGER.warn("findByEmail - NoResultException", e.getMessage());
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
