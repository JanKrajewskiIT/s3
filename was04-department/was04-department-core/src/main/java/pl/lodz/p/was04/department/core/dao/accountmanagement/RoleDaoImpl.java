package pl.lodz.p.was04.department.core.dao.accountmanagement;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.Role;

/**
 *
 * @author Łukasz Gadomski
 */
@Repository
@Transactional
public class RoleDaoImpl extends AbstractCrudDao<Role, Long> implements RoleDao {

    public RoleDaoImpl() {
        super(Role.class);
    }

	@Override
	@Transactional(readOnly = true)
    public Role findByName(String roleName) {
        try {
            Query query = getEntityManager().createNamedQuery("Role.findByRoleName");
            query.setParameter("roleName", roleName);
            return (Role) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
