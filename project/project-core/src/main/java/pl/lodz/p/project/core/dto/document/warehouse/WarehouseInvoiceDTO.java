package pl.lodz.p.project.core.dto.document.warehouse;

import pl.lodz.p.project.core.dto.document.base.DocumentDTO;
import pl.lodz.p.project.core.dto.document.base.InvoiceGoodDTO;

import java.util.List;

/**
 * @author Jan Krajewski
 */
public abstract class WarehouseInvoiceDTO<T extends InvoiceGoodDTO> extends DocumentDTO<Long> {

    private static final long serialVersionUID = 1L;

    private Double total;
    private String receivePerson;
    private String deliverPerson;
    private String annotation;
    private List<T> goodList;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(String receivePerson) {
        this.receivePerson = receivePerson;
    }

    public String getDeliverPerson() {
        return deliverPerson;
    }

    public void setDeliverPerson(String deliverPerson) {
        this.deliverPerson = deliverPerson;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public List<T> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<T> goodList) {
        this.goodList = goodList;
    }
}
