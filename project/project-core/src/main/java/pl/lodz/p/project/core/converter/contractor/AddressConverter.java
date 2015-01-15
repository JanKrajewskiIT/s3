package pl.lodz.p.project.core.converter.contractor;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.contractor.Address;
import pl.lodz.p.project.core.domain.contractor.PostalCode;
import pl.lodz.p.project.core.dto.contractor.AddressDTO;
import pl.lodz.p.project.core.dto.contractor.PostalCodeDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Jan Krajewski
 */
@Named
@ApplicationScoped
public class AddressConverter implements Converter<Address, AddressDTO> {

    @Inject
    private PostalCodeConverter postalCodeConverter;

    @Override
    public Address convertDTO(AddressDTO objectDTO) {
        PostalCode postalCode = postalCodeConverter.convertDTO(objectDTO.getPostalCode());

        Address entity = new Address();
        entity.setAddress(objectDTO.getAddress());
        entity.setCity(objectDTO.getCity());
        entity.setPostalCode(postalCode);
        return entity;
    }

    @Override
    public AddressDTO convertEntity(Address entity) {
        PostalCodeDTO postalCode = postalCodeConverter.convertEntity(entity.getPostalCode());

        AddressDTO objectDTO = new AddressDTO();
        objectDTO.setAddress(entity.getAddress());
        objectDTO.setCity(entity.getCity());
        objectDTO.setPostalCode(postalCode);
        return objectDTO;
    }

}
