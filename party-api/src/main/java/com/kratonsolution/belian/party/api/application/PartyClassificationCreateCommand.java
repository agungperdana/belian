package com.kratonsolution.belian.party.api.application;

import java.io.Serializable;
import java.util.Date;

import com.kratonsolution.belian.party.api.model.PartyClassificationType;

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
public class PartyClassificationCreateCommand implements Serializable {

	private static final long serialVersionUID = -2162448483315018409L;

	@NonNull
	private String partyCode;

	private Date start;

	private Date end;

	private PartyClassificationType type;

	private String value;


}
