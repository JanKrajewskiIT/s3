package pl.lodz.p.project.core.service;

import pl.lodz.p.project.core.converter.Converter;

import com.google.common.base.Function;

/**
 * 
 * @author Janiu
 *
 * @param <T>
 * @param <D>
 */
public class Transformer<E, D> implements Function<E, D> {
	
	private Converter<E, D> converter;
	
	public Transformer(Converter<E, D> converter) {
		this.converter = converter;
	}

	@Override
	public D apply(E input) {
    	return converter.convertEntity(input);
	}
	
}