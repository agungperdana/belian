
package com.kratonsolution.belian.common.persistence;

import java.io.Serializable;

import com.kratonsolution.belian.common.persistence.IDValueRef;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface Referenceable extends Serializable
{
	public String getLabel();
	
	public String getValue();
	
	public default IDValueRef toRef()
	{
		IDValueRef ref = new IDValueRef();
		ref.setId(getValue());
		ref.setValue(getLabel());
		ref.setType(getClass().getSimpleName());
		
		return ref;
	}
	
	public default boolean isValid(IDValueRef ref)
	{
		return ref != null && ref.getId() != null && !ref.getId().equals("");
	}
}
