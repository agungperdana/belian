package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;
import java.util.Date;

import com.kratonsolution.belian.party.api.model.MaritalStatusType;

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
public class MaritalStatusCreateCommand implements Serializable {

	private static final long serialVersionUID = -2267618775074275933L;

	@NonNull
	private String partyCode;

	@NonNull
	private Date start;

	private Date end;

	@NonNull
	private MaritalStatusType type;
}
