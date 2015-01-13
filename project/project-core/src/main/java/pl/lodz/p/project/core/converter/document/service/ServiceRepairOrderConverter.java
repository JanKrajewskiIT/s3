package pl.lodz.p.project.core.converter.document.service;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.contractor.ContractorConverter;
import pl.lodz.p.project.core.domain.account.User;
import pl.lodz.p.project.core.domain.contractor.Contractor;
import pl.lodz.p.project.core.domain.document.service.ServiceRepairOrder;
import pl.lodz.p.project.core.dto.account.UserDTO;
import pl.lodz.p.project.core.dto.contractor.ContractorDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceRepairOrderDTO;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by milczu on 09.01.15.
 */
@Named
@ApplicationScoped
public class ServiceRepairOrderConverter implements Converter<ServiceRepairOrder, ServiceRepairOrderDTO> {

    @Inject
    private UserConverter userConverter;

    @Inject
    private ContractorConverter contractorConverter;

    @Override
    public ServiceRepairOrder convertDTO(ServiceRepairOrderDTO objectDTO) {
        if (objectDTO == null) {
            return null;
        }
        User user = userConverter.convertDTO(objectDTO.getDocumentCreator());
        Contractor contractor = contractorConverter.convertDTO(objectDTO.getContractor());

        ServiceRepairOrder entity = new ServiceRepairOrder();
        entity.setDocumentCreator(user);
        entity.setContractor(contractor);
        entity.setDescription(objectDTO.getDescription());
        entity.setEquipentInfo(objectDTO.getEquipentInfo());
        entity.setGuarantee(objectDTO.isGuarantee());
        entity.setGuaranteeNo(objectDTO.getGuaranteeNo());
        entity.setSaleDocumentNo(objectDTO.getSaleDocumentNo());
        entity.setActive(objectDTO.isActive());
        entity.setId(objectDTO.getId());
        entity.setVersion(objectDTO.getVersion());
        entity.setCreationDate(objectDTO.getCreationDate());
        entity.setServiceDocumentType(objectDTO.getServiceDocumentType());
        entity.setState(objectDTO.getState());
        entity.setSymbol(objectDTO.getSymbol());


        return entity;
    }

    @Override
    public ServiceRepairOrderDTO convertEntity(ServiceRepairOrder entity) {
        if (entity == null) {
            return null;
        }
        UserDTO user = userConverter.convertEntity(entity.getDocumentCreator());
        ContractorDTO contractor = contractorConverter.convertEntity(entity.getContractor());

        ServiceRepairOrderDTO dto = new ServiceRepairOrderDTO();
        dto.setDocumentCreator(user);
        dto.setContractor(contractor);
        dto.setDescription(entity.getDescription());
        dto.setEquipentInfo(entity.getEquipentInfo());
        dto.setGuarantee(entity.isGuarantee());
        dto.setGuaranteeNo(entity.getGuaranteeNo());
        dto.setSaleDocumentNo(entity.getSaleDocumentNo());
        dto.setActive(entity.isActive());
        dto.setId(entity.getId());
        dto.setVersion(entity.getVersion());
        dto.setCreationDate(entity.getCreationDate());
        dto.setState(entity.getState());
        dto.setSymbol(entity.getSymbol());

        return dto;
    }
}
