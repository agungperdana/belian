package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;

import com.kratonsolution.belian.party.api.model.CompanyStructureType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class CompanyStructureUpdateCommand implements Serializable {

	private static final long serialVersionUID = 5315672072103634858L;

	@NonNull
	private String code;
	
	private String name;
	
	private CompanyStructureType type;

	private String note;
}
