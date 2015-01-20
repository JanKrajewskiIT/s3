package pl.lodz.p.project.core.service.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocument;
import pl.lodz.p.project.core.dto.document.service.BaseServiceDocumentDTO;

import java.util.List;

/**
 * Created by milczu on 09.01.15.
 */
public interface BaseServiceDocumentService {

    List<ServiceDocument> findAll();
}
