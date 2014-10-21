package pl.lodz.p.was04.department.core.dao.documents;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.lodz.p.was04.department.core.dao.AbstractCrudDao;
import pl.lodz.p.was04.department.core.domain.documents.MeanOfTransport;

/**
 *
 * @author janiu
 */
@Repository
@Transactional
public class MeansOfTransportDaoImpl extends AbstractCrudDao<MeanOfTransport, Long> implements MeansOfTransportDao {
    
    public MeansOfTransportDaoImpl() {
        super(MeanOfTransport.class);
    }

}
