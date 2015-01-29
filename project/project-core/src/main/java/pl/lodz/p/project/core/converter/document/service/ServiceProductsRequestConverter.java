package pl.lodz.p.project.core.converter.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.converter.account.UserConverter;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.converter.good.GoodConverter;
import pl.lodz.p.project.core.domain.document.base.InvoiceGoodKey;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequest;
import pl.lodz.p.project.core.domain.document.service.ServiceProductsRequestGood;
import pl.lodz.p.project.core.dto.document.service.ServiceProductRequestItemDTO;
import pl.lodz.p.project.core.dto.document.service.ServiceProductsRequestDTO;

/**
 * Created by milczu on 21.01.15.
 */
@Component
public class ServiceProductsRequestConverter implements Converter<ServiceProductsRequest, ServiceProductsRequestDTO> {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private GoodConverter goodConverter;

    @Override
    public ServiceProductsRequest convertDTO(ServiceProductsRequestDTO objectDTO) {
        ServiceProductsRequest entity = new ServiceProductsRequest();
        entity.setServiceRepairOrderSymbol(objectDTO.getServiceRepairOrderSymbol());

        entity.setActive(true); // TODO
        entity.setDocumentDate(objectDTO.getDocumentDate());
        entity.setId(objectDTO.getId());
        entity.setIssuePerson(objectDTO.getIssuePerson() == null ? null : userConverter.convertDTO(objectDTO.getIssuePerson()));
        entity.setServiceDocumentType(objectDTO.getServiceDocumentType());
        entity.setState(objectDTO.getState());
        entity.setSymbol(objectDTO.getSymbol());
        entity.setType(objectDTO.getType());
        entity.setVersion(objectDTO.getVersion());
        entity.setType(objectDTO.getType());

        for (ServiceProductRequestItemDTO itemDTO : objectDTO.getGoodList()) {
            ServiceProductsRequestGood entityGood = new ServiceProductsRequestGood();
            entityGood.setQuantity(itemDTO.getQuantity());
            InvoiceGoodKey<ServiceProductsRequest> id = new InvoiceGoodKey<>();
            id.setInvoice(entity);
            id.setGood(goodConverter.convertDTO(itemDTO.getGood()));
            entityGood.setId(id);
            entity.getItems().add(entityGood);
        }
        return entity;
    }

    @Override
    public ServiceProductsRequestDTO convertEntity(ServiceProductsRequest entity) {
        ServiceProductsRequestDTO objectDTO = new ServiceProductsRequestDTO();
        objectDTO.setServiceRepairOrderSymbol(entity.getServiceRepairOrderSymbol());
        objectDTO.setDocumentDate(entity.getDocumentDate());
        objectDTO.setId(entity.getId());
        objectDTO.setIssuePerson(entity.getIssuePerson() == null ? null : userConverter.convertEntity(entity.getIssuePerson()));
        objectDTO.setState(entity.getState());
        objectDTO.setSymbol(entity.getSymbol());
        objectDTO.setType(entity.getType());
        objectDTO.setVersion(entity.getVersion());

        for (ServiceProductsRequestGood entityGood : entity.getItems()) {
            ServiceProductRequestItemDTO itemDTO = new ServiceProductRequestItemDTO();
            itemDTO.setDocument(objectDTO);
            itemDTO.setGood(goodConverter.convertEntity(entityGood.getId().getGood()));
            itemDTO.setQuantity(entityGood.getQuantity());
        }

        return objectDTO;
    }
}