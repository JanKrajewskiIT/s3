package pl.lodz.p.project.core.domain.document.service;

import pl.lodz.p.project.core.domain.contractor.Contractor;

import javax.persistence.*;
import javax.validation.constraints.Null;

/**
 * @author Milczu
 */
@Entity
@Table(name = "service_repair_orders")
public class ServiceRepairOrder extends BaseDocumentService {

    public static final String DOCUMENT_TYPE = "SRO";

    public ServiceRepairOrder() {
        super(ServiceDocumentType.REPAIR_ORDER);
        setType(DOCUMENT_TYPE);
    }

    @JoinColumn(name = "contractor_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Contractor contractor;

    @Column(name = "equipment_info", length = 255)
    private String equipmentInfo;

    private boolean guarantee;

    @Column(name = "guarantee_no", length = 80)
    private String guaranteeNo;

    @Column(name = "sale_document_no", length = 80)
    private String saleDocumentNo;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEquipmentInfo() {
        return equipmentInfo;
    }

    public void setEquipmentInfo(String equipmentInfo) {
        this.equipmentInfo = equipmentInfo;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    public String getGuaranteeNo() {
        return guaranteeNo;
    }

    public void setGuaranteeNo(String guaranteeNo) {
        this.guaranteeNo = guaranteeNo;
    }

    public String getSaleDocumentNo() {
        return saleDocumentNo;
    }

    public void setSaleDocumentNo(String saleDocumentNo) {
        this.saleDocumentNo = saleDocumentNo;
    }
}
