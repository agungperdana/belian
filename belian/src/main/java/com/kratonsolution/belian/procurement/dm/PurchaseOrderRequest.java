/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.Approveable;
import com.kratonsolution.belian.global.dm.Listable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="purchase_order_request")
public class PurchaseOrderRequest extends Approveable implements Serializable,Listable
{
	public static final String NCODE = "POR";
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PurchaseOrderRequestItem> items = new HashSet<PurchaseOrderRequestItem>();
	
	public PurchaseOrderRequest(){}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.Listable#getLabel()
	 */
	@Override
	public String getLabel()
	{
		return getNumber();
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.Listable#getValue()
	 */
	@Override
	public String getValue()
	{
		return getId();
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.Approveable#getType()
	 */
	@Override
	public String getType()
	{
		return "Purchase Order Request";
	}
}
