package com.kratonsolution.belian.core.party.impl.orm;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import com.kratonsolution.belian.common.orm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@Getter
@Setter
@Entity
@DiscriminatorValue("Organization")
public class Organization extends Party
{
	public Organization(){}
	
	public Organization(IDValueRef ref)
	{
		if(ref != null)
		{
			setId(ref.getId());
			setName(ref.getValue());
		}
	}
}
