package pl.lodz.p.project.core.domain.document.service;

import pl.lodz.p.project.core.domain.document.base.InvoiceGood;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by milczu on 29.01.15.
 */
@Entity
@Table(name = "service_products_requests_goods")
public class ServiceProductsRequestGood extends InvoiceGood<ServiceProductsRequest> {

    private static final long serialVersionUID = 1L;
}
