package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.time.Instant;

import com.kratonsolution.belian.party.api.model.PhysicalCharacteristicType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class PhysicalCharacteristicData implements Serializable
{
	private static final long serialVersionUID = -946015937785544608L;

	private Instant start;
	
	private Instant end;
	
	private PhysicalCharacteristicType type;
	
	private String value;
	
	public PhysicalCharacteristicData(){}
}
