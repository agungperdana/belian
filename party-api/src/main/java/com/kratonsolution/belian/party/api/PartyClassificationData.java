package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.kratonsolution.belian.party.api.model.PartyClassificationType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class PartyClassificationData implements Serializable
{
	private static final long serialVersionUID = -3738615250193814386L;

	private String id = UUID.randomUUID().toString();
	
	private Date start = new Date();
	
	private Date end;

	private PartyClassificationType type;

	private String value;
}
