package pl.lodz.p.project.core.dto.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;

public class ServiceRepairOrderDTO extends BaseServiceDocumentDTO {

    private ContractorDTO contractor;
    private String equipmentInfo;
    private boolean guarantee;
    private String guaranteeNo;
    private String saleDocumentNo;
    private String description;

    public ServiceRepairOrderDTO() {
        super(ServiceDocumentType.REPAIR_ORDER);
        setType("SRO");
    }

    public ContractorDTO getContractor() {
        return contractor;
    }

    public void setContractor(ContractorDTO contractor) {
        this.contractor = contractor;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
