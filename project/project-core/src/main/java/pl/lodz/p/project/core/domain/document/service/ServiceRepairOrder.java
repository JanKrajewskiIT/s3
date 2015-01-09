package pl.lodz.p.project.core.domain.document.service;

import pl.lodz.p.project.core.domain.contractor.Contractor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by milczu on 09.01.15.
 */
@Entity
@Table(name = "service_repair_orders")
public class ServiceRepairOrder extends BaseDocumentService {

    @JoinColumn(name = "contractor_id", referencedColumnName = "contractor_id")
    @ManyToOne(optional = false)
    private Contractor contractor;

    @Column(name = "equipment_info", length = 255)
    private String equipentInfo;

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

    public String getEquipentInfo() {
        return equipentInfo;
    }

    public void setEquipentInfo(String equipentInfo) {
        this.equipentInfo = equipentInfo;
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
