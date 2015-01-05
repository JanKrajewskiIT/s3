package pl.lodz.p.project.core.dto.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;

public class ServiceRepairOrderDTO extends BaseServiceDocumentDTO {

	public ServiceRepairOrderDTO() {
		super(ServiceDocumentType.REPAIR_ORDER);
	}
	
	private ContractorDTO contractor;
	private String equipentInfo;
	private boolean guarantee;
	private String guaranteeNo;
	private String saleDocumentNo;
	private String description;

	public ContractorDTO getContractor() {
		return contractor;
	}
	public void setContractor(ContractorDTO contractor) {
		this.contractor = contractor;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
