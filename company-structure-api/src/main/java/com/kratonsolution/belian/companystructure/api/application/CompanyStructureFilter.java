package com.kratonsolution.belian.companystructure.api.application;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
@Getter
@Setter
public class CompanyStructureFilter {

	private String key;

	private Integer page = 0;

	private Integer size = 1000;
	
	private boolean root = false;
}
