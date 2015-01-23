package pl.lodz.p.project.core.service.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.p.project.core.dao.document.service.BaseServiceDocumentDao;
import pl.lodz.p.project.core.domain.document.service.ServiceDocument;
import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by milczu on 09.01.15.
 */
@Service
@Interceptors({TrackerInterceptor.class})
public class BaseServiceDocumentServiceImpl implements BaseServiceDocumentService {

    @Autowired
    private BaseServiceDocumentDao baseServiceDocumentDao;

    @Override
    public List<ServiceDocument> findAll() {
        return baseServiceDocumentDao.findAll();
    }
}
