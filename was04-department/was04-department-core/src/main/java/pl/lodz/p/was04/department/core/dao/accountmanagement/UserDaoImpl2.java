package pl.lodz.p.was04.department.core.dao.accountmanagement;

import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.User;
import pl.lodz.p.was04.department.core.exception.OptLockException;
import pl.lodz.p.was04.department.core.exception.UniqueConstraintViolationException;
/**
 *
 * @author Łukasz Gadomski
 */
@Repository
@Transactional
public class UserDaoImpl2 extends AbstractCrudDao<User, Long> implements UserDao2 {

    public UserDaoImpl2() {
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
        try {
            Query query = getEntityManager().createNamedQuery("User.findByEmail");
            query.setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

	@Override
	@Transactional(readOnly = true)
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
