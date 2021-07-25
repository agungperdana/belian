package com.kratonsolution.belian.common.jpa;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import lombok.Getter;
import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public class SpecificationBuilder<M> {

	public enum Operator {AND, OR}
	
	@Getter
	private Optional<Specification<M>> parent = null;
	
	public void combine(@NonNull Specification<M> spec, Operator op) {
		
		if(parent == null) {
			parent = Optional.ofNullable(spec);
		}
		else {
			
			if(op.equals(Operator.AND)) {
				parent.get().and(spec);
			}
			else {
				parent.get().or(spec);
			}
		}
	}
}
