package com.kratonsolution.belian.companystructure.driver.jms;

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
public class CompanyStructureDeleteCommand {


	@NonNull
	private String partyCode;
}
