package pl.lodz.p.project.core.converter.document;

import pl.lodz.p.project.core.converter.base.Converter;
import pl.lodz.p.project.core.domain.document.base.Document;
import pl.lodz.p.project.core.dto.document.base.DocumentDTO;

/**
 * @author Jan Krajewski
 */
public class DocumentConverter<E extends Document, D extends DocumentDTO> implements Converter<E, D> {

    @Override
    public E convertDTO(D objectDTO) {
        try {
            E entity = (E) Document.class.newInstance();
            return entity;
        } catch (InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public D convertEntity(E entity) {
        try {
            D objectDTO = (D) DocumentDTO.class.newInstance();
            objectDTO.setId(entity.getId());
            return objectDTO;
        } catch (InstantiationException|IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
