package pl.lodz.p.project.core.converter.base;

/**
 *
 * @author Milczu
 * @param <E> - entity
 * @param <D> - DTO
 */
public interface Converter<E, D> {
    
    E convertDTO(D objectDTO);
    
    D convertEntity(E entity);
}
