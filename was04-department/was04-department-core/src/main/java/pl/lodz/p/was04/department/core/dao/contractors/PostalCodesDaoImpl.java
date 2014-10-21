package pl.lodz.p.was04.department.core.dao.contractors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.contractors.PostalCode;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class PostalCodesDaoImpl extends AbstractCrudDao<PostalCode, String> implements PostalCodesDao {

	public PostalCodesDaoImpl() {
        super(PostalCode.class);
    }
    
}
