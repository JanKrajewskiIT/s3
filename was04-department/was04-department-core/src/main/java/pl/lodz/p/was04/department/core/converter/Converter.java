package pl.lodz.p.was04.department.core.converter;

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
