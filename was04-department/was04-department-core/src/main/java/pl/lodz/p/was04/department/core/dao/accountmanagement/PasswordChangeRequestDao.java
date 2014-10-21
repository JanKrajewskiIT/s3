package pl.lodz.p.was04.department.core.dao.accountmanagement;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.domain.PasswordChangeRequest;
import pl.lodz.p.was04.department.core.domain.User;

/**
 *
 * @author Łukasz Gadomski
 */
public interface PasswordChangeRequestDao extends CrudDao<PasswordChangeRequest, String> {

    PasswordChangeRequest findByUser(User user);

}
