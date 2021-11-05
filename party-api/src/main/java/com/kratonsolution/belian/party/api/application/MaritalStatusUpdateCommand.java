package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;
import java.util.Date;

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
public class MaritalStatusUpdateCommand implements Serializable {

	private static final long serialVersionUID = -571578029275784667L;

	@NonNull
	private String partyCode;

	@NonNull
	private String statusId;
	
	@NonNull
	private Date end;
}
