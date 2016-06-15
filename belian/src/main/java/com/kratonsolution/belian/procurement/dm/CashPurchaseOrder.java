/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.inventory.dm.Facility;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_purchase_order")
public class CashPurchaseOrder extends PurchaseOrder implements Serializable, Listable
{	
	@ManyToOne
	@JoinColumn(name="fk_facility")
	private Facility facility;
	
	@OneToMany(mappedBy="purchaseOrder",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CashPurchaseOrderItem> items = new HashSet<>();
	
	public CashPurchaseOrder(){}
	
	@Override
	public String getLabel()
	{
		return getNumber();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
