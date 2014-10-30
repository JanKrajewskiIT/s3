package pl.lodz.p.was04.department.core.dao.contractor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.contractor.PostalCode;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class PostalCodeDaoImpl extends AbstractCrudDao<PostalCode, Long> implements PostalCodeDao {

	public PostalCodeDaoImpl() {
        super(PostalCode.class);
    }
    
}
