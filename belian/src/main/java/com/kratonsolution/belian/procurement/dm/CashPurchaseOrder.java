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

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.global.dm.ProductReceiveable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_purchase_order")
public class CashPurchaseOrder extends ProductReceiveable implements Serializable, Listable
{
	public static final String NCODE = "CSPO";
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private EconomicAgent supplier;//try commit
	
	@ManyToOne
	@JoinColumn(name="fk_purchaser")
	private Person purchaser;

	@ManyToOne
	@JoinColumn(name="fk_purchaser_order_request")
	private PurchaseOrderRequest request;
	
	@OneToMany(mappedBy="purchaseOrder",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<CashPurchaseOrderItem> items = new HashSet<>();
	
	public CashPurchaseOrder(){}
	
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

	@Override
	public String getType()
	{
		return "Cash Purchase Order";
	}
}
