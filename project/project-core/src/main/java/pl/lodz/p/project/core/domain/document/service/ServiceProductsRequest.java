package pl.lodz.p.project.core.domain.document.service;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by milczu on 27.01.15.
 */
//@Table(name = "service_products_requests")
//@Entity
public class ServiceProductsRequest extends BaseDocumentService {

    public ServiceProductsRequest() {
        super(ServiceDocumentType.PRODUCTS_REQUEST);
    }
}
