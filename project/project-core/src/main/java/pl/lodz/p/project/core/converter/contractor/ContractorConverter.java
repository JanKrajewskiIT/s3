package pl.lodz.p.project.core.converter.contractor;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pl.lodz.p.project.core.converter.Converter;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.contractor.ContractorGroup;
import pl.lodz.p.project.core.domain.contractor.PostalCode;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorGroupDTO;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;

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
    private PostalCodeConverter postalCodeConverter;
	
	@Override
	public Contractor convertDTO(ContractorDTO objectDTO) {
		ContractorGroup group = groupConverter.convertDTO(objectDTO.getGroup());
		PostalCode postalCode = postalCodeConverter.convertDTO(objectDTO.getPostalCode());
		
		Contractor entity = new Contractor();
		entity.setId(objectDTO.getId());
		entity.setSymbol(objectDTO.getSymbol());
		entity.setName(objectDTO.getName());
		entity.setAccountNumber(objectDTO.getAccountNumber());
		entity.setPostalCode(postalCode);
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
		PostalCodeDTO postalCode = postalCodeConverter.convertEntity(entity.getPostalCode());
		String type = entity.isCompany() ? "Firma" : "Osoba fizyczna";
		String role = entity.isSupplier() ? "Dostawca" : "Nabywca";
		
		ContractorDTO objectDTO = new ContractorDTO();
		objectDTO.setId(entity.getId());
		objectDTO.setSymbol(entity.getSymbol());
		objectDTO.setName(entity.getName());
		objectDTO.setAccountNumber(entity.getAccountNumber());
		objectDTO.setPostalCode(postalCode);
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
