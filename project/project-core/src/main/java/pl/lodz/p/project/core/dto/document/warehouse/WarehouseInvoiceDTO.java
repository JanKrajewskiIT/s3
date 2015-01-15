package pl.lodz.p.project.core.dto.document.warehouse;

import com.google.common.collect.ComparisonChain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;

/**
 * @author Jan Krajewski
 */
public class WarehouseInvoiceDTO extends DocumentDTO<Long> implements Comparable<WarehouseInvoiceDTO> {

    private static final long serialVersionUID = 1L;

    private Double total;
    private String receivePerson;
    private String deliverPerson;
    private String annotation;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int compareTo(WarehouseInvoiceDTO o) {
        return ComparisonChain.start().compare(this.getId(), o.getId()).result();
    }

}
