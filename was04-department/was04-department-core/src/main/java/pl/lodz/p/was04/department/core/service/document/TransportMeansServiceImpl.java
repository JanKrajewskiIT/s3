package pl.lodz.p.was04.department.core.service.document;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.converter.document.TransportMeanConverter;
import pl.lodz.p.was04.department.core.dao.document.TransportMeanDao;
import pl.lodz.p.was04.department.core.domain.document.TransportMean;
import pl.lodz.p.was04.department.core.dto.document.TransportMeanDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class TransportMeansServiceImpl implements TransportMeansService {

    @Autowired
    private TransportMeanDao transportMeanDao;

    @Autowired
    private TransportMeanConverter transportMeanConverter;
    
    @RolesAllowed("documentManagement")
    @Override
    public TransportMeanDTO getById(Long id) {
    	TransportMean transportMean = transportMeanDao.findOne(id);
        return transportMeanConverter.convertEntity(transportMean);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<TransportMeanDTO> getTransportMeans() {
        List<TransportMeanDTO> transportMeanList = new ArrayList<>();
        for (TransportMean transportMean : transportMeanDao.findAll()) {
        	TransportMeanDTO transportMeanDTO = transportMeanConverter.convertEntity(transportMean);
        	transportMeanList.add(transportMeanDTO);
        }
        return transportMeanList;
    }
}
