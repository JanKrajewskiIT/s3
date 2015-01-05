package pl.lodz.p.project.core.dto.document.service;

import java.util.Date;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.dto.account.UserDTO;

public class BaseServiceDocumentDTO implements ServiceDocumentDTO {

	private String symbol;
	private Date creationDate;
	private UserDTO documentCreator;
	private final ServiceDocumentType serviceDocumentType;
	private ServiceDocumentState state;
	
	public BaseServiceDocumentDTO(ServiceDocumentType serviceDocumentType) {
		this.serviceDocumentType = serviceDocumentType;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public UserDTO getDocumentCreator() {
		return documentCreator;
	}

	public void setDocumentCreator(UserDTO documentCreator) {
		this.documentCreator = documentCreator;
	}

	public ServiceDocumentType getServiceDocumentType() {
		return serviceDocumentType;
	}

	public ServiceDocumentState getState() {
		return state;
	}

	public void setState(ServiceDocumentState state) {
		this.state = state;
	}
	
	
}
