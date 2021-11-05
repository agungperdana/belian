package com.kratonsolution.belian.companystructure.driver.jms;

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
public class CompanyStructureCreateCommand {

	@NonNull
	private Date start;

	private Date end;

	@NonNull
	private String partyCode;

	@NonNull
	private String partyName;

	private String parentPartyCode;

	private String parentPartyName;

	@NonNull
	private CompanyStructureType type;
}
