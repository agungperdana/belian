package com.kratonsolution.belian.party.api;

import java.io.Serializable;
import java.util.Date;

import com.kratonsolution.belian.party.api.model.MaritalStatusType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Getter
@Setter
public class MaritalStatusData implements Serializable
{
	private static final long serialVersionUID = 3433856008412192489L;

	private String id;
	
	private Date start;
	
	private Date end;
	
	private MaritalStatusType type = MaritalStatusType.SINGLE;
		
	public MaritalStatusData(){}
}
