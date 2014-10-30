package pl.lodz.p.was04.department.core.dao.account;

import pl.lodz.p.was04.department.core.dao.CrudDao;
import pl.lodz.p.was04.department.core.domain.account.PasswordChangeRequest;
import pl.lodz.p.was04.department.core.domain.account.User;

/**
 *
 * @author Łukasz Gadomski
 */
public interface PasswordChangeRequestDao extends CrudDao<PasswordChangeRequest, Long> {

    PasswordChangeRequest findByUser(User user);

}
