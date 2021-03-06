package pl.lodz.p.project.core.converter.contractor;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.contractor.ContractorGroup;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

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
		entity.setVersion(objectDTO.getVersion());
		entity.setName(objectDTO.getName());
		return entity;
	}

	@Override
	public ContractorGroupDTO convertEntity(ContractorGroup entity) {
		ContractorGroupDTO objectDTO = new ContractorGroupDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setName(entity.getName());
		return objectDTO;
	}
	
}
