package pl.lodz.p.project.core.converter.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.document.service.ServiceFixSummary;
import pl.lodz.p.project.core.dto.document.service.ServiceFixSummaryDTO;

/**
 * Created by milczu on 21.01.15.
 */
@Component
public class ServiceFixSummaryConverter implements Converter<ServiceFixSummary, ServiceFixSummaryDTO> {

    @Autowired
    private UserConverter userConverter;

    @Override
    public ServiceFixSummary convertDTO(ServiceFixSummaryDTO objectDTO) {
        ServiceFixSummary entity = new ServiceFixSummary();
        entity.setServiceFixOrderSymbol(objectDTO.getServiceFixOrderSymbol());
        entity.setDescription(objectDTO.getDescription());
        entity.setActive(true); // TODO
        entity.setDocumentDate(objectDTO.getDocumentDate());
        entity.setId(objectDTO.getId());
        entity.setIssuePerson(objectDTO.getIssuePerson() == null ? null : userConverter.convertDTO(objectDTO.getIssuePerson()));
        entity.setServiceDocumentType(objectDTO.getServiceDocumentType());
        entity.setState(objectDTO.getState());
        entity.setSymbol(objectDTO.getSymbol());
        entity.setType(objectDTO.getType());
        entity.setVersion(objectDTO.getVersion());

        return entity;
    }

    @Override
    public ServiceFixSummaryDTO convertEntity(ServiceFixSummary entity) {
        ServiceFixSummaryDTO objectDTO = new ServiceFixSummaryDTO();
        objectDTO.setServiceFixOrderSymbol(entity.getServiceFixOrderSymbol());
        objectDTO.setDescription(entity.getDescription());
        objectDTO.setDocumentDate(entity.getDocumentDate());
        objectDTO.setId(entity.getId());
        objectDTO.setIssuePerson(entity.getIssuePerson() == null ? null : userConverter.convertEntity(entity.getIssuePerson()));
        objectDTO.setState(entity.getState());
        objectDTO.setSymbol(entity.getSymbol());
        objectDTO.setType(entity.getType());
        objectDTO.setVersion(entity.getVersion());

        return objectDTO;
    }
}
