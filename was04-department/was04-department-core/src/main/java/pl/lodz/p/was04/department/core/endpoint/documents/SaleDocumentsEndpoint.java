package pl.lodz.p.was04.department.core.endpoint.documents;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.lodz.p.was04.department.core.domain.User;
import pl.lodz.p.was04.department.core.domain.documents.DocumentPosition;
import pl.lodz.p.was04.department.core.domain.documents.SaleDocument;
import pl.lodz.p.was04.department.core.domain.documents.SaleDocumentPK;
import pl.lodz.p.was04.department.core.dto.documents.DocumentPositionDTO;
import pl.lodz.p.was04.department.core.dto.documents.SaleDocumentDTO;
import pl.lodz.p.was04.department.core.interceptor.TrackerInterceptor;
import pl.lodz.p.was04.department.core.manager.accountmanagement.AccountManagerLocal;
import pl.lodz.p.was04.department.core.manager.documents.SaleDocumentsManagerLocal;

/**
 *
 * @author janiu
 */
@Component
@Interceptors({TrackerInterceptor.class})
public class SaleDocumentsEndpoint implements SaleDocumentsEndpointLocal {

    @Autowired
    private SaleDocumentsManagerLocal saleDocumentManager;
    
    @Autowired
    private AccountManagerLocal accountManager;

    @RolesAllowed("documentManagement")
    @Override
    public SaleDocumentDTO getById(String id, Long whId) {
        return new SaleDocumentDTO(saleDocumentManager.getById(new SaleDocumentPK(id, whId)));
    }

    @RolesAllowed("documentManagement")
    @Override
    public List<SaleDocumentDTO> getSaleDocuments() {
        List<SaleDocument> saleDocuments = saleDocumentManager.getSaleDocuments();
        List<SaleDocumentDTO> saleDocumentDTOs = new ArrayList<>();
        for (SaleDocument saleDocument : saleDocuments) {
            saleDocumentDTOs.add(new SaleDocumentDTO(saleDocument));
        }
        return saleDocumentDTOs;
    }

    @RolesAllowed("documentManagement")
    @Override
    public String add(SaleDocumentDTO saleDocument) {
        List<DocumentPositionDTO> documentPositionsDTO = saleDocument.getGoodsPositions();
        List<DocumentPosition> documentPositions = new ArrayList<>();
        for(DocumentPositionDTO documentPositionDTO : documentPositionsDTO) {
            DocumentPosition docPos = new DocumentPosition(documentPositionDTO);
            documentPositions.add(docPos);
        }
        User user = accountManager.getUserByEmail(saleDocument.getIssuePerson().getEmail());
        SaleDocument saleDocumentEntity = new SaleDocument(saleDocument);
        saleDocumentEntity.setIssuePerson(user);
        
        return saleDocumentManager.add(saleDocumentEntity, documentPositions).getSymbol();
    }

    @RolesAllowed("documentManagement")
    @Override
    public void edit(SaleDocumentDTO saleDocument) {
        saleDocumentManager.edit(new SaleDocument(saleDocument));
    }

    @RolesAllowed("documentManagement")
    @Override
    public void remove(SaleDocumentDTO saleDocument) {
        saleDocumentManager.remove(new SaleDocument(saleDocument));
    }
}
