package pl.lodz.p.project.core.converter.document.service;

import org.springframework.stereotype.Component;
import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.document.service.ServiceFixSummary;
import pl.lodz.p.project.core.dto.document.service.ServiceFixSummaryDTO;

/**
 * Created by milczu on 21.01.15.
 */
@Component
public class ServiceFixSummaryConverter implements Converter<ServiceFixSummary, ServiceFixSummaryDTO> {

    @Override
    public ServiceFixSummary convertDTO(ServiceFixSummaryDTO objectDTO) {
        return null;
    }

    @Override
    public ServiceFixSummaryDTO convertEntity(ServiceFixSummary entity) {
        return null;
    }
}
