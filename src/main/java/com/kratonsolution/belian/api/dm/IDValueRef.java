/**
 * 
 */
package com.kratonsolution.belian.api.dm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Embeddable
public class IDValueRef implements Serializable
{
	@Column(name="id")
	private String id;

	@Column(name="value")
	private String value;
	
	@Transient
	private String type;
	
	public static final IDValueRef toRef(Referenceable listable)
	{
		if(listable != null)
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(listable.getValue());
			ref.setValue(listable.getLabel());
			
			return ref;
		}
		
		return null;
	}
	
	public static IDValueRef empty()
	{
		return new IDValueRef();
	}
}
