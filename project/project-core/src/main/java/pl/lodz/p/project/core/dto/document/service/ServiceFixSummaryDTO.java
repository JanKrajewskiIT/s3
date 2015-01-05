package pl.lodz.p.project.core.dto.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;

public class ServiceFixSummaryDTO extends BaseServiceDocumentDTO {

	public ServiceFixSummaryDTO() {
		super(ServiceDocumentType.FIX_SUMMARY);
	}
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
