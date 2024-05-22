package com.kratonsolution.belian.partys.dm;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.kratonsolution.belian.api.dm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="organization")
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
