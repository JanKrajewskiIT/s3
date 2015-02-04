package pl.lodz.p.project.core.converter.document.sale;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.document.items.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.sale.SaleDocumentDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceDTO;
import pl.lodz.p.project.core.dto.document.warehouse.ExternalInvoiceGoodDTO;
import pl.lodz.p.project.core.service.document.items.DocumentNumeratorService;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;

/**
 * Created by Łukasz on 2015-01-31.
 */
@Named
@ApplicationScoped
public class SaleDocumentExternalInvoiceConverter {

    private final String type = "WZ";
    @Autowired
    private DocumentNumeratorService documentNumeratorService;

    public ExternalInvoiceDTO convertToExternal(SaleDocumentDTO entity) {

        ExternalInvoiceDTO objectDTO = new ExternalInvoiceDTO();
        objectDTO.setVersion(entity.getVersion());
        objectDTO.setSymbol(documentNumeratorService.nextNumber(type));
        objectDTO.setType(type);
        objectDTO.setTotal(entity.getTotal());
        objectDTO.setDocumentDate(entity.getDocumentDate());
        objectDTO.setDeliverPerson(entity.getDeliverPerson());
        objectDTO.setIssuePerson(entity.getIssuePerson());
        objectDTO.setReceivePerson(entity.getReceivePerson());
        objectDTO.setAnnotation(entity.getAnnotation());
        objectDTO.setOrderSymbol(entity.getOrderSymbol());
        objectDTO.setDeliveryDate(entity.getSaleDate());
        objectDTO.setContractor(entity.getContractor());
        objectDTO.setTransportMean(entity.getTransportMean());
        objectDTO.setGoodList(new ArrayList<ExternalInvoiceGoodDTO>());

        for (DocumentPositionDTO invoiceGood : entity.getGoodList()) {
            ExternalInvoiceGoodDTO invoiceGoodDTO = new ExternalInvoiceGoodDTO();
            invoiceGoodDTO.setGood(invoiceGood.getGood());
            invoiceGoodDTO.setQuantity(invoiceGood.getQuantity());
            invoiceGoodDTO.setInvoice(objectDTO);
            objectDTO.getGoodList().add(invoiceGoodDTO);
        }
        return objectDTO;
    }
}
