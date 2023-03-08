/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.api.dm.IDValueRef;

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
