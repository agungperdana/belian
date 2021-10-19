package com.kratonsolution.belian.companystructure.api.application;

import java.util.Date;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
@Getter
@Setter
public class CompanyStructureUpdateCommand {


	@NonNull
	private String partyCode;
	
	private Date end;

	private String parentPartyCode;

	private String parentPartyName;
}
