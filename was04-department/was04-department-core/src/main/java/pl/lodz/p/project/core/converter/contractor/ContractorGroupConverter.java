package pl.lodz.p.project.core.converter.contractor;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.domain.contractor.ContractorGroup;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class ContractorGroupConverter implements Converter<ContractorGroup, ContractorGroupDTO> {

	@Override
	public ContractorGroup convertDTO(ContractorGroupDTO objectDTO) {
		ContractorGroup entity = new ContractorGroup();
		entity.setId(objectDTO.getId());
		entity.setName(objectDTO.getName());
		return entity;
	}

	@Override
	public ContractorGroupDTO convertEntity(ContractorGroup entity) {
		ContractorGroupDTO objectDTO = new ContractorGroupDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setName(entity.getName());
		return objectDTO;
	}
	
}
