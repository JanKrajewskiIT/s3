package pl.lodz.p.was04.department.core.manager.contractors;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.contractors.PostalCodesDao;
import pl.lodz.p.was04.department.core.domain.contractors.PostalCode;

/**
 *
 * @author Janiu
 */
@Component
public class PostalCodesManager implements PostalCodesManagerLocal {

    @Autowired
    PostalCodesDao postalCodesDao;

    @RolesAllowed("contractorManagement")
    @Override
    public List<PostalCode> getPostalCodes() {
        return postalCodesDao.findAll();
    }

    @RolesAllowed("contractorManagement")
    @Override
    public PostalCode getById(String postalCodeId) {
        return postalCodesDao.findOne(postalCodeId);
    }

}
