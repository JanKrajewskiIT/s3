package pl.lodz.p.was04.department.core.manager.documents;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.dao.documents.MeansOfTransportDao;
import pl.lodz.p.was04.department.core.domain.documents.MeanOfTransport;

/**
 *
 * @author janiu
 */
@Component
public class MeansOfTransportManager implements MeansOfTransportManagerLocal {

    @Autowired
    private MeansOfTransportDao meanOfTransportDao;

    @RolesAllowed("documentManagement")
    @Override
    public MeanOfTransport getById(Long id) {
        return meanOfTransportDao.findOne(id);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<MeanOfTransport> getMeansOfTransport() {
        return meanOfTransportDao.findAll();
    }

    @RolesAllowed("documentManagement")
    @Override
    public Long add(MeanOfTransport meanOfTransport) {
        meanOfTransportDao.save(meanOfTransport);
        return meanOfTransport.getId();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(MeanOfTransport meanOfTransport) {
        meanOfTransportDao.save(meanOfTransport);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(MeanOfTransport meanOfTransport) {
        meanOfTransportDao.delete(meanOfTransport);
    }

}
