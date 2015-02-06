package pl.lodz.p.project.core.converter.document.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lodz.p.project.core.dto.document.purchase.PurchaseInvoiceGoodDTO;
import pl.lodz.p.project.core.dto.document.sale.DocumentPositionDTO;
import pl.lodz.p.project.core.dto.document.purchase.PurchaseInvoiceDTO;
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
public class PurchaseInvoiceExternalInvoiceConverter {

    private final String type = "PZ";
    @Autowired
    private DocumentNumeratorService documentNumeratorService;

    public ExternalInvoiceDTO convertToExternal(PurchaseInvoiceDTO entity) {

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
        objectDTO.setDeliveryDate(entity.getPurchaseDate());
        objectDTO.setContractor(entity.getContractor());
        objectDTO.setTransportMean(entity.getTransportMean());
        objectDTO.setGoodList(new ArrayList<ExternalInvoiceGoodDTO>());

        for (PurchaseInvoiceGoodDTO invoiceGood : entity.getGoodList()) {
            ExternalInvoiceGoodDTO invoiceGoodDTO = new ExternalInvoiceGoodDTO();
            invoiceGoodDTO.setGood(invoiceGood.getGood());
            invoiceGoodDTO.setQuantity(invoiceGood.getQuantity());
            invoiceGoodDTO.setInvoice(objectDTO);
            objectDTO.getGoodList().add(invoiceGoodDTO);
        }
        return objectDTO;
    }
}