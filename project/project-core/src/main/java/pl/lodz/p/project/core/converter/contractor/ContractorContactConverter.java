package pl.lodz.p.project.core.converter.contractor;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.contractor.ContractorContact;
import pl.lodz.p.project.core.dto.contractor.ContractorContactDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class ContractorContactConverter implements Converter<ContractorContact, ContractorContactDTO> {

	@Inject
	private ContractorConverter contractorConverter;

	@Override
	public ContractorContact convertDTO(ContractorContactDTO objectDTO) {
		Contractor contractor = contractorConverter.convertDTO(objectDTO.getContractor());

		ContractorContact entity = new ContractorContact();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setName(objectDTO.getName());
		entity.setNumber(objectDTO.getNumber());
		entity.setDefault(objectDTO.isDefault());
		entity.setContractor(contractor);
		return entity;
	}

	@Override
	public ContractorContactDTO convertEntity(ContractorContact entity) {
		ContractorDTO contractor = contractorConverter.convertEntity(entity.getContractor());

		ContractorContactDTO objectDTO = new ContractorContactDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setName(entity.getName());
		objectDTO.setNumber(entity.getNumber());
		objectDTO.setDefault(entity.isDefault());
		objectDTO.setContractor(contractor);
		return objectDTO;
	}

}
