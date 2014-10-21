package pl.lodz.p.was04.department.core.dao.accountmanagement;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.PasswordChangeRequest;
import pl.lodz.p.was04.department.core.domain.User;

/**
 *
 * @author Łukasz Gadomski
 */
@Repository
@Transactional
public class PasswordChangeRequestDaoImpl extends AbstractCrudDao<PasswordChangeRequest, String> implements PasswordChangeRequestDao {

    public PasswordChangeRequestDaoImpl() {
        super(PasswordChangeRequest.class);
    }

	@Override
	@Transactional(readOnly = true)
    public PasswordChangeRequest findByUser(User user) {
        try {
            Query query = getEntityManager().createNamedQuery("PasswordChangeRequest.findByUser");
            query.setParameter("user", user);
            return (PasswordChangeRequest) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
