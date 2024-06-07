package com.kratonsolution.belian.common.orm;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 1.0.0
 */
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
