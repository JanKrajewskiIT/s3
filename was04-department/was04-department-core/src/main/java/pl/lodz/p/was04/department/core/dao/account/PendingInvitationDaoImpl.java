package pl.lodz.p.was04.department.core.dao.account;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.account.PendingInvitation;

/**
 *
 * @author Łukasz Gadomski
 */
@Repository
@Transactional
public class PendingInvitationDaoImpl extends AbstractCrudDao<PendingInvitation, Long> implements PendingInvitationDao {

    public PendingInvitationDaoImpl() {
        super(PendingInvitation.class);
    }

    /**
     * Retrieves a pending invitation with given e-mail address from the DB.
     *
     * @param token the token of the searched pending invitation.
     * @return the found pending invitation.
     */
	@Override
	@Transactional(readOnly = true)
    public PendingInvitation findByToken(String token) {
        try {
            Query query = getEntityManager().createNamedQuery("PendingInvitation.findByToken");
            query.setParameter("token", token);
            return (PendingInvitation) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    /**
     * Retrieves a pending invitation with given token from the DB.
     *
     * @param email the e-mail address of the searched pending invitation.
     * @return the found pending invitation.
     */
	@Override
	@Transactional(readOnly = true)
    public PendingInvitation findByEmail(String email) {
        try {
            Query query = getEntityManager().createNamedQuery("PendingInvitation.findByEmail");
            query.setParameter("email", email);
            return (PendingInvitation) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
