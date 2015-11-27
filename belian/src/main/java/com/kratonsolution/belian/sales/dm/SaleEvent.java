/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.EconomicResource;
import com.kratonsolution.belian.global.dm.NonMonetaryEvent;
import com.kratonsolution.belian.inventory.dm.Product;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="sale_event")
public class SaleEvent extends NonMonetaryEvent
{
	@ManyToOne
	@JoinColumn(name="sales_person")
	private EconomicAgent salesPerson;
	
	@ManyToOne
	@JoinColumn(name="customer")
	private EconomicAgent customer;

	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Override
	public EconomicAgent getInternal()
	{
		return this.salesPerson;
	}

	@Override
	public EconomicAgent getExternal()
	{
		return this.customer;
	}

	@Override
	public EconomicResource getResource()
	{
		return this.product;
	}
}
