package pl.lodz.p.project.core.dao.account;

import pl.lodz.p.project.core.dao.CrudDao;
import pl.lodz.p.project.core.domain.account.PasswordChangeRequest;
import pl.lodz.p.project.core.domain.account.User;

/**
 *
 * @author Łukasz Gadomski
 */
public interface PasswordChangeRequestDao extends CrudDao<PasswordChangeRequest, Long> {

    PasswordChangeRequest findByUser(User user);

}
