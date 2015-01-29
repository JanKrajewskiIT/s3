package pl.lodz.p.project.core.domain.document.service;

import pl.lodz.p.project.core.domain.document.warehouse.InternalInvoiceGood;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by milczu on 27.01.15.
 */
@Table(name = "service_products_requests")
@Entity
public class ServiceProductsRequest extends BaseDocumentService {

    @Column(name = "service_repair_order", length = 80)
    private String serviceRepairOrderSymbol;

    @OneToMany(mappedBy = "id.invoice", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ServiceProductsRequestGood> items = new HashSet<>();

    public ServiceProductsRequest() {
        super(ServiceDocumentType.PRODUCTS_REQUEST);
    }

    public String getServiceRepairOrderSymbol() {
        return serviceRepairOrderSymbol;
    }

    public void setServiceRepairOrderSymbol(String serviceRepairOrderSymbol) {
        this.serviceRepairOrderSymbol = serviceRepairOrderSymbol;
    }

    public Set<ServiceProductsRequestGood> getItems() {
        return items;
    }

    public void setItems(Set<ServiceProductsRequestGood> items) {
        this.items = items;
    }
}
