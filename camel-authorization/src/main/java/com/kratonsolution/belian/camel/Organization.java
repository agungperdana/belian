package com.kratonsolution.belian.camel;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
@Getter
@Setter
public class Organization implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;

	@Override
	public String toString() {
		return this.code;
	}
}
