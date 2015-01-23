package pl.lodz.p.project.core.dao.document.service;

import pl.lodz.p.project.core.domain.document.service.ServiceDocument;

import java.util.List;

/**
 * Created by milczu on 20.01.15.
 */
public interface BaseServiceDocumentDao {

    List<ServiceDocument> findAll();
}
