package pl.lodz.p.project.core.dao.document.items;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lodz.p.project.core.dao.base.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.items.TransportMean;

/**
 *
 * @author Janiu
 */
@Repository
@Transactional
public class TransportMeanDaoImpl extends AbstractCrudDao<TransportMean, Long> implements TransportMeanDao {
    
    public TransportMeanDaoImpl() {
        super(TransportMean.class);
    }

}
