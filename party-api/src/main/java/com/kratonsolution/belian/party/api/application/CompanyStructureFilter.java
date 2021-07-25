package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class CompanyStructureFilter implements Serializable {

	private static final long serialVersionUID = -4668723464787436775L;

	private String key;
	
	private Integer page = 0;
	
	private Integer size = 1000;
}
