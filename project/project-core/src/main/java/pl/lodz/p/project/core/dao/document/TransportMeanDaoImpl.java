package pl.lodz.p.project.core.dao.document;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.project.core.dao.AbstractCrudDao;
import pl.lodz.p.project.core.domain.document.TransportMean;

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
