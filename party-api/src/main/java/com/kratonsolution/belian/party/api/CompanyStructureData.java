package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class CompanyStructureData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	
	private String key;
		
	private List<CompanyStructureData> children = new ArrayList<>();
}
