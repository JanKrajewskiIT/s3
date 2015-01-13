package pl.lodz.p.project.core.dao.contractor;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.contractor.PostalCode;

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
