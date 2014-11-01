package pl.lodz.p.project.core.service.document;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.project.core.converter.document.DocumentPositionConverter;
import pl.lodz.p.project.core.dao.document.DocumentPositionDao;
import pl.lodz.p.project.core.domain.document.DocumentPosition;
import pl.lodz.p.project.core.dto.document.DocumentPositionDTO;
import pl.lodz.p.project.core.interceptor.TrackerInterceptor;

/**
 *
 * @author Janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class DocumentsPositionsServiceImpl implements DocumentsPositionsService {

    @Autowired
    private DocumentPositionDao documentPositionDao;
    
    @Autowired
    private DocumentPositionConverter documentPositionConverter;
     
    @RolesAllowed("documentManagement")
    @Override
    public DocumentPositionDTO getById(Long id) {
    	DocumentPosition documentPosition = documentPositionDao.findOne(id);
        return documentPositionConverter.convertEntity(documentPosition);
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<DocumentPositionDTO> getDocumentsPositions() {
        List<DocumentPositionDTO> documentsPositionList = new ArrayList<>();
        for (DocumentPosition documentPosition : documentPositionDao.findAll()) {
        	DocumentPositionDTO documentPositionDTO = documentPositionConverter.convertEntity(documentPosition);
        	documentsPositionList.add(documentPositionDTO);
        }
        return documentsPositionList;
    }

    @Override
    public String saveDocumentPositions(List<DocumentPositionDTO> documentPositionList) {
    	for(DocumentPositionDTO documentPositionDTO : documentPositionList) {
    		DocumentPosition documentPosition = documentPositionConverter.convertDTO(documentPositionDTO);
            documentPositionDao.save(documentPosition);
    	}
        return "Data Saved";
    }

    @Override
    public String edit(List<DocumentPositionDTO> documentPositionList) {
    	for(DocumentPositionDTO documentPositionDTO : documentPositionList) {
    		DocumentPosition documentPosition = documentPositionConverter.convertDTO(documentPositionDTO);
            documentPositionDao.save(documentPosition);
    	}
        return "Data Saved";
    }
    
}
