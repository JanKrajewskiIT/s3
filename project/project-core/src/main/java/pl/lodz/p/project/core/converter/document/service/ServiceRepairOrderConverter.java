package pl.lodz.p.project.core.converter.document.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.base.Converter;
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
 * @author Milczu
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
        User user = userConverter.convertDTO(objectDTO.getIssuePerson());
        Contractor contractor = objectDTO.getContractor() == null ? null : contractorConverter.convertDTO(objectDTO.getContractor());

        ServiceRepairOrder entity = new ServiceRepairOrder();
        entity.setIssuePerson(user);
        entity.setContractor(contractor);
        entity.setDescription(objectDTO.getDescription());
        entity.setEquipmentInfo(objectDTO.getEquipmentInfo());
        entity.setGuarantee(objectDTO.isGuarantee());
        entity.setGuaranteeNo(objectDTO.getGuaranteeNo());
        entity.setSaleDocumentNo(objectDTO.getSaleDocumentNo());
        entity.setId(objectDTO.getId());
        entity.setVersion(objectDTO.getVersion());
        entity.setDocumentDate(objectDTO.getDocumentDate());
        entity.setServiceDocumentType(objectDTO.getServiceDocumentType());
        entity.setState(objectDTO.getState());
        entity.setSymbol(objectDTO.getSymbol());
        LoggerFactory.getLogger(getClass()).debug("entity ID: {}", entity.getId());

        return entity;
    }

    @Override
    public ServiceRepairOrderDTO convertEntity(ServiceRepairOrder entity) {
        if (entity == null) {
            return null;
        }
        UserDTO user = userConverter.convertEntity(entity.getIssuePerson());
        ContractorDTO contractor = entity.getContractor() == null ? null : contractorConverter.convertEntity(entity.getContractor());

        ServiceRepairOrderDTO objectDTO = new ServiceRepairOrderDTO();
        objectDTO.setIssuePerson(user);
        objectDTO.setContractor(contractor);
        objectDTO.setDescription(entity.getDescription());
        objectDTO.setEquipmentInfo(entity.getEquipmentInfo());
        objectDTO.setGuarantee(entity.isGuarantee());
        objectDTO.setGuaranteeNo(entity.getGuaranteeNo());
        objectDTO.setSaleDocumentNo(entity.getSaleDocumentNo());
        objectDTO.setId(entity.getId());
        objectDTO.setVersion(entity.getVersion());
        objectDTO.setDocumentDate(entity.getDocumentDate());
        objectDTO.setState(entity.getState());
        objectDTO.setSymbol(entity.getSymbol());

        return objectDTO;
    }
}
