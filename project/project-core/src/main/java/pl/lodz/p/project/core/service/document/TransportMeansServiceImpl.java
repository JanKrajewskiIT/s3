package pl.lodz.p.project.core.service.document;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.document.TransportMeanConverter;
import pl.lodz.p.project.core.dao.document.TransportMeanDao;
import pl.lodz.p.project.core.domain.document.TransportMean;
import pl.lodz.p.project.core.dto.document.TransportMeanDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;
import pl.lodz.p.project.core.service.Transformer;

import com.google.common.collect.Lists;

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
    	Transformer<TransportMean, TransportMeanDTO> transformer = new Transformer<>(transportMeanConverter);
    	return Lists.transform(transportMeanDao.findAll(), transformer);
    }
    
}
