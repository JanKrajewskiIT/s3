package pl.lodz.p.project.core.converter.contractor;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.domain.contractor.ContractorContact;
import pl.lodz.p.project.core.dto.contractor.ContractorContactDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class ContractorContactConverter implements Converter<ContractorContact, ContractorContactDTO> {
	
	@Override
	public ContractorContact convertDTO(ContractorContactDTO objectDTO) {
		ContractorContact entity = new ContractorContact();
		entity.setId(objectDTO.getId());
		entity.setName(objectDTO.getName());
		entity.setNumber(objectDTO.getNumber());
		entity.setDefault(objectDTO.isDefault());
		entity.setContractor(objectDTO.getContractor());
		return entity;
	}

	@Override
	public ContractorContactDTO convertEntity(ContractorContact entity) {
		ContractorContactDTO objectDTO = new ContractorContactDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setName(entity.getName());
		objectDTO.setNumber(entity.getNumber());
		objectDTO.setDefault(entity.isDefault());
		objectDTO.setContractor(entity.getContractor());
		return objectDTO;
	}

}
