package pl.lodz.p.was04.department.core.service.document;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.converter.document.DocumentPositionConverter;
import pl.lodz.p.was04.department.core.converter.document.SaleDocumentConverter;
import pl.lodz.p.was04.department.core.dao.account.UserDao;
import pl.lodz.p.was04.department.core.dao.document.DocumentPositionDao;
import pl.lodz.p.was04.department.core.dao.document.SaleDocumentDao;
import pl.lodz.p.was04.department.core.domain.account.User;
import pl.lodz.p.was04.department.core.domain.document.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.document.SaleDocument;
import pl.lodz.p.was04.department.core.dto.document.DocumentPositionDTO;
import pl.lodz.p.was04.department.core.dto.document.SaleDocumentDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class SaleDocumentsServiceImpl implements SaleDocumentsService {

    @Autowired
    private SaleDocumentDao saleDocumentDao;

    @Autowired
    private DocumentPositionDao documentsPositionsDao;
    
    @Autowired
    private UserDao userDao;

    @Autowired
    private SaleDocumentConverter saleDocumentConverter;
    
    @Autowired
    private DocumentPositionConverter documentPositionConverter;
    
    @RolesAllowed("documentManagement")
    @Override
    public SaleDocumentDTO getById(Long id) {
    	SaleDocument saleDocument = saleDocumentDao.findOne(id);
    	return saleDocumentConverter.convertEntity(saleDocument);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<SaleDocumentDTO> getSaleDocuments() {
        List<SaleDocumentDTO> saleDocumentList = new ArrayList<>();
        for (SaleDocument saleDocument : saleDocumentDao.findAll()) {
        	SaleDocumentDTO saleDocumentDTO = saleDocumentConverter.convertEntity(saleDocument);
        	saleDocumentList.add(saleDocumentDTO);
        }
        return saleDocumentList;
    }

    @RolesAllowed("documentManagement")
    @Override
    public String add(SaleDocumentDTO saleDocumentDTO) {
        List<DocumentPosition> documentPositionList = new ArrayList<>();
        for(DocumentPositionDTO documentPositionDTO : saleDocumentDTO.getGoodsPositions()) {
            DocumentPosition documentPosition = documentPositionConverter.convertDTO(documentPositionDTO);
            documentPositionList.add(documentPosition);
        }
        documentsPositionsDao.createAll(documentPositionList);
        
        User user = userDao.findByEmail(saleDocumentDTO.getIssuePerson().getEmail());
        SaleDocument saleDocument = saleDocumentConverter.convertDTO(saleDocumentDTO);
        saleDocument.setIssuePerson(user);        
        saleDocumentDao.save(saleDocument);
        return saleDocument.getSymbol();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(SaleDocumentDTO saleDocumentDTO) {
    	SaleDocument saleDocument = saleDocumentConverter.convertDTO(saleDocumentDTO);
        saleDocumentDao.save(saleDocument);
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(SaleDocumentDTO saleDocumentDTO) {
    	SaleDocument saleDocument = saleDocumentConverter.convertDTO(saleDocumentDTO);
        saleDocumentDao.delete(saleDocument);
    }
    
}
