package pl.lodz.p.project.core.domain.document.service;

import pl.lodz.p.project.core.dto.account.UserDTO;

import java.util.Date;

public interface ServiceDocument {

	Long getId();

	String getSymbol();

	String getType();

	Date getDocumentDate();

	UserDTO getIssuePerson();

	ServiceDocumentType getServiceDocumentType();
	
	ServiceDocumentState getState();
}
