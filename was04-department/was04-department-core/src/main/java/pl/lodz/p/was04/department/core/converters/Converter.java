package pl.lodz.p.was04.department.core.converters;

/**
 *
 * @author milczu
 * @param <E> - entity
 * @param <D> - DTO
 */
public interface Converter<E, D> {
    
    E convertDTO(D objectDTO);
    
    D convertEntity(E entity);
}
