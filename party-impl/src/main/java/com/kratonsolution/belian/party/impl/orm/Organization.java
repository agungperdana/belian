
package com.kratonsolution.belian.party.impl.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.kratonsolution.belian.common.persistence.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="organization")
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
