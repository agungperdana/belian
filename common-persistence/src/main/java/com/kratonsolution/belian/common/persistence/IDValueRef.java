package com.kratonsolution.belian.common.persistence;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

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
	
	public static final IDValueRef toRef(Referenceable referenceable)
	{
		if(referenceable != null)
		{
			IDValueRef ref = new IDValueRef();
			ref.setId(referenceable.getValue());
			ref.setValue(referenceable.getLabel());
			
			return ref;
		}
		
		return null;
	}
	
	public static IDValueRef empty()
	{
		return new IDValueRef();
	}
}
