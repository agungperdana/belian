package com.kratonsolution.belian.companystructure.driver.jms;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
@Getter
@Setter
public class CompanyStructureData {

	private Date start;
	
	private Date end;
	
	private String partyCode;
	
	private String partyName;
	
	private String parentPartyCode;
	
	private String parentPartyName;
	
	private CompanyStructureType type;
}
