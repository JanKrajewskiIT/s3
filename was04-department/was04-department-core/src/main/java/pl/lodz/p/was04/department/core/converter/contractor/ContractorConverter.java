package pl.lodz.p.was04.department.core.converter.contractor;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.was04.department.core.converter.Converter;
import pl.lodz.p.was04.department.core.domain.contractor.Contractor;
import pl.lodz.p.was04.department.core.domain.contractor.ContractorGroup;
import pl.lodz.p.was04.department.core.dto.contractor.ContractorDTO;
import pl.lodz.p.was04.department.core.dto.contractor.ContractorGroupDTO;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class ContractorConverter implements Converter<Contractor, ContractorDTO> {

    @Inject
	private ContractorGroupConverter groupConverter;
	
	@Override
	public Contractor convertDTO(ContractorDTO objectDTO) {
		ContractorGroup group = groupConverter.convertDTO(objectDTO.getGroup());
		
		Contractor entity = new Contractor();
		entity.setId(objectDTO.getId());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setName(objectDTO.getName());
		entity.setAccountNumber(objectDTO.getAccountNumber());
		entity.setPostCode(objectDTO.getPostCode());
		entity.setCity(objectDTO.getCity());
		entity.setAdress(objectDTO.getAdress());
		entity.setNip(objectDTO.getNip());
		entity.setDiscount(objectDTO.getDiscount());
		entity.setWebsite(objectDTO.getWebsite());
		entity.setEmail(objectDTO.getEmail());
		entity.setDescription(objectDTO.getRepresentative());
		entity.setRepresentative(objectDTO.getRepresentative());
		entity.setGroup(group);
		entity.setCompany(objectDTO.getType().equals("Firma"));
		entity.setSupplier(objectDTO.getRole().equals("Dostawca"));
		return entity;
	}

	@Override
	public ContractorDTO convertEntity(Contractor entity) {
		ContractorGroupDTO group = groupConverter.convertEntity(entity.getGroup());
		String type = entity.isCompany() ? "Firma" : "Osoba fizyczna";
		String role = entity.isSupplier() ? "Dostawca" : "Nabywca";
		
		ContractorDTO objectDTO = new ContractorDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setName(entity.getName());
		objectDTO.setAccountNumber(entity.getAccountNumber());
		objectDTO.setPostCode(entity.getPostCode());
		objectDTO.setCity(entity.getCity());
		objectDTO.setAdress(entity.getAdress());
		objectDTO.setNip(entity.getNip());
		objectDTO.setDiscount(entity.getDiscount());
		objectDTO.setWebsite(entity.getWebsite());
		objectDTO.setEmail(entity.getEmail());
		objectDTO.setDescription(entity.getRepresentative());
		objectDTO.setRepresentative(entity.getRepresentative());
		objectDTO.setGroup(group);
		objectDTO.setType(type);
		objectDTO.setRole(role);
		return objectDTO;
	}

}
