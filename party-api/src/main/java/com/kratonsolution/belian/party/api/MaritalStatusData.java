package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.time.Instant;

import com.kratonsolution.belian.party.api.model.MaritalStatusType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since
 */
@Getter
@Setter
public class MaritalStatusData implements Serializable
{
	private static final long serialVersionUID = 3433856008412192489L;

	private Instant start;
	
	private Instant end;
	
	private MaritalStatusType type;
		
	public MaritalStatusData(){}
}
