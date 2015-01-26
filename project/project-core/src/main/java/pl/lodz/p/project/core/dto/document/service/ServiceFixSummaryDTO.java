package pl.lodz.p.project.core.dto.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;

public class ServiceFixSummaryDTO extends BaseServiceDocumentDTO {

	public ServiceFixSummaryDTO() {
		super(ServiceDocumentType.FIX_SUMMARY);
		setType("SFS");
	}
	
	private String description;
	private String serviceFixOrderSymbol;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceFixOrderSymbol() {
		return serviceFixOrderSymbol;
	}

	public void setServiceFixOrderSymbol(String serviceFixOrderSymbol) {
		this.serviceFixOrderSymbol = serviceFixOrderSymbol;
	}
}
