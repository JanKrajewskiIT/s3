package pl.lodz.p.project.core.dto.document.service;

import java.util.Date;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.dto.account.UserDTO;

public interface ServiceDocumentDTO {

	String getSymbol();
	
	Date getCreationDate();
	
	UserDTO getDocumentCreator();
	
	ServiceDocumentType getServiceDocumentType();
	
	ServiceDocumentState getState();
}
