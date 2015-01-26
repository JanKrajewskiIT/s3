package pl.lodz.p.project.core.converter.contractor;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.contractor.Address;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.contractor.ContractorGroup;
import pl.lodz.p.project.core.dto.contractor.AddressDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
*
* @author Janiu
*/
@Named
@ApplicationScoped
public class ContractorConverter implements Converter<Contractor, ContractorDTO> {

    @Inject
	private ContractorGroupConverter groupConverter;

	@Inject
	private AddressConverter addressConverter;
	
	@Override
	public Contractor convertDTO(ContractorDTO objectDTO) {
		ContractorGroup group = groupConverter.convertDTO(objectDTO.getGroup());
		Address address = addressConverter.convertDTO(objectDTO.getAddress());
		
		Contractor entity = new Contractor();
		entity.setId(objectDTO.getId());
		entity.setVersion(objectDTO.getVersion());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setName(objectDTO.getName());
		entity.setAccountNumber(objectDTO.getAccountNumber());
		entity.setAddress(address);
		entity.setNip(objectDTO.getNip());
		entity.setDiscount(objectDTO.getDiscount());
		entity.setWebsite(objectDTO.getWebsite());
		entity.setEmail(objectDTO.getEmail());
		entity.setDescription(objectDTO.getDescription());
		entity.setRepresentative(objectDTO.getRepresentative());
		entity.setGroup(group);
		entity.setPhone(objectDTO.getPhone());
		entity.setCompany(objectDTO.getType().equals("Firma"));
		entity.setSupplier(objectDTO.getRole().equals("Dostawca"));
		return entity;
	}

	@Override
	public ContractorDTO convertEntity(Contractor entity) {
		ContractorGroupDTO group = groupConverter.convertEntity(entity.getGroup());
		AddressDTO address = addressConverter.convertEntity(entity.getAddress());
		String type = entity.isCompany() ? "Firma" : "Osoba fizyczna";
		String role = entity.isSupplier() ? "Dostawca" : "Nabywca";
		
		ContractorDTO objectDTO = new ContractorDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setVersion(entity.getVersion());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setName(entity.getName());
		objectDTO.setAccountNumber(entity.getAccountNumber());
		objectDTO.setAddress(address);
		objectDTO.setNip(entity.getNip());
		objectDTO.setDiscount(entity.getDiscount());
		objectDTO.setWebsite(entity.getWebsite());
		objectDTO.setEmail(entity.getEmail());
		objectDTO.setDescription(entity.getDescription());
		objectDTO.setRepresentative(entity.getRepresentative());
		objectDTO.setPhone(entity.getPhone());
		objectDTO.setGroup(group);
		objectDTO.setType(type);
		objectDTO.setRole(role);
		return objectDTO;
	}

}
