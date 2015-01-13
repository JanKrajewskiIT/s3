package pl.lodz.p.project.core.dao.account;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.account.PasswordChangeRequest;
import pl.lodz.p.project.core.domain.account.User;

/**
 *
 * @author Łukasz Gadomski
 */
@Repository
@Transactional
public class PasswordChangeRequestDaoImpl extends AbstractCrudDao<PasswordChangeRequest, Long> implements PasswordChangeRequestDao {

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
