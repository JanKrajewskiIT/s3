package pl.lodz.p.was04.department.core.manager.contractors;

import java.util.List;

import pl.lodz.p.was04.department.core.domain.contractors.PostalCode;

/**
 *
 * @author Janiu
 */
public interface PostalCodesManagerLocal {
    
    public List<PostalCode> getPostalCodes();
    
    public PostalCode getById(String postalCodeId);
}
