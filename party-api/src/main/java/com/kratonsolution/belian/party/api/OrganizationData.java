package com.kratonsolution.belian.party.api;

import java.io.Serializable;

import com.kratonsolution.belian.common.model.Auditable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class OrganizationData extends Auditable implements Serializable
{
	private static final long serialVersionUID = -8776380253280140352L;
	
	private PartyData party;
	
	public OrganizationData(){}
}
