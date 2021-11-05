package com.kratonsolution.belian.camel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 * @since 1.0.0
 */
@Getter
@Setter
public class Role implements Serializable {

	private static final long serialVersionUID = 1015440221886265079L;

	private String name;

	@Override
	public String toString() {
		return this.name;
	}
}