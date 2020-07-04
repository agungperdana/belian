package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.util.UUID;

import com.kratonsolution.belian.party.api.model.ContactType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Setter
public class ContactData implements Serializable
{
	private static final long serialVersionUID = -3119257260126834977L;

	private final String dataID = UUID.randomUUID().toString();
	
	private String contact;

	private ContactType type;
	
	private boolean active;
	
	public ContactData(){}
}
