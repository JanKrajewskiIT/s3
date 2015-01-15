package pl.lodz.p.project.core.dto.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocumentState;
import pl.lodz.p.project.core.domain.document.service.ServiceDocumentType;
import pl.lodz.p.project.core.dto.account.UserDTO;

import java.util.Date;

public interface ServiceDocumentDTO {

	String getSymbol();

	String getType();

	Date getDocumentDate();

	UserDTO getIssuePerson();

	ServiceDocumentType getServiceDocumentType();
	
	ServiceDocumentState getState();
}
